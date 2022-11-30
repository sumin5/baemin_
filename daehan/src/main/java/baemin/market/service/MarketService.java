package baemin.market.service;

import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;

public interface MarketService {

	//---------------음식점 Detail 저장---------------
	public void marketDetailInsert(MarketDTO dto);
	
	//---------------음식점 History 테이블 저장----------------
	public void marketHistoryInsert(MarketDTO dto);
	
	//---------------메뉴 Page 저장-------------------
	public void menuInsertion(MenuDTO dto);
}
