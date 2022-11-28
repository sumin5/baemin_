package baemin.member.domain;

public class AdMethodDTO {
	private String user_id;
	private String email;
	private String sms;
	private String kakaotalk;
	private String phonecall;
	private String agree;
	public AdMethodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdMethodDTO(String user_id, String email, String sms, String kakaotalk, String phonecall, String agree) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.sms = sms;
		this.kakaotalk = kakaotalk;
		this.phonecall = phonecall;
		this.agree = agree;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getKakaotalk() {
		return kakaotalk;
	}
	public void setKakaotalk(String kakaotalk) {
		this.kakaotalk = kakaotalk;
	}
	public String getPhonecall() {
		return phonecall;
	}
	public void setPhonecall(String phonecall) {
		this.phonecall = phonecall;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}

	

	
	
}
