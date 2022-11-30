package baemin.member.domain;

public class DetailInsertDTO {
	private String userId;
	private String bankName;
	private String bankNumber;
	private String deliveryZipcode;
	private String deliveryRoad;
	private String deliveryDetail;
	private String addressCodeGroupId;
	private String addressCodeId;
	private String memberStateId;
	

	public DetailInsertDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getBankNumber() {
		return bankNumber;
	}


	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}


	public String getDeliveryZipcode() {
		return deliveryZipcode;
	}


	public void setDeliveryZipcode(String deliveryZipcode) {
		this.deliveryZipcode = deliveryZipcode;
	}


	public String getDeliveryRoad() {
		return deliveryRoad;
	}


	public void setDeliveryRoad(String deliveryRoad) {
		this.deliveryRoad = deliveryRoad;
	}


	public String getDeliveryDetail() {
		return deliveryDetail;
	}


	public void setDeliveryDetail(String deliveryDetail) {
		this.deliveryDetail = deliveryDetail;
	}


	public String getAddressCodeGroupId() {
		return addressCodeGroupId;
	}


	public void setAddressCodeGroupId(String addressCodeGroupId) {
		this.addressCodeGroupId = addressCodeGroupId;
	}


	public String getAddressCodeId() {
		return addressCodeId;
	}


	public void setAddressCodeId(String addressCodeId) {
		this.addressCodeId = addressCodeId;
	}


	public String getMemberStateId() {
		return memberStateId;
	}


	public void setMemberStateId(String memberStateId) {
		this.memberStateId = memberStateId;
	}


	public DetailInsertDTO(String userId, String bankName, String bankNumber, String deliveryZipcode,
			String deliveryRoad, String deliveryDetail, String addressCodeGroupId, String addressCodeId,
			String memberStateId) {
		super();
		this.userId = userId;
		this.bankName = bankName;
		this.bankNumber = bankNumber;
		this.deliveryZipcode = deliveryZipcode;
		this.deliveryRoad = deliveryRoad;
		this.deliveryDetail = deliveryDetail;
		this.addressCodeGroupId = addressCodeGroupId;
		this.addressCodeId = addressCodeId;
		this.memberStateId = memberStateId;
	}
	
	

}
