package com.promotion.engine.configuration;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ConfigLoaderTest {

  private static final Configuration configurationProperties =
      ConfigLoader.getInstance().getConfigurationProperties();

  @Test
  public void testConfig() {
    assertFalse(configurationProperties.getProducts().isEmpty());
  }

}