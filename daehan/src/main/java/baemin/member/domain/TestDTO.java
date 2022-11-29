package baemin.member.domain;

import java.util.List;

public class TestDTO {
	private String user_id;
	private String email;  // Y
	private String sms;    // Y
	private String kakaotalk;  // N
	private String phonecall;  // N 
	private String ad_method_id;  // 1
	private String ad_agree_yn;  // Y,N
	

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
	
	public TestDTO(String user_id, String email, String sms, String kakaotalk, String phonecall, String ad_method_id,
			String ad_agree_yn) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.sms = sms;
		this.kakaotalk = kakaotalk;
		this.phonecall = phonecall;
		this.ad_method_id = ad_method_id;
		this.ad_agree_yn = ad_agree_yn;
	}
	public String getAd_agree_yn() {
		return ad_agree_yn;
	}
	public void setAd_agree_yn(String ad_agree_yn) {
		this.ad_agree_yn = ad_agree_yn;
	}
	public String getAd_method_id() {
		return ad_method_id;
	}
	public void setAd_method_id(String ad_method_id) {
		this.ad_method_id = ad_method_id;
	}
	
	
	public TestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
