package org.kh.member.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.kh.member.dao.MemberDAO;
import org.kh.member.vo.Member;

public class MemberService {

	public Member seleceOneMember(Member vo) {
		Connection conn = getConnection();
		System.out.println(conn);
		
		Member m = new MemberDAO().selectOneMember(conn,vo);
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	
	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:this:@localhost:1521:xe","spring","spring");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
