package com.pb.rabbitmq.test

/** **************************************************************************/
/*                                                                          */
/*  NOTICE                                                                  */
/*                                                                          */
/* Confidential, unpublished property of Pitney Bowes, Inc.                 */
/* Use and distribution limited solely to authorized personnel.             */
/*                                                                          */
/* The use, disclosure, reproduction, modification, transfer, or            */
/* transmittal of this work for any purpose in any form or by               */
/* any means without the written permission of Pitney Bowes                 */
/* is strictly prohibited.                                                  */
/*                                                                          */
/* Copyright 2014 Pitney Bowes, Inc.                                     */
/* All Rights Reserved.                                                     */
/*                                                                          */
/** **************************************************************************/

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
