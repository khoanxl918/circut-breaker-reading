package com.example.routingandfiltering.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        return restTemplate.getForObject("http://localhost:9090/recommended", String.class);
    }

    public String reliable() {
        return "fallback: Cloud Native Java (O'Reilly)";
    }
}
