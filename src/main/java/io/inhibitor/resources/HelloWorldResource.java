package io.inhibitor.resources;

import com.codahale.metrics.annotation.Timed;
import io.inhibitor.DropwizardTutorialConfiguration;
import io.inhibitor.models.Saying;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

  private final DropwizardTutorialConfiguration configuration;

  private final AtomicLong counter = new AtomicLong();

  @Inject
  HelloWorldResource(DropwizardTutorialConfiguration configuration) {
    this.configuration = configuration;
  }

  @GET
  @Timed
  public Saying sayHello(@QueryParam("name") @Nullable String name) {
    return Saying.builder()
        .id(counter.incrementAndGet())
        .content(String.format(configuration.getTemplate(),
            Optional.ofNullable(name).orElse(configuration.getDefaultName())))
        .build();
  }
}
