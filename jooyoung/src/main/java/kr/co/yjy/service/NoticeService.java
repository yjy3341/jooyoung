package kr.co.yjy.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.Notice;
import kr.co.yjy.domain.SearchCriteria;

public interface NoticeService {

	//�Խñ� �ۼ�
	public void register(HttpServletRequest request);
	
	//�Խñ� ��� ��������
	public Map<String, Object> notice(Criteria criteria);
	
	//�Խñ� �󼼺��� 
	public Notice detail(HttpServletRequest request);
	
	//�Խñ� ���� ȭ��
	public Notice updateView(HttpServletRequest request);
	
	//�Խñ� ����
	public void update(HttpServletRequest request);
	
	//�Խñ� ����
	public void delete(HttpServletRequest request);
}
