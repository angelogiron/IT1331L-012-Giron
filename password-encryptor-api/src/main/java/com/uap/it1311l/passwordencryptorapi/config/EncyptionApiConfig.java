package com.uap.it1311l.passwordencryptorapi.config;

import org.springframework.context.annotation.Configuration;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class EncyptionApiConfig {
	@Bean
    EncryptionApiClient encryptionApi() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://encryption-api1.p.rapidapi.com/api/Cryptor")
                .defaultHeader("X-RapidAPI-Key", "f369b503a3msh3cadf0e9d1c4511p15e3ebjsnd88d3b27a770")
                .defaultHeader("X-RapidAPI-Host", "encryption-api1.p.rapidapi.com")
                .build();

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();
        return httpServiceProxyFactory.createClient(EncryptionApiClient.class);
    }

}
