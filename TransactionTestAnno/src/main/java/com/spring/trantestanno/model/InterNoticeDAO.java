package com.spring.trantestanno.model;

import java.util.HashMap;
import java.util.List;

public interface InterNoticeDAO {

	int getLoginUserPoint(String loginid); // ��������Ʈ ��û 

	int insert_tx_notices(NoticeVO ntvo); // �۾���(tx_notices ���̺�  insert) 

	int update_tx_member(String writerid); // ����Ʈ���� ����(tx_member ���̺��� point �÷��� 1���� ������Ʈ)     

	List<HashMap<String, String>> list(); // �۸�Ϻ���

}
