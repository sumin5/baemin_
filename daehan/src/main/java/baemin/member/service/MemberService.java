package baemin.member.service;

import baemin.member.domain.DetailModifyDTO;
import baemin.member.domain.MemberDTO;

public interface MemberService {
	
	//---------------Signup page POST---------------
	public void postSignup(MemberDTO dto) throws Exception;
	
	//---------------LOGIN CHECK POST---------------
	public int postLogin(MemberDTO dto) throws Exception;
	
	//---------------ID SAME CHECK POST---------------
	public int postIdsame(MemberDTO dto) throws Exception;
	
	//---------------LOGIN MEMBER INFORMATION /PASSWORD ENCODING DECODING---------------
	public MemberDTO postLoginpwd (MemberDTO dto) throws Exception;
	
	//---------- 회원 상세 디테일 수정 및 입력 -----------
	public void postDetailModify (DetailModifyDTO dto) throws Exception;

}
