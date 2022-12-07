package baemin.market.service;

import java.util.List;
import java.util.Map;

import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;
import baemin.market.domain.testDTO;

public interface MarketService {

	//---------------음식점 상세정보 및 이력 입력---------------
	public void marketDetailInsert(MarketDTO dto);
	
	//-----------------메뉴 menuId max값-----------------
	public int getMenuId(String marketId);
		
	//------------------메뉴 리스트 가져오기-----------------
	public List<MenuDTO> getMenuList(String marketId);
			
	//----------------메뉴 정보 및 이력 insert---------------
	public void menuInsertion(MenuDTO dto);
	
	//------------------메뉴 정보 가져오기------------------
	public MenuDTO getMenuDetail(String marketId, int menuId);
		
	//----------------메뉴 정보 및 이력 Update---------------
	public void menuUpdate(MenuDTO dto);
	
	//----------------메뉴 정보 및 이력 delete---------------
	public void menuDelete(int menuId, String marketId, String sysRegDate);
	
	
	//test용, 끝나면 삭제하기
	public List<Map<String, Object>> test();
}
