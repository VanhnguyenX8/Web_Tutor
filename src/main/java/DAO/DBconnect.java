package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	protected Connection con;

	public Connection DBconnect() {
		try {
			Connection con;
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ep-damp-bush-071348.ap-southeast-1.aws.neon.tech/giasuweb?useUnicode=true&characterEncoding=UTF-8";
			con = DriverManager.getConnection(url, "chimtrung2911", "KzC8yt4pYcSW");
			return con;
//			con = (Connection) DriverManager.getConnection(
//					"jdbc:postgresql://ep-damp-bush-071348.ap-southeast-1.aws.neon.tech/giasuweb?user=chimtrung2911&password=KzC8yt4pYcSW");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("Ket noi that bai voi csdl");
			System.err.print(e.getMessage() + "\n" + e.getClass() + "\n" + e.getCause());
			e.printStackTrace();
		}
		return null;
	}
}
