package io.inhibitor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.inhibitor.resources.HelloWorldResource;
import io.inhibitor.services.TemplateHealthCheck;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.HealthCheckInstaller;

public class DropwizardTutorialApplication extends Application<DropwizardTutorialConfiguration> {

  public static void main(String[] args) throws Exception {
    new DropwizardTutorialApplication().run(args);
  }

  @Override
  public String getName() {
    return "dropwizard-tutorial";
  }

  @Override
  public void initialize(Bootstrap<DropwizardTutorialConfiguration> bootstrap) {
    bootstrap.setConfigurationSourceProvider(
        new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
            new EnvironmentVariableSubstitutor(false)));

    bootstrap.addBundle(
        GuiceBundle.builder()
            .enableAutoConfig("io.inhibitor.resources", "io.inhibitor.services")
            .build()
    );
  }

  @Override
  public void run(DropwizardTutorialConfiguration configuration, Environment environment) {}
}
