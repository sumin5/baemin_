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
	private String userid;
	private String userpassword;
	private String username;
	private String telno;
	private String email;
	private String address;
	private String authority_code;
	//------------------Getter/Setter------------------
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public MemberDTO(String userid, String userpassword, String username, String telno, String email, String address,
			String authority_code) {
		super();
		this.userid = userid;
		this.userpassword = userpassword;
		this.username = username;
		this.telno = telno;
		this.email = email;
		this.address = address;
		this.authority_code = authority_code;
	}

	
}
