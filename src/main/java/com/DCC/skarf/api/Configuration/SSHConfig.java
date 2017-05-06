package com.DCC.skarf.api.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ssh")
public class SSHConfig {
	
	private String privatekeylocation;
	
	public String getPrivatekeylocation() {
		return privatekeylocation;
	}

	public void setPrivatekeylocation(String privatekeylocation) {
		this.privatekeylocation = privatekeylocation;
	}

}
