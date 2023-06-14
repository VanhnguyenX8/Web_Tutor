package Model;

public class CamXuc {
	private String id,idlophoc;
	private String usernamebl;
	private boolean camxuc;
	public CamXuc(String id, String idlophoc, String usernamebl, boolean camxuc) {
		super();
		this.id = id;
		this.idlophoc = idlophoc;
		this.usernamebl = usernamebl;
		this.camxuc = camxuc;
	}
	
	public CamXuc() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdlophoc() {
		return idlophoc;
	}
	public void setIdlophoc(String idsanpham) {
		this.idlophoc = idsanpham;
	}
	public String getUsernamebl() {
		return usernamebl;
	}
	public void setUsernamebl(String usernamebl) {
		this.usernamebl = usernamebl;
	}
	public boolean isCamxuc() {
		return camxuc;
	}
	public void setCamxuc(boolean camxuc) {
		this.camxuc = camxuc;
	}
	
	
}
