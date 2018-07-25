package com.spring.trantestanno.service;

import java.util.HashMap;
import java.util.List;

import com.spring.trantestanno.model.NoticeVO;

public interface InterNoticeService {

	int getLoginUserPoint(String loginid);  // 나의포인트 요청 

	int addEnd_notransaction(NoticeVO ntvo); // 글쓰기(트랜잭션처리안함) 

	List<HashMap<String, String>> list(); // 글목록보기 

	int addEnd_transaction(NoticeVO ntvo) throws Throwable; // 글쓰기(트랜잭션처리함) 
	
}
