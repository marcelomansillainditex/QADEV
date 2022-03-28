package com.qadev.automation;

import com.qadev.automation.restClient.PetStoreRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:api.properties")
public class TestApplicationConfiguration {
    @Value("${api.base.uri}")
    private String apiBaseUri;

    @Value("${api.base.path}")
    private String apiBasePath;

    @Value("${api.key}")
    private String apiKey;

    @Bean
    public PetStoreRestClient petStoreRestClient() {
        return new PetStoreRestClient(apiBaseUri, apiBasePath, apiKey);
    }
}
