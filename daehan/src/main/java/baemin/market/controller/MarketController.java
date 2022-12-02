package baemin.market.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import baemin.market.domain.MarketDTO;
import baemin.market.domain.MenuDTO;
import baemin.market.service.MarketService;
import baemin.member.controller.MemberController;


@Controller
@RequestMapping("/market/*")
public class MarketController {

	@Autowired
	private MarketService marketservice;
	
	//logger
	public static final Logger logger = LoggerFactory.getLogger(MarketController.class);	
	
	//--------------(GET)음식점 사장님 페이지 이동-----------------
	@RequestMapping(value="/marketOwnerPage", method=RequestMethod.GET)
	public void marketOwnerPage(HttpSession session) {
		System.out.println("============== marketOwnerPage GET 진입 ==============");
	}
	
	//---------------(GET)음식점 상세정보 페이지 이동---------------
	@RequestMapping(value="/marketDetailPage", method=RequestMethod.GET)
	public void marketDetailPage(HttpSession session) {
		System.out.println("============== marketDetailPage GET 진입 =============");
	}	
	
	//-------------------음식점 상세정보 및 이력 입력--------------------
	@RequestMapping(value="/marketDetailInsert", method=RequestMethod.POST)
	public String marketDetailInsert(MarketDTO dto, HttpSession session) {
		System.out.println("============ marketDetailInsert POST 진입 ============");
		
		marketservice.marketDetailInsert(dto);		
		
		return "main";
	}	
	
	//-------------(GET)메뉴 페이지 이동----------------
	@RequestMapping(value="/menuPage", method=RequestMethod.GET)
	public void menuPage(HttpSession session) {		
		System.out.println("================= menuPage GET 진입 =================");
		
		String marketId = (String) session.getAttribute("userId");
		
		int menuId = marketservice.getMenuId(marketId);
		session.setAttribute("menuId", menuId);
	}
	
	//-------------메뉴 정보 및 이력 입력----------------
	@RequestMapping(value="/menuInsertion", method=RequestMethod.POST)
	public String menuInsertion(MenuDTO dto, HttpSession session) {
		System.out.println("============== menuInsertion POST 진입 ==============");	
		
		marketservice.menuInsertion(dto);
		
		return "main";
	}
	
}
