package baemin.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import baemin.member.domain.DetailModifyDTO;
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
	public String postSignup(@ModelAttribute MemberDTO dto,@RequestParam("username") String name
			) throws Exception { // default는 @ModelAttribute	
		//모델은 객체의 매핑
		//리퀘스트파람은 변수의 매핑
		

		System.out.println("파람으로 가져온 name값은? " + name);
		System.out.println("DTO를 통해서 가져온 name값은 ? " + dto.getUsername());
		//System.out.println("dto"+dto.get);
		//비밀번호 암호화
		String userpassword = dto.getUserpassword();
		String encdpassword = pwdEncoder.encode(userpassword);
		dto.setUserpassword(encdpassword);
		
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
			boolean pwdMatch = pwdEncoder.matches(dto.getUserpassword(), memberservice.postLoginpwd(dto).getUserpassword());
			logger.info("pwdMatch : {}",pwdMatch);
				if (pwdMatch == true) {
					session.setAttribute("userid", dto.getUserid());
				}
			}
		
		String member_id = (String)session.getAttribute("userid");
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
	public String detailPage(@RequestParam("userid")String userid,Model model) throws Exception {
		System.out.println("userid는?" + userid);
		model.addAttribute("userid",userid);
		return "/member/detailPage";
	}
	
	//-------멤버 디테일 수정 행위
	@RequestMapping(value="/detailModify",method=RequestMethod.POST)
	public String detailPage(DetailModifyDTO dto,Model model) throws Exception {
		memberservice.postDetailModify(dto);
		model.addAttribute("useird"+dto.getUserid());
		
		
		return "/member/detailPage";
	}
	
	
	

}
