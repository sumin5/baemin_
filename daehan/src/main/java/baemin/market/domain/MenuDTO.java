package baemin.market.domain;

public class MenuDTO {
	private String marketId;
	private String menuId;
	private String menuName;
	private String menuPrice;
	private String introduce;
		
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuDTO(String marketId, String menuId, String menuName, String menuPrice, String introduce) {
		super();
		this.marketId = marketId;
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.introduce = introduce;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}
