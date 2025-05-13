package com.mmm.micros.mshellocicdaws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${custom-prop.my-value-1:}")
    private String myValue1;

    @Autowired
    private Environment environment;


    @GetMapping("/")
    public String home() {
        String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        return "<h1>Server is online!</h1> <h3>"+formattedDate+"</h3>";
    }

    @GetMapping("/properties")
    public Map getProperties() {
        Map response = new HashMap();
        response.put("my-value-1", myValue1);
        response.put("my-value-2", System.getenv("custom-prop.my-value-2")); // no busca en application.properties
        response.put("my-value-3", environment.getProperty("custom-prop.my-value-3"));
        return response;
    }

}
