package com.spring.trantestanno.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// #14. DAO 선언
@Repository
public class NoticeDAO implements InterNoticeDAO {

	@Autowired // 의존객체주입(DI : Dependency Injection)
	private SqlSessionTemplate sqlsession;

	
	// 나의포인트 요청 
	@Override
	public int getLoginUserPoint(String loginid) {
		int point = sqlsession.selectOne("trantestanno.getLoginUserPoint", loginid); 
		return point;
	}


	// 글쓰기(tx_notices 테이블에  insert) 
	@Override
	public int insert_tx_notices(NoticeVO ntvo) {
		int n = sqlsession.insert("trantestanno.insert_tx_notices", ntvo);
		return n;
		
	}


	// 포인트점수 증가(tx_member 테이블의 point 컬럼값 1증가 업데이트) 
	@Override
	public int update_tx_member(String writerid) {
		int n = sqlsession.update("trantestanno.update_tx_member", writerid);
		return n;
	}


	// 글목록보기
	@Override
	public List<HashMap<String, String>> list() {
		List<HashMap<String, String>> list = sqlsession.selectList("trantestanno.list");
		return list;
	}
	
	
}
