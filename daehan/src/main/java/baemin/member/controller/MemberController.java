package baemin.member.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import baemin.market.controller.MarketController;
import baemin.member.dao.MemberDAO;
import baemin.member.dao.MemberDAOImpl;
import baemin.member.domain.AdMethodDTO;
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
	public String postSignup(@ModelAttribute MemberDTO dto,@RequestParam("userName") String name
			) throws Exception { // default는 @ModelAttribute	
		//모델은 객체의 매핑
		//리퀘스트파람은 변수의 매핑
		

		System.out.println("파람으로 가져온 name값은? " + name);
		System.out.println("DTO를 통해서 가져온 name값은 ? " + dto.getUserName());
		System.out.println("DTO를 통해서 가져온 getUserId값은 ? " + dto.getUserId());
		System.out.println("DTO를 통해서 가져온 getUser_password값은 ? " + dto.getUserPassword());
		System.out.println("DTO를 통해서 가져온 getEmail값은 ? " + dto.getEmail());
		System.out.println("DTO를 통해서 가져온 getTelno값은 ? " + dto.getTelno());
		System.out.println("DTO를 통해서 가져온 getAddress값은 ? " + dto.getAddress());
		System.out.println("DTO를 통해서 가져온 getAuthorityCode값은 ? " + dto.getAuthorityCode());
		
		//System.out.println("dto"+dto.get);
		//비밀번호 암호화
		String userpassword = dto.getUserPassword();
		String encdpassword = pwdEncoder.encode(userpassword);
		dto.setUserPassword(encdpassword);
		String authorityCode = dto.getAuthorityCode();
				
		memberservice.postSignup(dto);
		
		return "redirect:/";
		
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
		
		MemberDTO memberDTO = memberservice.postLoginpwd(dto);
		
		if(result == 1){		
			logger.info("아이디체크 else if 진입");
			
			//비밀번호 일치 체크
			
			System.out.println("누군데요?  " + memberDTO.getUserPassword());
			boolean pwdMatch = pwdEncoder.matches(dto.getUserPassword(), memberDTO.getUserPassword());
			logger.info("pwdMatch : {}",pwdMatch);
				if (pwdMatch == true) {
					
					session.setAttribute("userId", dto.getUserId());
					
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
		
		session.setAttribute("userName",memberDTO.getUserName());
		session.setAttribute("userId",memberDTO.getUserId());
		session.setAttribute("authorityCode", memberDTO.getAuthorityCode());
		session.setAttribute("telno", memberDTO.getTelno());

		System.out.println("  userName = " + session.getAttribute("userName"));
		System.out.println("  authorityCode = " + session.getAttribute("authorityCode"));
		System.out.println("  telno = " + session.getAttribute("telno"));
		System.out.println("===========LOGIN CHECK POST RESULT finish===========");
	
	
		return "main";
		
	}
	
	//---------------Logout Get---------------
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String getLogout(HttpSession session) throws Exception{
		session.removeAttribute("userId");
		return "redirect:/";
	}
	
	
	//---------------ID SAME CHACK POST---------------
	@ResponseBody
	@RequestMapping(value="/idsame", method=RequestMethod.POST)
	public String postIdsame(MemberDTO dto) throws Exception{
		String result = Integer.toString(memberservice.postIdsame(dto));
		
		logger.info("logger. result : {}", result);
		
		return result;
	}
	
	
	@RequestMapping(value="/detailPage",method=RequestMethod.GET)
	public String detailPage(@RequestParam("userId")String userId,Model model) throws Exception {
		System.out.println("userId는?" + userId);
	
		DetailInsertDTO dto = memberservice.postDetailPage(userId);
		model.addAttribute("dto",dto);	
		model.addAttribute("userId",userId);
				return "/member/detailPage";
	}
	
	//-------멤버 디테일 수정 행위
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
		
		model.addAttribute("userId"+dto1.getUserId());		
		
		
		
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
//		model.addAttribute("UserId"+dto1.getUserId());				
		
		/*************************/	
		
		
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
//				map.put("UserId",dto.getUserId());
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
				 dto1.setAdAgreeYn((String) arrayA.get(0).get("e"));
				 dto1.setAdMethodId((String) arrayB.get(0).get("e"));
				 dto1.setUserId(dto.getUserId());
	
				 list.add(dto1);
				 continue;
			 }
			 if(strMap.equals("Y")&&a.equals("s")) {
				 System.out.println("값이 s면서 Y래요");
				 TestDTO dto1 = new TestDTO();
				 dto1.setAdAgreeYn((String) arrayA.get(0).get("s"));
				 dto1.setAdMethodId((String) arrayB.get(0).get("s"));
				 dto1.setUserId(dto.getUserId());
				 list.add(dto1);
				 continue;
			 }if(strMap.equals("Y")&&a.equals("k")){
				 System.out.println("값이 k면서 Y래요");
				 TestDTO dto1 = new TestDTO();
				 dto1.setAdAgreeYn((String) arrayA.get(0).get("k"));
				 dto1.setAdMethodId((String) arrayB.get(0).get("k"));
				 dto1.setUserId(dto.getUserId());
				 list.add(dto1);
				 continue;
			 }if(strMap.equals("Y")&&a.equals("p")) {
				 System.out.println("값이 p면서 Y래요");
				 TestDTO dto1 = new TestDTO();
				 dto1.setAdAgreeYn((String) arrayA.get(0).get("p"));
				 dto1.setAdMethodId((String) arrayB.get(0).get("p"));
				 dto1.setUserId(dto.getUserId());
				 
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
		
		
		//-------------(GET)주문 페이지 이동----------------
		@RequestMapping(value="/orderPage", method=RequestMethod.GET)
		public void orderPage(HttpSession session) {
			System.out.println("================= orderPage GET 진입 =================");
			
		}
	
		@RequestMapping(value="/jq.cls", method=RequestMethod.GET)
		public ModelAndView main(ModelAndView mv , HttpSession s, RedirectView rv) {
			mv.setViewName("member/test");
			return mv;
		}
		
		@RequestMapping(value="/pay.cls", method=RequestMethod.GET)
		public ModelAndView serve(ModelAndView mv , HttpSession s, RedirectView rv) {
			mv.setViewName("member/serve");
			return mv;
		}
		@ResponseBody
		@RequestMapping(value="/kakaopay.cls", method=RequestMethod.GET)
		public String kakaopay(ModelAndView mv , HttpSession s, RedirectView rv) {
			try {
				URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
				
				// 전깃줄 같은 역할 서버 연결용
				HttpURLConnection serverConn = (HttpURLConnection) address.openConnection();
				
				serverConn.setRequestMethod("POST"); // 카카오에서 post로 요청하기 떄문에 맞춰줘야함
				serverConn.setRequestProperty("Authorization", "KakaoAK 75fd3a09eb96d41e1a5f517fbf0c37ac"); // 카카오 프로퍼티 설정 본인 api키
				serverConn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8"); // 동일
				serverConn.setDoOutput(true); // 커넥션에는 do아웃풋과 do인풋이 있는데	 두개를 통해서 서버에 전해줄것이 있는지 없는지 판단 // 넣어줄것이 있기에 true로 설정
				// input은 안해주는게 디폴트가 true기 때문에 따로 생성안해줌  output은 default가 false여서 위에서 생성해서 true로 설정
				
				String paraMeter = "cid=TC0ONETIME";
						paraMeter+= "&partner_order_id=partner_order_id";
						paraMeter+= "&partner_user_id=partner_user_id";
						paraMeter+= "&item_name=초코파이";
						paraMeter+= "&quantity=1";
						paraMeter+= "&total_amount=2200";
						paraMeter+= "&vat_amount=200";
						paraMeter+= "&tax_free_amount=0";
						paraMeter+= "&approval_url=http://localhost:8181/member/pay.cls"; // 카카오내 플랫폼 url 확인후 작성
						paraMeter+= "&fail_url=https://localhost:8181/member/fail"; // 동일
						paraMeter+= "&cancel_url=https://localhost:8181/member/cancel"; // 동일
						
						// 서버에 파라메터전달해줄 클래스
						OutputStream postC = serverConn.getOutputStream(); // 전깃줄같은 서버연결용에서  아웃스트림을 받아냄 
						DataOutputStream postD = new DataOutputStream(postC); // 데이터를 주는역할
						
						// 아웃풋스트림은 byte 형식으로 전달해야함
						postD.writeBytes(paraMeter); // byte로 형변환 
						
						// flush() 함수는 본인이 가진것을 비운다는데, 자바에서는 전기줄에서 태워보내면서 비운다
						postD.close(); // close는 flush를 호출하면서 닫아버림
						
						int result = serverConn.getResponseCode(); // 연결이 잘되었는지 int형으로 받음
						
						InputStream getD;  // 데이터를 받는역할
						if(result == 200) {// 상식 http코드에서 정상적인 코드는 200을 의미  // 그이외의값은 다 에러  
							getD = serverConn.getInputStream(); // 데이터를 받음
						}
						else {
							getD = serverConn.getErrorStream(); // 데이터를 에러발생시키면 에러 스트림으로 받아야함
						}
						
						InputStreamReader inputReader = new InputStreamReader(getD);// 받은 데이터를 읽는애
						
						// 데이터 송수신이 byte인데 그대로 받으면 안되기에 byte를 형변환해서 받아야함
						BufferedReader changeD = new BufferedReader(inputReader);// 버퍼리더는 데이터를 읽으면서 형변환을 해줌 
						
						return changeD.readLine(); // 문자열로 형변환을 알아서 하고 값을 찍어내고 본인은 비움
						
						
 			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "{\"result\":\"NO\"}";	
		}
		
		
	
		
		

}
