package com.nameless.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("jdbcProp")
@ConfigurationProperties(locations = "classpath:jdbc.properties",prefix="jdbc")
public class JdbcProp {
	
	public String getHelloworld() {
		return helloworld;
	}

	public void setHelloworld(String helloworld) {
		this.helloworld = helloworld;
	}

	private String helloworld ;
	
}
