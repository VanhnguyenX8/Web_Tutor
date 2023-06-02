package Model;

public class UserGS {
	private String tenGS, gioitinh, diachi, sdt, email, stk, username;

	public UserGS(String ten, String gioitinh, String diachi, String sdt, String email, String stk, String username) {
		super();
		this.tenGS = ten;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.stk = stk;
		this.username = username;
	}

	public String getTenGS() {
		return tenGS;
	}

	public void setTenGS(String tenGS) {
		this.tenGS = tenGS;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
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

	public String getStk() {
		return stk;
	}

	public void setStk(String stk) {
		this.stk = stk;
	}

	public String getUsername() {
		return username;
	}
}
