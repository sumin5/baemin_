package baemin.member.domain;

import java.util.List;

public class TestDTO {
	private String userId;
	private String email;  // Y
	private String sms;    // Y
	private String kakaotalk;  // N
	private String phonecall;  // N 
	private String adMethodId;  // 1
	private String adAgreeYn;  // Y,N
	public TestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestDTO(String userId, String email, String sms, String kakaotalk, String phonecall, String adMethodId,
			String adAgreeYn) {
		super();
		this.userId = userId;
		this.email = email;
		this.sms = sms;
		this.kakaotalk = kakaotalk;
		this.phonecall = phonecall;
		this.adMethodId = adMethodId;
		this.adAgreeYn = adAgreeYn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getAdMethodId() {
		return adMethodId;
	}
	public void setAdMethodId(String adMethodId) {
		this.adMethodId = adMethodId;
	}
	public String getAdAgreeYn() {
		return adAgreeYn;
	}
	public void setAdAgreeYn(String adAgreeYn) {
		this.adAgreeYn = adAgreeYn;
	}
	

	
	
	
}
