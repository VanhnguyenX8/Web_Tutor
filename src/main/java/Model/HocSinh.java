package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HocSinh {
	private String ten_hoc_sinh;
	private String nam_sinh;
	private String sdt;
	private String email;
	private int so_du_tai_khoan;
	private String username;
	private String gioi_tinh;
	private String dia_chi;
	private String so_tai_khoan;
	
	public HocSinh() {
		
	}


	public String getTen_hoc_sinh() {
		return ten_hoc_sinh;
	}

	public void setTen_hoc_sinh(String ten_hoc_sinh) {
		this.ten_hoc_sinh = ten_hoc_sinh;
	}

	public String getNam_sinh() {
		return nam_sinh;
	}

	public void setNam_sinh(Date nam_sinh) {
		this.nam_sinh = new SimpleDateFormat("dd-MM-yyyy").format(nam_sinh);
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSo_du_tai_khoan() {
		return so_du_tai_khoan;
	}

	public void setSo_du_tai_khoan(int so_du_tai_khoan) {
		this.so_du_tai_khoan = so_du_tai_khoan;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getSo_tai_khoan() {
		return so_tai_khoan;
	}

	public void setSo_tai_khoan(String so_tai_khoan) {
		this.so_tai_khoan = so_tai_khoan;
	}
	
	public String toString() {
		return this.ten_hoc_sinh + "\n" + this.nam_sinh + "\n" + this.sdt + "\n" + this.email + "\n" + this.so_du_tai_khoan + "\n" + this.username + "\n" + this.gioi_tinh + "\n" + this.dia_chi + "\n" + this.getSo_tai_khoan();
	}
}
