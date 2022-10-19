package io.inhibitor.services;

import com.codahale.metrics.health.HealthCheck;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TemplateHealthCheck extends HealthCheck {

  @NotNull
  private final String template;

  @Override
  protected Result check() throws Exception {
    final String saying = String.format(template, "TEST");
    if (!saying.contains("TEST")) {
      return Result.unhealthy("template doesn't include a name");
    }
    return Result.healthy();
  }
}
