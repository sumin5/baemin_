package baemin.market.domain;

import java.sql.Timestamp;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MenuDTO {
	private String marketId;
	private int menuId;
	private String menuName;
	private int menuPrice;
	private String introduce;
	private String sysRegDate;
	private int sm;
		
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	//menuInsertion 생성자
	public MenuDTO(String marketId, int menuId, String menuName, int menuPrice, String introduce) {
		super();
		this.marketId = marketId;
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.introduce = introduce;
	}	

	
	//getMenuList생성자
	public MenuDTO(String marketId, int menuId, String menuName, int menuPrice, String introduce, String sysRegDate,
			int sm) {
		super();
		this.marketId = marketId;
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.introduce = introduce;
		this.sysRegDate = sysRegDate;
		this.sm = sm;
	}	
	

	//getter & setter
	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getSysRegDate() {
		return sysRegDate;
	}

	public void setSysRegDate(String sysRegDate) {
		this.sysRegDate = sysRegDate;
	}

	public int getSm() {
		return sm;
	}

	public void setSm(int sm) {
		this.sm = sm;
	}


	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	
	
}
