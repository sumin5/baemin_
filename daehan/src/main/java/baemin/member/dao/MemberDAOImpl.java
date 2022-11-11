package baemin.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import baemin.member.domain.DetailModifyDTO;
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
	public void postDetailModify(DetailModifyDTO dto) throws Exception {
		sql.insert(NAMESPACE+".postDetailModify",dto);
		
	}
}
