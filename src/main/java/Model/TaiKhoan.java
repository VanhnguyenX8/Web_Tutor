package Model;

import java.util.UUID;

public class TaiKhoan {
	private UUID id;
	private String username, password, role;
	private byte[] encode;
	public TaiKhoan(String username, String password, String position, byte[] encode) {
        this.username = username;
        this.password = password;
        this.role = position;
        this.encode = encode;
    }
	
	public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String position) {
		this.role = position;
	}
	
	public byte[] getEncode() {
		return encode;
	}
	
	public void setEncode(byte[] encode) {
		this.encode = encode;
	}
}