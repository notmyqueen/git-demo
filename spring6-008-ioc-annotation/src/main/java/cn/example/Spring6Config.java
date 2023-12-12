package cn.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"cn.example.dao","cn.example.service"})
public class Spring6Config {
}
