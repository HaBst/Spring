package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.kh.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Override
	public Member selectOneMember(SqlSessionTemplate sqlSession, Member vo) {
		
		return sqlSession.selectOne("member.selectOneMember",vo);
		
	}

	public int updateMember(SqlSessionTemplate sqlSession, Member vo) {
		
		int result = sqlSession.update("member.updateMember",vo);
		
		
		return result;
	}

	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		
		int result = sqlSession.update("member.insertMember",m);
		
//		int result = jdbcTemplate.update(query,m.getUserId(),m.getUserPw(),m.getUserName(),m.getUserPhone());
		return result;
	}

	public int deleteMember(SqlSessionTemplate sqlSession, String userId) {
		
		int result = sqlSession.update("member.deleteMember",userId);
		
		return result;
	}

	public ArrayList<Member> memberList(SqlSessionTemplate sqlSession) {
		
		List list = sqlSession.selectList("member.selectAllMember");
		return (ArrayList<Member>)list;
		
		
	}

}
