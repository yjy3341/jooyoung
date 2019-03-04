package kr.co.yjy.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yjy.dao.ReviewDao;
import kr.co.yjy.domain.Reply;
import kr.co.yjy.domain.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	//���� ����
	@Override
	public boolean register(HttpServletRequest request) {
		boolean result = false;
		
		//�Ķ���� �б�
		String bno = request.getParameter("bno");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String reviewtext = request.getParameter("reviewtext");
		String rating = request.getParameter("rating");
		
		//Dao�� �Ķ���� �����
		Review review = new Review();
		review.setBno(Integer.parseInt(bno));
		review.setId(id);
		review.setNickname(nickname);
		review.setReviewtext(reviewtext);
		review.setRating(Integer.parseInt(rating));
		
		//Dao�޼ҵ� ȣ��
		int r = reviewDao.register(review);
		
		//Dao�� ȣ���� ������ ������ ��� �����
		if(r > 0)
			result = true;
		return result;
	}

	//�Խñۿ� �ش��ϴ� ���� ��� ��������
	@Override
	public List<Review> review(HttpServletRequest request) {
		List<Review> review = new ArrayList<Review>();
		
		//�Ķ���� �б�
		String bno = request.getParameter("bno");
		
		//Dao�޼ҵ� ȣ��
		review = reviewDao.review(Integer.parseInt(bno));
		
		return review;
	}
	
	@Override
	public boolean delete(HttpServletRequest request) {
		boolean result = false;
		
		//�Ķ���� �б�
		String rvno = request.getParameter("rvno");
		
		//Dao�޼ҵ� ȣ��
		int r = reviewDao.delete(Integer.parseInt(rvno));
		
		//Dao�� ȣ���� ������ ������ ��� �����
		if(r > 0)
			result = true;
		return result;
	}

	@Override
	public boolean update(HttpServletRequest request) {
		boolean result = false;
		
		//�Ķ���� �б�
		String rvno = request.getParameter("rvno");
		String reviewtext = request.getParameter("reviewtext");
		
		//Dao �Ķ���� �����
		Review review = new Review();
		review.setRvno(Integer.parseInt(rvno));
		review.setReviewtext(reviewtext);
		
		//Dao �޼ҵ� ȣ��
		int r = reviewDao.update(review);
		
		if(r > 0)
			result = true;
		return result;
	}

}
