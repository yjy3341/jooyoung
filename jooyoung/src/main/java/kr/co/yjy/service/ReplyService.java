package kr.co.yjy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.Reply;

public interface ReplyService {

	//��� ����
	public boolean register(HttpServletRequest request);
	
	//��۸�� ��������
	public List<Reply> reply(HttpServletRequest request);
	
	//��� ����
	public boolean delete(HttpServletRequest request);
	
	//��� ����
	public boolean update(HttpServletRequest request);
}
