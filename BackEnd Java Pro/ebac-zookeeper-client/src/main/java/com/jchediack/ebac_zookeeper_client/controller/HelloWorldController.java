package com.jchediack.ebac_zookeeper_client.controller;

import com.jchediack.ebac_zookeeper_client.client.HelloWorldClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class HelloWorldController {

    @Autowired
    private HelloWorldClient helloWorldClient;

    @GetMapping("/greetings")
    public String helloWorld() {
        return helloWorldClient.HelloWorld();
    }

}
