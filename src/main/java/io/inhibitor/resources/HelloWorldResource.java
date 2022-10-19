package io.inhibitor.resources;

import com.codahale.metrics.annotation.Timed;
import io.inhibitor.models.Saying;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class HelloWorldResource {

  @NotNull
  private final String defaultName;

  @NotNull
  private final String template;

  private final AtomicLong counter = new AtomicLong();

  @GET
  @Timed
  public Saying sayHello(@QueryParam("name") @Nullable String name) {
    return Saying.builder()
        .id(counter.incrementAndGet())
        .content(String.format(template, Optional.ofNullable(name).orElse(defaultName)))
        .build();
  }
}
