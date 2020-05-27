package com.example.demo;

import com.example.demo.app1.Application1;
import com.example.demo.app2.Application2;
import com.example.demo.context.GameConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(GameConfiguration.class).web(WebApplicationType.NONE)
                .child(Application1.class).web(WebApplicationType.NONE)
                .sibling(Application2.class).web(WebApplicationType.NONE)
                .run(args);
    }


}
