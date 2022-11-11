package baemin.member.domain;

public class DetailModifyDTO {
	private String userid;
	private String bank_name;
	private String bank_number;
	private String delivery_zipcode;
	private String delivery_road;
	private String delivery_detail;
	private String address_code_group_id;
	private String address_code_id;
	private String member_state_id;
	private String agree;
	
	
	
	
	public DetailModifyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public DetailModifyDTO(String userid, String bank_name, String bank_number, String delivery_zipcode,
			String delivery_road, String delivery_detail, String address_code_group_id, String address_code_id,
			String member_state_id, String agree) {
		super();
		this.userid = userid;
		this.bank_name = bank_name;
		this.bank_number = bank_number;
		this.delivery_zipcode = delivery_zipcode;
		this.delivery_road = delivery_road;
		this.delivery_detail = delivery_detail;
		this.address_code_group_id = address_code_group_id;
		this.address_code_id = address_code_id;
		this.member_state_id = member_state_id;
		this.agree = agree;
	}


	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_number() {
		return bank_number;
	}
	public void setBank_number(String bank_number) {
		this.bank_number = bank_number;
	}
	public String getDelivery_zipcode() {
		return delivery_zipcode;
	}
	public void setDelivery_zipcode(String delivery_zipcode) {
		this.delivery_zipcode = delivery_zipcode;
	}
	public String getDelivery_road() {
		return delivery_road;
	}
	public void setDelivery_road(String delivery_road) {
		this.delivery_road = delivery_road;
	}
	public String getDelivery_detail() {
		return delivery_detail;
	}
	public void setDelivery_detail(String delivery_detail) {
		this.delivery_detail = delivery_detail;
	}
	public String getAddress_code_group_id() {
		return address_code_group_id;
	}
	public void setAddress_code_group_id(String address_code_group_id) {
		this.address_code_group_id = address_code_group_id;
	}
	public String getAddress_code_id() {
		return address_code_id;
	}
	public void setAddress_code_id(String address_code_id) {
		this.address_code_id = address_code_id;
	}
	public String getMember_state_id() {
		return member_state_id;
	}
	public void setMember_state_id(String member_state_id) {
		this.member_state_id = member_state_id;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}

	
}
