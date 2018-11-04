package model.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;

	public void open() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?useTimezone=true&serverTimezone=UTC", "root", "1234");
	}
}
