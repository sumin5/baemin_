package baemin.member.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import baemin.member.domain.AdMethodDTO;
import baemin.member.domain.DetailInsertDTO;
import baemin.member.domain.MemberDTO;
import baemin.member.domain.TestDTO;

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

	@Override

	public void postTest(Map<String, Object> map) {
		sql.insert(NAMESPACE+".postTest",map);
		
	}

	// --  디테일 페이지 상세 보기 ---------------------
	@Override
	public DetailInsertDTO postDetailPage(String userId) {
		return sql.selectOne(NAMESPACE+".postDetailPage",userId);
		
	}
	public void adMethodInsertion(List<Map<String, Object>> list) throws Exception {
		sql.insert(NAMESPACE+".adMethodInsertion", list);
	}

}
