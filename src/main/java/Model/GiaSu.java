package Model;

public class GiaSu {
	private String ten_gia_su;
	private String sdt;
	
	public GiaSu() {
		
	}

	public GiaSu(String ten_gia_su, String sdt) {
		this.ten_gia_su = ten_gia_su;
		this.sdt = sdt;
	}


	public String getTen_gia_su() {
		return ten_gia_su;
	}

	public void setTen_gia_su(String ten_gia_su) {
		this.ten_gia_su = ten_gia_su;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
}
