package io.inhibitor;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
    // TODO
  }

  @Override
  public void run(DropwizardTutorialConfiguration configuration, Environment environment) {
    // TODO
  }
}
