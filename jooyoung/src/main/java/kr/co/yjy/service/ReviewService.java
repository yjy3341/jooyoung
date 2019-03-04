package kr.co.yjy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.Review;

public interface ReviewService {

	//리뷰 저장
	public boolean register(HttpServletRequest request);
	
	//게시글에 해당하는 리뷰목록 가져오기
	public List<Review> review(HttpServletRequest request);
	
	//리뷰 삭제
	public boolean delete(HttpServletRequest request);
		
	//리뷰 수정
	public boolean update(HttpServletRequest request);
}
