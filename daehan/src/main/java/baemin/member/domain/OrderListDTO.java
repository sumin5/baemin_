package baemin.member.domain;

public class OrderListDTO {
	private String codeId;
	private String mName;
	private String mPhoto;
	
	public OrderListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderListDTO(String codeId, String mName, String mPhoto) {
		super();
		this.codeId = codeId;
		this.mName = mName;
		this.mPhoto = mPhoto;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPhoto() {
		return mPhoto;
	}

	public void setmPhoto(String mPhoto) {
		this.mPhoto = mPhoto;
	}
	
	
}
