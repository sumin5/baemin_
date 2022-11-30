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
	private String userId;
	private String userPassword;
	private String userName;
	private String telno;
	private String email;
	private String address;
	private String authority_code;
	//------------------Getter/Setter------------------
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public MemberDTO(String userId, String userPassword, String userName, String telno, String email, String address,
			String authority_code) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.telno = telno;
		this.email = email;
		this.address = address;
		this.authority_code = authority_code;
	}
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
