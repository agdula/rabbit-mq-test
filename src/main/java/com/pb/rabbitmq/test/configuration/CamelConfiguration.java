package com.pb.rabbitmq.test.configuration;
/****************************************************************************/
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
/****************************************************************************/

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Andrzej Gdula
 * @created: 11/05/2014 08:58
 * @version: 1.0
 */
@ComponentScan("com.pb.rabbitmq.test.routes")
@Configuration
public class CamelConfiguration {

}
