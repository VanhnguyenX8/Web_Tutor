package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
 protected Connection con;
 public DBconnect() {
	 
	 try {
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 con = DriverManager.getConnection("jdbc:mySQL://localhost:3306/web_gia_su", "root", "");
		 System.out.print("Ket noi thanh cong voi csdl");
	 }catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("Ket noi that bai voi csdl");
			System.err.print(e.getMessage() + "\n" + e.getClass() + "\n" + e.getCause());
			e.printStackTrace();
		}
 }
}
