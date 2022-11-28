package baemin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import baemin.member.domain.AdMethodDTO;
import baemin.member.domain.DetailInsertDTO;
import baemin.member.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sql;
	
	private static final String NAMESPACE="baemin.member.mapper.memberMapper";
	
	//---------------Signup page POST---------------
	@Override
	public void postSignup(MemberDTO dto) throws Exception{
		sql.insert(NAMESPACE+".signup", dto);
	}
	
	//---------------LOGIN CHECK POST---------------
	@Override
	public int postLogin(MemberDTO dto) throws Exception{
		return sql.selectOne(NAMESPACE+".logincheck",dto);
	}
	
	//---------------LOGIN HISTORY---------------
	@Override
	public void postLoginHistory(MemberDTO dto) throws Exception{
		sql.insert(NAMESPACE+".loginHistory",dto);
	}
	
	//---------------ID SAME CHECK POST---------------
	@Override
	public int postIdsame(MemberDTO dto) throws Exception{
		return sql.selectOne(NAMESPACE+".idsame", dto);
	}
	
	//---------------LOGIN MEMBER INFORMATION /PASSWORD ENCODING DECODING---------------
	@Override
	public MemberDTO postLoginpwd (MemberDTO dto) throws Exception{
		return sql.selectOne(NAMESPACE+".memberInfo", dto);
	}

	@Override
	public void postDetailInsert(DetailInsertDTO dto) throws Exception {
		sql.insert(NAMESPACE+".postDetailInsert",dto);		
	}
	
	//---------- 광고 수신 동의 ------------	//HashMap으로 바꾸고싶은데 못하겠어... 다음에 할게
	@Override
	public void adMethodInsertion(AdMethodDTO dto) throws Exception{
		sql.insert(NAMESPACE+".adMethodInsertion", dto);
	}
}
