package com.spring.trantestanno.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// #14. DAO ����
@Repository
public class NoticeDAO implements InterNoticeDAO {

	@Autowired // ������ü����(DI : Dependency Injection)
	private SqlSessionTemplate sqlsession;

	
	// ��������Ʈ ��û 
	@Override
	public int getLoginUserPoint(String loginid) {
		int point = sqlsession.selectOne("trantestanno.getLoginUserPoint", loginid); 
		return point;
	}


	// �۾���(tx_notices ���̺�  insert) 
	@Override
	public int insert_tx_notices(NoticeVO ntvo) {
		int n = sqlsession.insert("trantestanno.insert_tx_notices", ntvo);
		return n;
		
	}


	// ����Ʈ���� ����(tx_member ���̺��� point �÷��� 1���� ������Ʈ) 
	@Override
	public int update_tx_member(String writerid) {
		int n = sqlsession.update("trantestanno.update_tx_member", writerid);
		return n;
	}


	// �۸�Ϻ���
	@Override
	public List<HashMap<String, String>> list() {
		List<HashMap<String, String>> list = sqlsession.selectList("trantestanno.list");
		return list;
	}
	
	
}
