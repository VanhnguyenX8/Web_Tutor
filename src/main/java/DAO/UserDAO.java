package DAO;

import java.security.AlgorithmParametersSpi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DBconnect {
	public String getNameFromDatabase(String username) throws SQLException{
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String Name = null;
	    try {
	        // Chuẩn bị câu truy vấn
	        String query = "SELECT tenGS FROM giasu WHERE username = ?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, username);
	        // Thực thi câu truy vấn
	        resultSet = statement.executeQuery();
	        // Xử lý kết quả truy vấn
	        if (resultSet.next()) {
	            Name = resultSet.getString("tenGS");
	        }
	        return Name;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ và thông báo lỗi
	    }
	    return null;
	}
	public String getEmailFromDatabase(String username) throws SQLException{
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String email = null;
	    try {
	        // Chuẩn bị câu truy vấn
	        String query = "SELECT email FROM giasu WHERE username = ?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, username);
	        // Thực thi câu truy vấn
	        resultSet = statement.executeQuery();
	        // Xử lý kết quả truy vấn
	        if (resultSet.next()) {
	            email = resultSet.getString("email");
	        }
	        return email;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ và thông báo lỗi
	    }
	    return null;
	}
}
