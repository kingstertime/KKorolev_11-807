package com.example.demo.app1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.demo.app1")
@PropertySource("classpath:telegram.properties")
public class TelegramConfiguration {

}
