package com.DCC.skarf.api.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
	
	@Autowired
	SSHConfig sshConfig = new SSHConfig();
	
	public String getSSHPrivatekeyPath() {
		return sshConfig.getPrivatekeylocation();
	}

}
