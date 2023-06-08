package Model;

public class LopHoc {
	private int id;
	private String tenLopHoc;
	private int khoi;
	private String tenGiaSu;
	private int hocPhi;
	
	public LopHoc(int id, String tenLopHoc, int khoi, String tenGiaSu, int hocPhi) {
		this.id = id;
		this.tenLopHoc = tenLopHoc;
		this.khoi = khoi;
		this.tenGiaSu = tenGiaSu;
		this.hocPhi = hocPhi;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLopHoc() {
		return tenLopHoc;
	}
	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}
	public String getTenGiaSu() {
		return tenGiaSu;
	}
	public void setTenGiaSu(String tenGiaSu) {
		this.tenGiaSu = tenGiaSu;
	}
	
	public int getKhoi() {
		return khoi;
	}
	public void setKhoi(int khoi) {
		this.khoi = khoi;
	}
	public int getHocPhi() {
		return hocPhi;
	}
	public void setHocPhi(int hocPhi) {
		this.hocPhi = hocPhi;
	}
	
}
