package Model;

public class TaiKhoan {
	private String username, password, position;
	public TaiKhoan(String username, String password, String position) {
		super();
		this.username = username;
		this.password = password;
		this.position = position;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
}
