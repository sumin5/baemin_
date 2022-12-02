package baemin.market.domain;

public class MarketDTO {
	private String marketId;
	private String marketName;
	private String categoryCodeId;
	private String marketZipcode;
	private String marketRoad;
	private String addressDetail;
	private String phone;
	private String openingTime;
	private String closingTime;
	private int minPrice;
	
	
	public MarketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarketDTO(String marketId, String marketName, String categoryCodeId, String marketZipcode, String marketRoad,
			String addressDetail, String phone, String openingTime, String closingTime, int minPrice) {
		super();
		this.marketId = marketId;
		this.marketName = marketName;
		this.categoryCodeId = categoryCodeId;
		this.marketZipcode = marketZipcode;
		this.marketRoad = marketRoad;
		this.addressDetail = addressDetail;
		this.phone = phone;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.minPrice = minPrice;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getCategoryCodeId() {
		return categoryCodeId;
	}

	public void setCategoryCodeId(String categoryCodeId) {
		this.categoryCodeId = categoryCodeId;
	}

	public String getMarketZipcode() {
		return marketZipcode;
	}

	public void setMarketZipcode(String marketZipcode) {
		this.marketZipcode = marketZipcode;
	}

	public String getMarketRoad() {
		return marketRoad;
	}

	public void setMarketRoad(String marketRoad) {
		this.marketRoad = marketRoad;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	
	
	
}
