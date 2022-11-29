package baemin.member.service;


import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baemin.member.dao.MemberDAO;
import baemin.member.domain.AdMethodDTO;
import baemin.member.domain.DetailInsertDTO;
import baemin.member.domain.MemberDTO;
import baemin.member.domain.TestDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	
	//---------------Signup page POST---------------
	@Override
	public void postSignup(MemberDTO dto) throws Exception{
		dao.postSignup(dto);
	}
	
	//---------------LOGIN CHECK POST---------------
	@Override
	public int postLogin(MemberDTO dto) throws Exception{
		return dao.postLogin(dto);
	}
	
	//---------------LOGIN HISTORY---------------
	@Override
	public void postLoginHistory(MemberDTO dto) throws Exception{
		dao.postLoginHistory(dto);
	}

	//---------------ID SAME CHECK POST---------------
	@Override
	public int postIdsame(MemberDTO dto) throws Exception{
		return dao.postIdsame(dto);
	}
	
	//---------------LOGIN MEMBER INFORMATION /PASSWORD ENCODING DECODING---------------
	@Override
	public MemberDTO postLoginpwd (MemberDTO dto) throws Exception{
		return dao.postLoginpwd(dto);
	}
	//------------------------회원 상세 디테일 수정 및 입력---------------
	@Override
	public void postDetailInsert(DetailInsertDTO dto) throws Exception{
		dao.postDetailInsert(dto);
		
	}

	//----------------회원 상세 페이지 보기-----------
	@Override
	public DetailInsertDTO postDetailPage(String user_id) throws Exception {
		return dao.postDetailPage(user_id);
	}

	

	@Override
	public void postTest(Map<String, Object> map) throws Exception {
		dao.postTest(map);
		
	}

	
	
	


	//---------- 광고 수신 동의 ------------
	@Override
	public void adMethodInsertion (List<Map<String, Object>> list) throws Exception{
		dao.adMethodInsertion(list);		
	}	

	
}
