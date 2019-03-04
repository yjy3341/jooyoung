package kr.co.yjy.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.User;

public interface AdminService {

	//���� ��� ��������
	public Map<String, Object> userlist(Criteria criteria);
	
	//��� ����
	public boolean delete(HttpServletRequest request);
	
	//���� �󼼺���
	public User userdetail(HttpServletRequest request);
	
	//ȸ�� ����
	public void userdelete(HttpServletRequest request);
}
