package baemin.market.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;

@Repository
public class MarketDAOImpl implements MarketDAO {

	@Autowired
	private SqlSession sql;
	
	private static final String NAMESPACE="baemin.member.mapper.marketMapper";
	
	@Override
	public void marketDetailInsert(MarketDTO dto) {
		sql.insert(NAMESPACE+".marketDetailInsert", dto);	
		sql.insert(NAMESPACE+".marketHistoryInsert", dto);		
	}
	
	@Override
	public int getMenuId(String marketId) {
		int menuId = sql.selectOne(NAMESPACE+".getMenuId", marketId);
		return menuId;
	}

	@Override
	public void menuInsertion(MenuDTO dto) {
		sql.insert(NAMESPACE+".menuInsertion", dto);	
		sql.insert(NAMESPACE+".menuHistoryInsertion", dto);
	}

	

}
