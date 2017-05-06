package com.DCC.skarf.api.Helper.SSH;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSHTunnel {
		
	public static final int lport = 8740;
	public static final String rhost = "localhost";
	public static final int rport = 5432;
    private Session ssh_session;
    private String ssh_user = "postgres";
    private String ssh_host = "ci-slave2.virtapi.org";
    private int ssh_port = 22;
    private String ssh_privatekey_path = "C:\\Users\\Garfield\\.ssh\\id_rsa";
    private String ssh_password = "";
    
    public SSHTunnel() {
    	// Nothing
    }
	
	public boolean startSSHTunnel() {
        try
        {
	        JSch jsch = new JSch();
	        // SSH Settings
	        if (ssh_privatekey_path != "")
	        	jsch.addIdentity(ssh_privatekey_path);
	        ssh_session = jsch.getSession(ssh_user, ssh_host, ssh_port);
	        ssh_session.setConfig("StrictHostKeyChecking", "no");
	        if (ssh_password != "")
	        	ssh_session.setPassword("");
	        
	        // SSH Connect
	        ssh_session.connect();
	        
	        // SSH Tunnel Connect
	        ssh_session.setPortForwardingL(lport, rhost, rport);
	    }
	    catch(Exception e)
        {
	    	System.out.println(e.toString());
	    	System.exit(1);
	    	return false;
	    }
        
        return true;
	}
	
	public void stopSSHTunnel() {
		ssh_session.disconnect();
	}
	
	/* Getter Setter */

	public String getSsh_user() {
		return ssh_user;
	}

	public void setSsh_user(String ssh_user) {
		this.ssh_user = ssh_user;
	}

	public String getSsh_host() {
		return ssh_host;
	}

	public void setSsh_host(String ssh_host) {
		this.ssh_host = ssh_host;
	}

	public int getSsh_port() {
		return ssh_port;
	}

	public void setSsh_port(int ssh_port) {
		this.ssh_port = ssh_port;
	}

	public String getSsh_privatekey_path() {
		return ssh_privatekey_path;
	}

	public void setSsh_privatekey_path(String ssh_privatekey_path) {
		this.ssh_privatekey_path = ssh_privatekey_path;
	}

	public String getSsh_password() {
		return ssh_password;
	}

	public void setSsh_password(String ssh_password) {
		this.ssh_password = ssh_password;
	}

}
