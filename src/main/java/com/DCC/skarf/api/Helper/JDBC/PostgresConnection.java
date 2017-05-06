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

	private Connection db_con = null;

	private void startJDBC() {
		String url = "jdbc:postgresql://" + SSHTunnel.rhost + ":" + SSHTunnel.lport + "/metrics";
		Properties props = new Properties();
		props.setProperty("user", "api");
		props.setProperty("password", "O4VXZMoqFrBy7lt5p3Qj");
		props.setProperty("ssl", "false");

		try {
			db_con = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.exit(1);
		}
	}

	public void stopJDBC() {
		try {
			db_con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.exit(1);
		}
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
			return new String[] { "ERROR SELECT" };
		}

	}

	public List<String[]> get_grafana_query_element(String s_plugin, String s_type_instance, String unixFrom,
			String unixTo) {
		this.startJDBC();
		ResultSet rs = null;
		List<String[]> output = new ArrayList<String[]>();
		try {
			Statement st = db_con.createStatement();
			String sql = "select api_select_query_with_value('ci-slave2', '" + s_plugin + "', '" + s_type_instance
					+ "', " + unixFrom + ", " + unixTo + ")";
			rs = st.executeQuery(sql);
			this.stopJDBC();
			while (rs.next()) {
				try {
					output.add(rs.getString(1).substring(1, (rs.getString(1).length() - 1)).split(","));
				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
			return output;
		} catch (SQLException e) {
			this.stopJDBC();
			System.out.println(e.toString());
			return output;
		}
	}

}
