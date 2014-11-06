package com.pb.rabbitmq.test.routes

import org.apache.camel.Exchange
import org.apache.camel.builder.RouteBuilder
import static org.apache.camel.component.rabbitmq.RabbitMQConstants.*
import org.apache.camel.component.rabbitmq.RabbitMQEndpoint
import org.springframework.stereotype.Component

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
/**
 * @author: Andrzej Gdula
 * @created: 11/05/2014 09:01 
 * @version: 1.0
 */
@Component
class RabbitMQTest extends RouteBuilder{
    @Override
    void configure() throws Exception {
         from("stream:in?promptMessage=Enter something: ")
         .process { Exchange e ->
             e.in.with {
                 setHeader(ROUTING_KEY, getBody(String.class).contains("u") ? "upper" : "lower")
                 setHeader(DELIVERY_MODE, /*presistent*/ 2)
             }
         }
         .to("rabbitmq://localhost:5672/smalltalk?queue=producerQ")

         from("rabbitmq://localhost:5672/smalltalk?queue=consumerQ1&routingKey=upper")
         .transform {
             Exchange it -> it.in.getBody(String.class).toUpperCase()
         }
         .to("stream:out")

         from("rabbitmq://localhost:5672/smalltalk?queue=consumerQ2&routingKey=lower")
         .transform {
             Exchange it -> it.in.getBody(String.class).toLowerCase()
         }
         .to("stream:out")
    }
}
