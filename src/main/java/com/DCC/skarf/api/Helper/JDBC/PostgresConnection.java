package com.DCC.skarf.api.Helper.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.DCC.skarf.api.Helper.SSH.SSHTunnel;

public class PostgresConnection {
	
	private SSHTunnel sshConnection = new SSHTunnel();
	
	public void startJDBC() {
		sshConnection.startSSHTunnel(); // System will stop if failed
		
		Connection con = null;
		String url = "jdbc:postgresql://" + SSHTunnel.rhost +":" + SSHTunnel.lport + "/metrics";
		Properties props = new Properties();
		props.setProperty("user","api");
		props.setProperty("password","O4VXZMoqFrBy7lt5p3Qj");
		props.setProperty("ssl","false");
		try {
			con = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			sshConnection.stopSSHTunnel();
			System.out.println(e.toString());
			System.exit(1);
		}
		
		try {
			Statement st = con.createStatement();
			String sql = "select api_select_search()";
			ResultSet rs = st.executeQuery(sql);
			con.close();
			sshConnection.stopSSHTunnel();
			rs.next();
			System.out.println(rs.getString(1));
		} catch (SQLException e) {
			try {
				con.close();
			} catch (SQLException e1) {
				System.out.println(e.toString());
			}
			sshConnection.stopSSHTunnel();
			System.out.println(e.toString());
			System.exit(1);
		}
	}


}
