package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThemThongTinHSDAO extends DBconnect {
	public void ThemThongTinHS(String tenhocsinh, String namsinh, String sodienthoai,String email, String gioitinh, String diachi, String sotaikhoan) throws ParseException {
		String query = "insert into HocSinh(ten_hoc_sinh,nam_sinh, sdt, email,username, gioi_tinh,dia_chi,so_tai_khoan) values (?,?,?,?,?,?,?,?);";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedDate = dateFormat.parse(namsinh);
			Date nam_sinh = new Date(parsedDate.getTime());
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, tenhocsinh);
			ps.setDate(2, nam_sinh);
			ps.setString(3, sodienthoai);
			ps.setString(4, email);
			ps.setString(5,"vietanh1" );
			ps.setString(6, gioitinh);
			ps.setString(7, diachi);
			ps.setString(8, sotaikhoan);
			
			ps.executeUpdate();
			// k can dung result vi khi usertao tai khoan se k co du lieu tra ve
			// can dung [executeUpdate()] de update lai du lieu
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
