package com.spring.trantestanno.service;

import java.util.HashMap;
import java.util.List;

import com.spring.trantestanno.model.NoticeVO;

public interface InterNoticeService {

	int getLoginUserPoint(String loginid);  // ��������Ʈ ��û 

	int addEnd_notransaction(NoticeVO ntvo); // �۾���(Ʈ�����ó������) 

	List<HashMap<String, String>> list(); // �۸�Ϻ��� 

	int addEnd_transaction(NoticeVO ntvo) throws Throwable; // �۾���(Ʈ�����ó����) 
	
}
