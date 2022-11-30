package baemin.member.dao;

import java.util.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import baemin.member.domain.AdMethodDTO;

import baemin.member.domain.DetailInsertDTO;
import baemin.member.domain.MemberDTO;
import baemin.member.domain.TestDTO;

public interface MemberDAO {

	//---------------Signup page POST---------------
	public void postSignup(MemberDTO dto) throws Exception;
	
	//---------------LOGIN CHECK POST---------------
	public int postLogin(MemberDTO dto) throws Exception;
	
	//---------------LOGIN HISTORY---------------
	public void postLoginHistory(MemberDTO dto) throws Exception;

	//---------------ID SAME CHECK POST---------------
	public int postIdsame(MemberDTO dto) throws Exception;
	
	//---------------LOGIN MEMBER INFORMATION /PASSWORD ENCODING DECODING---------------
	public MemberDTO postLoginpwd (MemberDTO dto) throws Exception;

	//------------------------------회원 상세 디테일 수정 및 입력-------------------	
	public void postDetailInsert(DetailInsertDTO dto)  throws Exception;


	public void postTest(Map<String, Object> map);

	public DetailInsertDTO postDetailPage(String userId);



	//---------- 광고 수신 동의 ------------
	public void adMethodInsertion(List<Map<String, Object>> list) throws Exception;

}
