package baemin.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baemin.member.dao.MemberDAO;
import baemin.member.domain.DetailModifyDTO;
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
	public void postDetailModify(DetailModifyDTO dto) throws Exception {
		dao.postDetailModify(dto);
		
	}
	
	
}
