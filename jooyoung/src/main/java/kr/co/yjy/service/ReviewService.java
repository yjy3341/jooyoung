package kr.co.yjy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.Review;

public interface ReviewService {

	//���� ����
	public boolean register(HttpServletRequest request);
	
	//�Խñۿ� �ش��ϴ� ������ ��������
	public List<Review> review(HttpServletRequest request);
	
	//���� ����
	public boolean delete(HttpServletRequest request);
		
	//���� ����
	public boolean update(HttpServletRequest request);
}
