package com.DCC.skarf.api.Helper.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.DCC.skarf.api.Helper.SSH.SSHTunnel;

public class PostgresConnection {
	
	private SSHTunnel sshConnection = new SSHTunnel();
	private Connection db_con = null;
	
	private void startJDBC() {
		sshConnection.startSSHTunnel(); // System will stop if failed
		
		String url = "jdbc:postgresql://" + SSHTunnel.rhost +":" + SSHTunnel.lport + "/metrics";
		Properties props = new Properties();
		props.setProperty("user","api");
		props.setProperty("password","O4VXZMoqFrBy7lt5p3Qj");
		props.setProperty("ssl","false");
		
		try {
			db_con = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			sshConnection.stopSSHTunnel();
			System.out.println(e.toString());
			System.exit(1);
		}
	}
	
	public void stopJDBC() {
		try {
			db_con.close();
		} catch (SQLException e) {
			sshConnection.stopSSHTunnel();
			System.out.println(e.toString());
			System.exit(1);
		}
		sshConnection.stopSSHTunnel();
	}
	
	public String[] get_grafana_search_element() {
		
		this.startJDBC();
		ResultSet rs = null;
		List<String> ResultString = new ArrayList<String>();
		try {
			Statement st = db_con.createStatement();
			String sql = "select api_select_search()";
			rs = st.executeQuery(sql);
			this.stopJDBC();
			while (rs.next()) {
				ResultString.add(rs.getString(1));
			}
			return ResultString.toArray(new String[0]);
		} catch (SQLException e) {
			this.stopJDBC();
			System.out.println(e.toString());
			return new String[] {"ERROR SELECT"};
		}
	
	}


}
