package baemin.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baemin.market.dao.MarketDAO;
import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;

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
	public void menuInsertion(MenuDTO dto) {
		dao.menuInsertion(dto);		
	}

	

}
