package com.promotion.engine.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;

public class ConfigLoader {
    private static class HelperHolder {
        protected static final ConfigLoader externalConfig = new ConfigLoader();
    }

    private Configuration configurationProperties;

    private ConfigLoader() {
        initConfigurationProperties();
    }

    public static ConfigLoader getInstance() {
        return HelperHolder.externalConfig;
    }

    public Configuration getConfigurationProperties() {
        return configurationProperties;
    }

    private void initConfigurationProperties() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            //mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
            InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("promotion-engine-config.yaml");
            this.configurationProperties = mapper.readValue(inputStream, Configuration.class);
        } catch (IOException exception) {
            throw new IllegalStateException("Config not initialized properly.");
        }
    }
}
