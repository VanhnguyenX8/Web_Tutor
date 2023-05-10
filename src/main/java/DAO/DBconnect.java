package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
 protected Connection con;
 public DBconnect() {
	 
	 try {
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sanpham", "root",
					"pass_cua_ban");
		 System.out.print("Ket noi thanh cong voi csdl");
	 }catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("Ket noi that bai voi csdl");
			System.err.print(e.getMessage() + "\n" + e.getClass() + "\n" + e.getCause());
			e.printStackTrace();
		}
 }
}
