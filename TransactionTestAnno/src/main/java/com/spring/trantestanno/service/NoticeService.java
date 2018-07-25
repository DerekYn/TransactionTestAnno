package com.spring.trantestanno.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.trantestanno.model.InterNoticeDAO;
import com.spring.trantestanno.model.NoticeVO;

// #15. Service ����
@Service
public class NoticeService implements InterNoticeService {

	@Autowired // ������ü����(DI : Dependency Injection)
	private InterNoticeDAO dao;

	
	// ��������Ʈ ��û 
	@Override
	public int getLoginUserPoint(String loginid) {
		int point = dao.getLoginUserPoint(loginid);
		return point;
	}


	// �۾���(Ʈ�����ó������)
	@Override
	public int addEnd_notransaction(NoticeVO ntvo) {
		int n = dao.insert_tx_notices(ntvo);
		int m = dao.update_tx_member(ntvo.getWriterid());
		
		return (n+m);
	}


	// �۸�Ϻ��� 
	@Override
	public List<HashMap<String, String>> list() {
		List<HashMap<String, String>> list = dao.list();
		return list;
	}


	// �۾���(Ʈ�����ó����)
	/*
	    >>>> Ʈ�����ó���� �ؾ��� �޼ҵ忡 @Transactional ������̼��� �����ϸ� �ȴ�.
	    rollbackFor={Throwable.class} �� �ѹ��� �ؾ��� ������ ���ϴµ�
	    Throwable.class �� error �� exception �� ������ �ֻ��� ��Ʈ�̴�.
	        ��, �ش� �޼ҵ� ����� �߻��ϴ� ��� error �� exception �� ���ؼ� �ѹ��� �ϰڴٴ� ���̴�. 
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor={Throwable.class} )      
	public int addEnd_transaction(NoticeVO ntvo) throws Throwable {
		int n = dao.insert_tx_notices(ntvo);
		int m = dao.update_tx_member(ntvo.getWriterid());
		
		return (n+m);
	}
	
	
	
}
