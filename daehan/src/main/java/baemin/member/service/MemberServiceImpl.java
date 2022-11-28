package baemin.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baemin.member.dao.MemberDAO;
import baemin.member.domain.AdMethodDTO;
import baemin.member.domain.DetailInsertDTO;
import baemin.member.domain.MemberDTO;

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
	
	//---------- 광고 수신 동의 ------------
	@Override
	public void adMethodInsertion (AdMethodDTO dto) throws Exception{
		dao.adMethodInsertion(dto);
	}
	
	
}
