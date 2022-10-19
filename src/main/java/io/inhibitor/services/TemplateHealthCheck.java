package io.inhibitor.services;

import io.inhibitor.DropwizardTutorialConfiguration;
import javax.inject.Inject;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;

public class TemplateHealthCheck extends NamedHealthCheck {

  private final DropwizardTutorialConfiguration config;

  @Inject
  public TemplateHealthCheck(DropwizardTutorialConfiguration config) {
    this.config = config;
  }

  @Override
  protected Result check() throws Exception {
    final String saying = String.format(config.getTemplate(), "TEST");
    if (!saying.contains("TEST")) {
      return Result.unhealthy("template doesn't include a name");
    }
    return Result.healthy();
  }

  @Override
  public String getName() {
    return "template";
  }
}
