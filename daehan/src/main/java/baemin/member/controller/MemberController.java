package baemin.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import baemin.member.dao.MemberDAO;
import baemin.member.dao.MemberDAOImpl;
import baemin.member.domain.AdMethodDTO;
import baemin.member.domain.DetailInsertDTO;
import baemin.member.domain.MemberDTO;
import baemin.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	
	//Service 자리
	@Autowired
	private MemberService memberservice;
	
	//비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	//logger
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	//---------------Signup page GET---------------
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public void getSignup() throws Exception{
		System.out.println("getsign");
		// void 일때는 매핑한 value값으로 논리뷰를 리턴한다 

	}
	
	
	
	//---------------Signup page POST---------------
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String postSignup(@ModelAttribute MemberDTO dto,@RequestParam("user_name") String name
			) throws Exception { // default는 @ModelAttribute	
		//모델은 객체의 매핑
		//리퀘스트파람은 변수의 매핑
		
//		String user_id = request.getParameter("user_Id");
//		
//		MemberDTO dto1 = new MemberDTO(user_id, null, null, null, null, null, null);
//		memberservice.postSignup(dto1);
		
		System.out.println("파람으로 가져온 name값은? " + name);
		System.out.println("DTO를 통해서 가져온 name값은 ? " + dto.getUser_name());
		System.out.println("DTO를 통해서 가져온 getUser_id값은 ? " + dto.getUser_id());
		System.out.println("DTO를 통해서 가져온 getUser_password값은 ? " + dto.getUser_password());
		System.out.println("DTO를 통해서 가져온 getEmail값은 ? " + dto.getEmail());
		System.out.println("DTO를 통해서 가져온 getTelno값은 ? " + dto.getTelno());
		System.out.println("DTO를 통해서 가져온 getAddress값은 ? " + dto.getAddress());
		System.out.println("DTO를 통해서 가져온 getAuthority_code값은 ? " + dto.getAuthority_code());
		
		//System.out.println("dto"+dto.get);
		//비밀번호 암호화
		String userpassword = dto.getUser_password();
		String encdpassword = pwdEncoder.encode(userpassword);
		dto.setUser_password(encdpassword);
		
		
		memberservice.postSignup(dto);
		
		return "redirect:/member/login";
		
		// redirect 새로고침 느낌 파라메터 전달이 안됨 전달하고싶으면  RedirectAttributes
		// forward 바로바로 이동되는거 파라메터 자유롭게 전달
		
		// String 은 리턴에 명시된 값으로 논리뷰를 리턴 
		// void 일때는 매핑한 value값으로 논리뷰를 리턴한다 
	}
	
	//---------------Login page 이동 GET---------------
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void getLogin() throws Exception{
		
	}
	
	//---------------Login Check POST---------------
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String postLogin(MemberDTO dto, HttpSession session, Model model, RedirectAttributes rttr) throws Exception{
		System.out.println("===========LOGIN CHECK POST RESULT start===========");
	
		//아이디 일치 체크
		int result = memberservice.postLogin(dto);
		logger.info("result:{}",result);
		
		
		
		/*if(result == 0) { //존재하지 않는 아이디가 입력될때 
		logger.info("아이디체크 if 진입");
			//model.addAttribute("IDcheck_message","ID_NOT_FOUND");
			//rttr.addFlashAttribute("IDcheckmessage", "ID_NOT_FOUND");
			//return "redirect:/";		
			//return "ID_NOT_FOUND";
		}else if(result == 1){		
		logger.info("아이디체크 else if 진입");
		
		//비밀번호 일치 체크
		boolean pwdMatch = pwdEncoder.matches(dto.getUserpassword(), memberservice.postLoginpwd(dto).getUserpassword());
		logger.info("pwdMatch : {}",pwdMatch);
//		if (result == 1 && pwdMatch) {
//			session.setAttribute("userid", dto.getUserid());
//		}
			if (pwdMatch == true) {
				session.setAttribute("userid", dto.getUserid());
			}
		}*/
		
		if(result == 1){		
			logger.info("아이디체크 else if 진입");
			
			//비밀번호 일치 체크
			boolean pwdMatch = pwdEncoder.matches(dto.getUser_password(), memberservice.postLoginpwd(dto).getUser_password());
			logger.info("pwdMatch : {}",pwdMatch);
				if (pwdMatch == true) {
					session.setAttribute("user_id", dto.getUser_id());
					memberservice.postLoginHistory(dto);
				}
			}
		
		String member_id = (String)session.getAttribute("user_id");
		System.out.println(" / member_id = " + member_id);
		System.out.println("===========LOGIN CHECK POST RESULT finish===========");
		//return result;
		return member_id;
		
	}
	
	//---------------Logout Get---------------
	@ResponseBody
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void getLogout(HttpSession session) throws Exception{
		session.removeAttribute("userid");
		
	}
	
	
	//---------------ID SAME CHACK POST---------------
	@ResponseBody
	@RequestMapping(value="/idsame", method=RequestMethod.POST)
	public String postIdsame(MemberDTO dto) throws Exception{
		String result = Integer.toString(memberservice.postIdsame(dto));
		
		logger.info("logger. result : {}", result);
		
		return result;
	}
	
	//--------멤버 계정 디테일 페이지 ------
	@RequestMapping(value="/detailPage",method=RequestMethod.POST)
	public String detailPage(AdMethodDTO dto, @RequestParam("user_id")String user_id,Model model) throws Exception {
		System.out.println("user_id는?" + user_id);
		model.addAttribute("user_id",user_id);		
		
		return "/member/detailPage";
	}
	
	//-------멤버 디테일 수정 행위 + 광고 수신 동의
	@RequestMapping(value="/detailInsert",method=RequestMethod.POST)
	public String detailPage(DetailInsertDTO dto1,AdMethodDTO dto2,Model model) throws Exception {
		memberservice.postDetailInsert(dto1);
		
//		Map<String, Object> map1 = new HashMap<String, Object>();
//		map1.put("adMethod", "1");
//		map1.put("adAgreeYN", dto2.getEmail());
//		
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("adMethod", "2");
//		map2.put("adAgreeYN", dto2.getSms());
//		
//		Map<String, Object> map3 = new HashMap<String, Object>();
//		map3.put("adMethod", "3");
//		map3.put("adAgreeYN", dto2.getKakaotalk());
//		
//		Map<String, Object> map4 = new HashMap<String, Object>();
//		map4.put("adMethod", "4");
//		map4.put("adAgreeYN", dto2.getPhonecall());
//		
//
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		list.add(map1);
//		list.add(map2);
//		list.add(map3);
//		list.add(map4);
		
		
		
		List<String> yNList = new ArrayList<>();
//		if(dto2.getEmail() == null) {
//			dto2.setEmail("N");
//		}
//		if(dto2.getSms() == null) {
//			dto2.setSms("N");
//		}
//		if(dto2.getKakaotalk() == null) {
//			dto2.setKakaotalk("N");
//		}
//		if(dto2.getPhonecall() == null) {
//			dto2.setPhonecall("N");
//		}
	
		
		yNList.add(dto2.getEmail());
		yNList.add(dto2.getSms());
		yNList.add(dto2.getKakaotalk());
		yNList.add(dto2.getPhonecall());
		
// 		null -> N 처리 (mapper에서 COALESCE로함)
//		for (int i = 0 ; i<yNList.size(); i++) {
//			if(yNList.get(i)==null) {
//				yNList.set(i, "N");
//			}
//		}	
		
		List<Map<String, Object>> adList = new ArrayList<Map<String, Object>>();
		for (int i = 0 ; i<yNList.size(); i++) {
			Map<String, Object> adMap = new HashMap<String, Object>();
			adMap.put("adMethod", (i+1));
			adMap.put("adAgreeYN",yNList.get(i));
			adList.add(adMap);
			System.out.println(yNList.get(i));
		}	
		
		memberservice.adMethodInsertion(adList);		
		
		model.addAttribute("user_id"+dto1.getUser_id());		
		
		
		
		/*************************/
		
//		List<String> yNList2 = new ArrayList<>();
//		yNList2.add(dto2.getEmail());
//		yNList2.add(dto2.getSms());
//		yNList2.add(dto2.getKakaotalk());
//		yNList2.add(dto2.getPhonecall());		
//		
//		List<Map<String, Object>> yNList3 = new ArrayList<Map<String, Object>>();
//		for (int i = 0 ; i<yNList2.size(); i++) {
//			Map<String, Object> adMap = new HashMap<String, Object>();
//			adMap.put("adAgreeYN"+(String.valueOf((char)(65+i))), yNList2.get(i));
//			adMap.put("adMethod"+(String.valueOf((char)(65+i))), (i+1));
//			yNList3.add(adMap);
//			System.out.println("::::::::"+yNList3.get(i));
//			System.out.println("::::::::"+(String.valueOf((char)(65+i))));
//		}	
//		
//		List<Map<String, Object>> adList2 = new ArrayList<Map<String, Object>>();
//		for (int i = 0 ; i<yNList2.size(); i++) {
//			Map<String, Object> adMap = new HashMap<String, Object>();
//			adMap.put("adMethod", (i+1));
//			adMap.put("adAgreeYN",yNList2.get(i));
//			adList.add(adMap);
//			System.out.println(yNList2.get(i));
//		}	
//		
//		memberservice.adMethodInsertion(adList2);		
//		
//		model.addAttribute("user_id"+dto1.getUser_id());				
		
		/*************************/	
		
		
		return "/member/detailPage";
	}
	
	
	

}
