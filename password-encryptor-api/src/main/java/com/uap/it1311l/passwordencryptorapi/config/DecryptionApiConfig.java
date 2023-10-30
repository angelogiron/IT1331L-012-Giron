package com.uap.it1311l.passwordencryptorapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.uap.it1311l.passwordencryptorapi.webclient.DecryptionApiClient;

@Configuration
public class DecryptionApiConfig {
    @Bean
    DecryptionApiClient decryptionApi() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://encryption-api1.p.rapidapi.com/api/Cryptor/decryptstring")
                .defaultHeader("X-RapidAPI-Key", "03e26d7cabmsh65f9fe31960f960p15e370jsnabe6e3e30f69")
                .defaultHeader("X-RapidAPI-Host", "encryption-api1.p.rapidapi.com")
                .build();

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();

        return httpServiceProxyFactory.createClient(DecryptionApiClient.class);
    }
}
