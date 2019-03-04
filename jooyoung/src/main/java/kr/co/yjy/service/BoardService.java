package kr.co.yjy.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.yjy.domain.Board;
import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.SearchCriteria;

public interface BoardService {

	//�� ����
	//������ ���� ���� HttpServletRequest ��ſ� MultipartHttpServletRequest�� ���
	public void register(MultipartHttpServletRequest request);
	
	//�Խù� ��� ��������
/*	public List<Board> board();*/
	
	//�Խù� ��� ��������
	public Map<String, Object> board(SearchCriteria criteria);
	
	//�Խñ� �󼼺���
	public Board detail(HttpServletRequest request);
	
	//�Խñ� ����ȭ�� 
	public Board updateView(HttpServletRequest request);
	
	//�Խñ� ����ó��
	public void update(HttpServletRequest request);
	
	//�Խñ� ����
	public void delete(HttpServletRequest request);
	
	//id�� �ش��ϴ� �Խñ� ��������
	public Map<String, Object> mypage(Criteria criteria, String id);


	

}
