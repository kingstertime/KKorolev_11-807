package ru.kpfu.formsvalidation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.formsvalidation.captcha.CaptchaGenerator;

@Configuration
@ComponentScan(basePackages = {"ru.kpfu.formsvalidation.model"})
public class RootConfig{

    @Bean
    public CaptchaGenerator captchaGenerator() {
        return new CaptchaGenerator(5);
    }
}
