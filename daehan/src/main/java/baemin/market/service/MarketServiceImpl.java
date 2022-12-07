package baemin.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baemin.market.dao.MarketDAO;
import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;
import baemin.market.domain.testDTO;

@Service
public class MarketServiceImpl implements MarketService {
	
	@Autowired
	private MarketDAO dao;

	@Override
	public void marketDetailInsert(MarketDTO dto) {
		dao.marketDetailInsert(dto);
	}
	
	@Override
	public int getMenuId(String marketId) {
		int menuId = dao.getMenuId(marketId);
		return menuId;
	}
	
	@Override
	public List<MenuDTO> getMenuList(String marketId) {
		List<MenuDTO> list = dao.getMenuList(marketId);
		return list;
	}

	@Override
	public void menuInsertion(MenuDTO dto) {
		dao.menuInsertion(dto);		
	}

	@Override
	public MenuDTO getMenuDetail(String marketId, int menuId) {
		MenuDTO menuDto = dao.getMenuDetail(marketId, menuId);
		return menuDto;
	}
	
	@Override
	public void menuUpdate(MenuDTO dto) {
		dao.menuUpdate(dto);		
	}

	
	@Override
	public void menuDelete(int menuId, String marketId, String sysRegDate) {
		dao.menuDelete(menuId, marketId, sysRegDate);		
	}
	
	
	
	
	//test용, 끝나면 삭제하기
	@Override
	public List<Map<String, Object>> test() {
		List<Map<String, Object>> list = dao.test();
		return list;
	}


	

}
