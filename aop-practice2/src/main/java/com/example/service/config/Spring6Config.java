package com.example.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.example.service"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Spring6Config {

}
