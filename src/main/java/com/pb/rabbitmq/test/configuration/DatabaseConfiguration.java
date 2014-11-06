package com.pb.rabbitmq.test.configuration;


import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author: Andrzej Gdula
 * @created: 11/05/2014 09:16
 * @version: 1.0
 */
@Configuration
public class DatabaseConfiguration {
    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase(){
            @Override
            protected Database createDatabase(Connection c) throws DatabaseException {
                Database database = super.createDatabase(c);
                database.setDatabaseChangeLogTableName("FM_SIM_CHANGELOG");
                database.setDatabaseChangeLogTableName("FM_SIM_CHANGELOG_LOCK");
                return database;
            }
        };
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:liquibase/master.xml");
        return liquibase;
    }
}
