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
	}

	@Override
	public void marketHistoryInsert(MarketDTO dto) {
		sql.insert(NAMESPACE+".marketHistoryInsert", dto);		
	}

	@Override
	public void menuInsertion(MenuDTO dto) {
		sql.insert(NAMESPACE+".menuInsertion", dto);
		
	}

}
