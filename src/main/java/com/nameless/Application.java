package com.nameless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.nameless.properties.JdbcProp;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.nameless")
@EntityScan(basePackages="com.nameless.entity")
@EnableJpaRepositories(basePackages="com.nameless.repository")
@EnableTransactionManagement
@EnableConfigurationProperties({JdbcProp.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
