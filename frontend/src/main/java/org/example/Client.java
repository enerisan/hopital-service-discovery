package org.example;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Client {

    private final RestTemplate restTemplate;

    public Client(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getResponse(Long id) {
        return restTemplate.getForObject("http://patient-service/patient/{id}", String.class, id);
    }
}

