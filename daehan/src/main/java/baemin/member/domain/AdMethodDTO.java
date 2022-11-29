package baemin.member.domain;

public class AdMethodDTO {
	private String user_id;
	private String email;
	private String sms;
	private String kakaotalk;
	private String phonecall;
	private String agree;
	private String ad_method;
	
	public AdMethodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public String getUser_id() {
		return user_id;
	}
	public AdMethodDTO(String user_id, String email, String sms, String kakaotalk, String phonecall, String agree,
			String ad_method) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.sms = sms;
		this.kakaotalk = kakaotalk;
		this.phonecall = phonecall;
		this.agree = agree;
		this.ad_method = ad_method;
	}
	
	
	
	public AdMethodDTO(Object object) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdMethodDTO(String user_id, String email, String sms, String kakaotalk, String phonecall) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.sms = sms;
		this.kakaotalk = kakaotalk;
		this.phonecall = phonecall;
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
	public String getAd_method() {
		return ad_method;
	}
	public void setAd_method(String ad_method) {
		this.ad_method = ad_method;
	}

	

	
	
}
