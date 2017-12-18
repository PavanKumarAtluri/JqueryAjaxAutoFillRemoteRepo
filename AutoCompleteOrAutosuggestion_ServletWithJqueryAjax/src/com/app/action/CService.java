package com.app.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CService {
	public ArrayList<String> getAllCountriesCheck(String l) {
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		Connection con = null;
		String data;
		try {
			String ch = l + "%";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			ps = con.prepareStatement("SELECT name FROM countries  WHERE name  LIKE '" + ch + "'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getString(1);
				System.out.println(data);
				list.add(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
