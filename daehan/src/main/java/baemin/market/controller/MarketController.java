package baemin.market.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.ToStringStyler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;
import baemin.market.domain.testDTO;
import baemin.market.service.MarketService;
import baemin.member.controller.MemberController;


@Controller
@RequestMapping("/market/*")
public class MarketController {

	@Autowired
	private MarketService marketservice;
	
	//logger
	public static final Logger logger = LoggerFactory.getLogger(MarketController.class);	
	
	
	//---------------(GET)음식점 상세정보 페이지 이동---------------
	@RequestMapping(value="/marketDetailPage", method=RequestMethod.GET)
	public void marketDetailPage(HttpSession session) {
		logger.info("============== marketDetailPage GET 진입 =============");
		logger.debug("debug_session_userId: {}",session.getAttribute("userId"));
		logger.info("============== marketDetailPage GET 종료 =============");
	}	
	
	//-------------------음식점 상세정보 및 이력 입력--------------------
	@RequestMapping(value="/marketDetailInsert", method=RequestMethod.POST)
	public String marketDetailInsert(MarketDTO dto, HttpSession session) {
		logger.info("============ marketDetailInsert POST 진입 ============");
		
		marketservice.marketDetailInsert(dto);		
		
		return "main";
	}		

	//-------------(GET)메뉴 리스트 페이지 이동-------------
	@RequestMapping(value="/menuListPage", method=RequestMethod.GET)
	public void menuListPage(HttpSession session) {
		logger.info("=============== menuListPage GET 진입 ================");
		
		String marketId = (String) session.getAttribute("userId");
		
		List<MenuDTO> list = marketservice.getMenuList(marketId);
		
		for(int i=0 ; i<list.size() ; i++) {
			logger.debug("debug_list: {}", list.get(i).toString());  //toString()은 DTO정보를 출력할 수 있도록 MenuDTO클래스에 Override함
		}		
		
		session.setAttribute("list", list);		
	}	
	
	//------------(GET)메뉴 입력 페이지 이동---------------
	@RequestMapping(value="/menuInsertPage", method=RequestMethod.GET)
	public void menuInsertPage(HttpSession session) {		
		logger.info("================== menuPage GET 진입 =================");
		
		String marketId = (String) session.getAttribute("userId");
		logger.debug("debug_session_marketId: {}", marketId);
		
		int menuId = marketservice.getMenuId(marketId);
		logger.debug("debug_session_menuId: {}", menuId);
		
		session.setAttribute("menuId", menuId);		
	}
	
	//--------------메뉴 정보 및 이력 insert--------------
	@RequestMapping(value="/menuInsertion", method=RequestMethod.POST)
	public String menuInsertion(MenuDTO dto, HttpSession session) {
		logger.info("=============== menuInsertion POST 진입 ==============");
		
		marketservice.menuInsertion(dto);
		
		return "main";
	}
	
	//-----------(GET)메뉴 정보 수정 페이지 이동------------
	@RequestMapping(value="/menuUpdatePage", method=RequestMethod.GET)
	public void menuUpadatePage(@RequestParam("marketId") String marketId, @RequestParam("menuId") int menuId, 
			HttpSession session) {
		logger.info("=============== menuUpdatePage GET 진입 ==============");
		logger.debug("debug_request_marketId: {}", marketId);
		logger.debug("debug_request_menuId: {}", menuId);
		
		MenuDTO menuDto = marketservice.getMenuDetail(marketId, menuId);
		logger.debug("debug_menuDto: {}", menuDto.toString());
		
		session.setAttribute("menuDto", menuDto);
	}	
	
	//-------------메뉴 정보 및 이력 update----------------
	@RequestMapping(value="/menuUpdate", method=RequestMethod.POST)
	public String menuUpdate(MenuDTO dto) {
		logger.info("================ menuUpdate POST 진입 ================");
		logger.debug("debug_request_MenuDTO: {}", dto.toString());
		
		marketservice.menuUpdate(dto);
			
		return "redirect:/market/menuListPage";
	}
	
	
	
	//-------------메뉴 정보 및 이력 delete----------------
	@RequestMapping(value="/menuDelete", method=RequestMethod.GET)
	public String menuDelete(@RequestParam("menuId") int menuId, 
			@RequestParam("marketId") String marketId, @RequestParam("sysRegDate") String sysRegDate) {
		logger.info("================ menuDelete POST 진입 ================");
		logger.debug("debug_request_menuId: {}", menuId);
		logger.debug("debug_request_marketId: {}", marketId);
		logger.debug("debug_request_sysRegDate: {}", sysRegDate);
		
		marketservice.menuDelete(menuId, marketId, sysRegDate);
		
		return "redirect:/market/menuListPage";
	}
	
	
	
	
	//------------(GET)주문 접수 페이지 이동-------------
	@RequestMapping(value="/orderDetailPage", method=RequestMethod.GET)
	public void orderDetailPage(HttpSession session) {
		logger.info("============= orderDetailPage GET 진입 =============");
		String marketId = (String) session.getAttribute("userId");
		System.out.println("marketId: " + marketId);		
		
		
		
		//test용, 끝나면 삭제하기
							List<Map<String, Object>> list = marketservice.test();
							System.out.println("test list: " + list.toString());
							System.out.println("test list0 : " + list.get(0));
							System.out.println("test list0 의 키값이 market_Id : " + list.get(0).get("market_Id"));
							
							
							List<testDTO> arrdto = new ArrayList<testDTO>();
							
							
							for(int i=0 ; i<list.size() ; i++) {
								testDTO dto = new testDTO();
								Map<String, Object> map = list.get(i);
								dto.setTest1((String)map.get("market_Id"));
								dto.setTest2((String)map.get("market_Name"));
								dto.setTest3((String)map.get("market_Rode"));
								arrdto.add(dto);
							}
							
							logger.info("info_test_arrdto:{}", arrdto);
							session.setAttribute("arrdto", arrdto);
		///////////////////
		
	}
	
}
