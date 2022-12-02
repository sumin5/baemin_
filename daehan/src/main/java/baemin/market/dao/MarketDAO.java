package baemin.market.dao;

import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;

public interface MarketDAO {

	//---------------음식점 상세정보 및 이력 입력---------------
	public void marketDetailInsert(MarketDTO dto);
	
	//---------------메뉴 menuId max값--------------
	public int getMenuId(String marketId);
	
	//------------------메뉴 정보 및 이력 입력-----------------
	public void menuInsertion(MenuDTO dto);
}
