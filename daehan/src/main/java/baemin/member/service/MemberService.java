package baemin.member.service;

import java.util.Map;

import baemin.member.domain.DetailInsertDTO;
import baemin.member.domain.MemberDTO;
import baemin.member.domain.TestDTO;
import jdk.jshell.spi.ExecutionControl.ExecutionControlException;

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
	public void postDetailInsert (DetailInsertDTO dto) throws Exception;
	
	public void postTest(Map<String, Object> map) throws Exception;

	// 회원 상세 디테일 페이지 이동
	public DetailInsertDTO postDetailPage(String user_id) throws Exception;

}
