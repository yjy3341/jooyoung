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
	
	//리뷰 저장
	@Override
	public boolean register(HttpServletRequest request) {
		boolean result = false;
		
		//파라미터 읽기
		String bno = request.getParameter("bno");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String reviewtext = request.getParameter("reviewtext");
		String rating = request.getParameter("rating");
		
		//Dao의 파라미터 만들기
		Review review = new Review();
		review.setBno(Integer.parseInt(bno));
		review.setId(id);
		review.setNickname(nickname);
		review.setReviewtext(reviewtext);
		review.setRating(Integer.parseInt(rating));
		
		//Dao메소드 호출
		int r = reviewDao.register(review);
		
		//Dao의 호출결과 가지고 리턴할 결과 만들기
		if(r > 0)
			result = true;
		return result;
	}

	//게시글에 해당하는 리뷰 목록 가져오기
	@Override
	public List<Review> review(HttpServletRequest request) {
		List<Review> review = new ArrayList<Review>();
		
		//파라미터 읽기
		String bno = request.getParameter("bno");
		
		//Dao메소드 호출
		review = reviewDao.review(Integer.parseInt(bno));
		
		return review;
	}
	
	@Override
	public boolean delete(HttpServletRequest request) {
		boolean result = false;
		
		//파라미터 읽기
		String rvno = request.getParameter("rvno");
		
		//Dao메소드 호출
		int r = reviewDao.delete(Integer.parseInt(rvno));
		
		//Dao의 호출결과 가지고 리턴할 결과 만들기
		if(r > 0)
			result = true;
		return result;
	}

	@Override
	public boolean update(HttpServletRequest request) {
		boolean result = false;
		
		//파라미터 읽기
		String rvno = request.getParameter("rvno");
		String reviewtext = request.getParameter("reviewtext");
		
		//Dao 파라미터 만들기
		Review review = new Review();
		review.setRvno(Integer.parseInt(rvno));
		review.setReviewtext(reviewtext);
		
		//Dao 메소드 호출
		int r = reviewDao.update(review);
		
		if(r > 0)
			result = true;
		return result;
	}

}
