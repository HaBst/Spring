package org.kh.member.model.dao;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;

public interface MemberDAO {
	public Member selectOneMember(JdbcTemplate jdbc, Member vo);

}
