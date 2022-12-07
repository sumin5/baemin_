package baemin.market.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;
import baemin.market.domain.testDTO;

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
	public List<MenuDTO> getMenuList(String marketId) {
		List<MenuDTO> list = sql.selectList(NAMESPACE+".getMenuList", marketId);
		return list;
	}		
	
	
	@Override
	public void menuInsertion(MenuDTO dto) {
		sql.insert(NAMESPACE+".menuInsertion", dto);	
		sql.insert(NAMESPACE+".menuHistoryInsertion", dto);
	}
	
	
	@Override
	public MenuDTO getMenuDetail(String marketId, int menuId) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("marketId", marketId);
		map.put("menuId", menuId);
	
		MenuDTO menuDto = sql.selectOne(NAMESPACE+".getMenuDetail", map);
		
		return menuDto;
	}

	
	@Override
	public void menuUpdate(MenuDTO dto) {		
		sql.update(NAMESPACE+".menuUpdate", dto); //메뉴테이블 업데이트
		sql.update(NAMESPACE+".menuHistoryUpdate");	//메뉴이력테이블 업데이트
	}
	
	
	@Override
	public void menuDelete(int menuId, String marketId, String sysRegDate) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("menuId", menuId);
		map.put("marketId", marketId);
		map.put("sysRegDate", sysRegDate);
		
		System.out.println("menuDelete map: " + map.toString());
		
		sql.delete(NAMESPACE+".menuDelete", map);
//		sql.delete(NAMESPACE+".menuHistoryDelete", map); 업데이트 먼저
	}
	
	
	
	
	
	//test용, 끝나면 삭제하기
	@Override
	public List<Map<String, Object>> test() {
		List<Map<String, Object>> list = sql.selectList(NAMESPACE+".test");		
		
//		Map<String,Object> map = sql.selectOne(NAMESPACE+".test");
//		System.out.println("test map: " + map.toString());
//		
//		String marketId = (String)map.get("market_Id");
//		System.out.println("test market_Id: " + marketId);
//		
//		testDTO dto = new testDTO((String)map.get("market_Id"), (String)map.get("market_Name"), (String)map.get("market_Rode"));
//		System.out.println("test dto : " + dto.toString());
//		
//		System.out.println("test dto1: " + dto.getTest1());
//		System.out.println("test dto2: " + dto.getTest2());
//		System.out.println("test dto3: " + dto.getTest3());		
		
		return list;
	}



	



	


}
