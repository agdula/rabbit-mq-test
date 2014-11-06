package com.pb.rabbitmq.test


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Andrzej Gdula
 * @created: 11/05/2014 08:45 
 * @version: 1.0
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.pb.rabbitmq.repository")
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@ComponentScan(value = "com.pb.rabbitmq")
class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
