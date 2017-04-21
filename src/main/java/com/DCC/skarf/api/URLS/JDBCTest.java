package com.DCC.skarf.api.URLS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DCC.skarf.api.DataObjects.ApiResponse;
import java.sql.*;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Controller
@RequestMapping("/test")
public class JDBCTest {
	
	static int lport;
    static String rhost;
    static int rport;
    Session session;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody ApiResponse testConnection() {
		return new ApiResponse(4, this.startJDBC());
	}
	
	public String startJDBC() {
		if (this.startSSH() != "ok")
			return "SSH Tunneling failed";
		
		Connection con = null;
		String url = "jdbc:postgresql://" + rhost +":" + lport + "/metrics";
		Properties props = new Properties();
		props.setProperty("user","metrics");
		props.setProperty("password","thisISthePassword4711");
		props.setProperty("ssl","false");
		try {
			con = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			this.stopSSH();
			return "DriverManager: " + e.toString();
		}
		
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM public.measurement_master LIMIT 10";
			ResultSet rs = st.executeQuery(sql);
			con.close();
			this.stopSSH();
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			try {
				con.close();
			} catch (SQLException e1) {
				return "con close: " + e1.toString();
			}
			this.stopSSH();
			return "select: " + e.toString();
		}
	}
	
	public String startSSH() {
		String user = "postgres";
        String host = "ci-slave2.virtapi.org";
        int port=22;
        String privatekey = "C:\\Users\\Garfield\\.ssh\\id_rsa";
        
        try
        {
	        JSch jsch = new JSch();
	        jsch.addIdentity(privatekey);
	        session = jsch.getSession(user, host, port);
	        session.setConfig("StrictHostKeyChecking", "no");
	        //session.setPassword("");
	        session.connect();
	        
	        
	        lport = 8740;
	        rhost = "localhost";
	        rport = 5432;
	        session.setPortForwardingL(lport, rhost, rport);
	    }
	    catch(Exception e)
        {
	    	return e.toString();
	    }
        
        return "ok";
	}
	
	public void stopSSH() {
		session.disconnect();
	}
}
