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
	
	//---------------음식점 Detail Page GET---------------
	@RequestMapping(value="/marketDetailPage", method=RequestMethod.GET)
	public void marketDetailPage(HttpSession session) {
		logger.info("-------------페이지 이동 메서드 진입-----------");
		
		System.out.println("marketDetailPage GET 진입");
		System.out.println("session의 user_id: "+ session.getAttribute("user_id"));		

		
		logger.info("-------------페이지 이동 메서드 진입-----------");
	}	
	
	//---------------음식점 Detail Page POST---------------
	@RequestMapping(value="/marketDetailInsert", method=RequestMethod.POST)
	public String marketDetailInsert(MarketDTO dto, HttpSession session) {
		System.out.println("marketDetailInsert 컨트롤러 진입");

		logger.info("dto:{}", dto);
		System.out.println("marketDetailInsert 컨트롤러 진입-----1-----");
		session.setAttribute("marketId", dto.getMarketId());
		
		System.out.println("marketDetailInsert 컨트롤러 진입-----2-----");
		marketservice.marketDetailInsert(dto);		
		marketservice.marketHistoryInsert(dto); //이부분은 나중에  member부분으로 옮겨야할듯
		return "market/marketOwnerPage";
	}
	
	//--------------marketOwnerPage GET-----------------
	@RequestMapping(value="/marketOwnerPage", method=RequestMethod.GET)
	public void marketOwnerPage(MarketDTO dto, HttpSession session) {
		System.out.println("marketOwnerPage GET 진입");
	}
	
	//-------------메뉴 Page GET----------------
	@RequestMapping(value="/menuPage", method=RequestMethod.GET)
	public void menuPage(MarketDTO dto, HttpSession session) {
		session.setAttribute("marketId", dto.getMarketId());
		System.out.println("menuPage GET 진입");
	}
	
	//-------------메뉴 Page POST----------------
	@RequestMapping(value="/menuInsertion", method=RequestMethod.POST)
	public void menuInsertion(MenuDTO dto, HttpSession session) {
		System.out.println("menuInsertion POST 진입");
		
		
		marketservice.menuInsertion(dto);
	}
	
}
