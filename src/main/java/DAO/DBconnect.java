package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import Model.LopHoc;

public class DBconnect {
	protected Connection con;
	
	public Connection DBconnect() {
		try {
			Connection con;
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ep-damp-bush-071348.ap-southeast-1.aws.neon.tech/giasuweb?useUnicode=true&characterEncoding=UTF-8";
			con = DriverManager.getConnection(url, "chimtrung2911", "KzC8yt4pYcSW");
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("Ket noi that bai voi csdl");
			System.err.print(e.getMessage() + "\n" + e.getClass() + "\n" + e.getCause());
			e.printStackTrace();
		}
		return null;
	}
	
//	public DBconnect() {
//	
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giasuweb", "root", "2410");
////			System.out.println("Ket noi thanh cong voi csdl");
//		}
//		catch (Exception e) {
//			System.out.println("Ket noi that bai voi csdl");
//			e.printStackTrace();
//		}
//	}
//	public static void main(String[] args) {
//		ArrayList<LopHoc> lh = new LopHocDKDAO().getLopHoc(0);
//		for(LopHoc tmp: lh) {
//			System.out.println(tmp.getId());
//		}
//	}
}
