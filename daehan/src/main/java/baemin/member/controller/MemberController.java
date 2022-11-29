package baemin.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.MapKey;
import org.apache.taglibs.standard.lang.jstl.Literal;
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


import baemin.member.domain.DetailInsertDTO;
import baemin.member.domain.MemberDTO;
import baemin.member.domain.TestDTO;
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
				}
				else {
					System.out.println("비번 틀림");
					return "redirect:/";
				}
			}
		else {
			System.out.println("아이디 틀림");
			session.setAttribute("member",null);
			return "redirect:/";
		}
		
		
		
		session.setAttribute("user_name",memberservice.postLoginpwd(dto).getUser_name());
		System.out.println("  user_name = " + session.getAttribute("user_name"));
		System.out.println("===========LOGIN CHECK POST RESULT finish===========");
		//return result;
		return "main";
		
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
	public String detailPage(@RequestParam("user_id")String user_id,Model model) throws Exception {
		System.out.println("user_id는?" + user_id);
	
		
		DetailInsertDTO dto=memberservice.postDetailPage(user_id);
		
		model.addAttribute("user_id",user_id);
		return "/member/detailPage";
	}
	
	//-------멤버 디테일 수정 행위
	@RequestMapping(value="/detailInsert",method=RequestMethod.POST)
	public String detailPage(DetailInsertDTO dto,Model model) throws Exception {
		memberservice.postDetailInsert(dto);
		model.addAttribute("user_id"+dto.getUser_id());
		
		
		return "/member/detailPage";
	}
	
	
	//---------------Signup page GET---------------
		@RequestMapping(value="/test", method = RequestMethod.GET)
		public void getTest() throws Exception{
			
			System.out.println("test.jsp");
			//
	}
		//---------------Signup page GET---------------
		@RequestMapping(value="/test", method = RequestMethod.POST)
		public String postTest(TestDTO dto) throws Exception{
			
//			List<Object> list = new ArrayList<Object>();
//			
//			list.add(dto.getEmail());
//			list.add(dto.getSms());
//			list.add(dto.getKakaotalk());
//			list.add(dto.getPhonecall());
//			
//			List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
//			for(int i=0; i<list.size(); i++) {
//				Map<String, Object> map = new HashMap<String, Object>();
//				map.put("ad_agree_yn",list.get(i));
//				map.put("ad_method_id",i+1);
//				map.put("user_id",dto.getUser_id());
//				list1.add(map);
//			}
//			
				
		List<Object> list = new ArrayList<Object>();	
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> arraymapA = new HashMap<String, Object>();
		Map<String, Object> arraymapB = new HashMap<String, Object>();


		 
		 ArrayList<Map<String,Object>> arrayA = new ArrayList<Map<String,Object>>();
		 ArrayList<Map<String,Object>> arrayB = new ArrayList<Map<String,Object>>();
		  
		 arraymapA.put("e",dto.getEmail());
		 arraymapA.put("s",dto.getSms());
		 arraymapA.put("k",dto.getKakaotalk());
		 arraymapA.put("p",dto.getPhonecall());
	
		 arrayA.add(arraymapA);
	
		 arraymapB.put("e","1");		 
		 arraymapB.put("s","2");		 
		 arraymapB.put("k","3");		 
		 arraymapB.put("p","4");		 
		 
		 arrayB.add(arraymapB);
		 
		 map1.put("e", dto.getEmail());
		 map1.put("s", dto.getSms()); 
		 map1.put("k", dto.getKakaotalk());
		 map1.put("p", dto.getPhonecall());

		 Iterator<String> iter = map1.keySet().iterator();

		 while(iter.hasNext()) {
			
			 System.out.println("회전");
			 String a = iter.next();
			 String strMap = (String) map1.get(a);
			 System.out.println("----------------------------------");
			 System.out.println("a ? " + a);
			 System.out.println("----------------------------------");
		
			 if(strMap==null) {
				 System.out.println("null임 다음");
				 continue;
			 }
	
			
			 if(strMap.equals("Y")&&a.equals("e")) {
				 System.out.println("값이 e면서 Y래요");
				 TestDTO dto1 = new TestDTO();
				 dto1.setAd_agree_yn((String) arrayA.get(0).get("e"));
				 dto1.setAd_method_id((String) arrayB.get(0).get("e"));
				 dto1.setUser_id(dto.getUser_id());
				 list.add(dto1);
				 continue;
			 }
			 if(strMap.equals("Y")&&a.equals("s")) {
				 System.out.println("값이 s면서 Y래요");
				 TestDTO dto1 = new TestDTO();
				 dto1.setAd_agree_yn((String) arrayA.get(0).get("s"));
				 dto1.setAd_method_id((String) arrayB.get(0).get("s"));
				 dto1.setUser_id(dto.getUser_id());
				 list.add(dto1);
				 continue;
			 }if(strMap.equals("Y")&&a.equals("k")){
				 System.out.println("값이 k면서 Y래요");
				 TestDTO dto1 = new TestDTO();
				 dto1.setAd_agree_yn((String) arrayA.get(0).get("k"));
				 dto1.setAd_method_id((String) arrayB.get(0).get("k"));
				 dto1.setUser_id(dto.getUser_id());
				 list.add(dto1);
				 continue;
			 }if(strMap.equals("Y")&&a.equals("p")) {
				 System.out.println("값이 p면서 Y래요");
				 TestDTO dto1 = new TestDTO();
				 dto1.setAd_agree_yn((String) arrayA.get(0).get("p"));
				 dto1.setAd_method_id((String) arrayB.get(0).get("p"));
				 dto1.setUser_id(dto.getUser_id());
				 
				 System.out.println("어레이b의 p값 ? " + arrayB.get(0).get("p"));
				 list.add(dto1);
				 continue;
			 }

			 
		 }
	 
			map.put("list1", list);
			System.out.println("map 사이즈 ? "  + map.get("list1"));
	
			 System.out.println("map list 값은 ? " + map);
			memberservice.postTest(map);
			System.out.println("test.jsp");
			//
			return "main";
		}
		

}
