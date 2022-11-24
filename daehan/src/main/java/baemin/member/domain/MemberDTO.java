package baemin.member.domain;

public class MemberDTO {

	/* CREATE TABLE `tbl_member` (
			`userid` VARCHAR(20) NOT NULL COLLATE 'utf8mb3_general_ci',
			`userpassword` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
			`username` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
			`telno` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
			`email` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
			`regdate` TIMESTAMP NULL DEFAULT current_timestamp(),
			`authority_code` CHAR(1) NULL DEFAULT '0' COLLATE 'utf8mb3_general_ci',
			PRIMARY KEY (`userid`) USING BTREE
		)*/
	private String user_id;
	private String user_password;
	private String user_name;
	private String telno;
	private String email;
	private String address;
	private String authority_code;
	//------------------Getter/Setter------------------
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAuthority_code() {
		return authority_code;
	}
	public void setAuthority_code(String authority_code) {
		this.authority_code = authority_code;
	}
	
	
	//------------------Constructor------------------
	public MemberDTO() {
		super();
	} // 기본생성자
	
	public MemberDTO(String user_id, String user_password, String user_name, String telno, String email, String address,
			String authority_code) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.telno = telno;
		this.email = email;
		this.address = address;
		this.authority_code = authority_code;
	}

	
}
