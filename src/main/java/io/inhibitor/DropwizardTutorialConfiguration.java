package io.inhibitor;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class DropwizardTutorialConfiguration extends Configuration {

  @JsonProperty
  @NotEmpty
  private String template;

  @JsonProperty
  @NotEmpty
  private String defaultName = "Stranger";
}
