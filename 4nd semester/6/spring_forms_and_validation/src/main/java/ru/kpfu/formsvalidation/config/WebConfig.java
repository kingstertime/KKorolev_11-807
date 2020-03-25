package ru.kpfu.formsvalidation.config;

import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"ru.kpfu.formsvalidation.controller"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

//  @Bean
//  public ViewResolver viewResolver() {
//    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//    resolver.setPrefix("/WEB-INF/jsp/");
//    resolver.setSuffix(".jsp");
//    resolver.setViewClass(JstlView.class);
//    resolver.setRedirectContextRelative(false);
//    return resolver;
//
//  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
   // registry.addViewController("/").setViewName("index");
    registry.addViewController("/").setViewName("test");
  }

  @Bean
  public ViewResolver viewResolver () {
    JtwigViewResolver viewResolver = new JtwigViewResolver();
    viewResolver.setRenderer(JtwigRenderer.defaultRenderer());
    viewResolver.setPrefix("/WEB-INF/twig/");
    viewResolver.setSuffix(".twig");
    return viewResolver;
  }
}
