package com.example.riotapi.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "riot.api")
@Getter
@Setter
public class RiotApiProperties {
    private String key;
    private String baseHost;
    private String protocol;

    @NestedConfigurationProperty
    private Regions regions = new Regions();

    public String buildUrl(String region) {
        return String.format("%s://%s.%s/", protocol, region, baseHost);
    }

    @Getter
    @Setter
    public static class Regions {
        private String euw1;
        private String europe;
        private String eun1;
    }
}