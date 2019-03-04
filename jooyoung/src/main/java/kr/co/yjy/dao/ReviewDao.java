package kr.co.yjy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yjy.domain.Reply;
import kr.co.yjy.domain.Review;

@Repository
public class ReviewDao {

	@Autowired
	private SqlSession sqlSession;
	
	//리뷰 저장
	public int register(Review review) {
		return sqlSession.insert("review.register", review);
	}
	
	//게시글에 해당하는 리뷰 목록
	public List<Review> review(int bno){
		return sqlSession.selectList("review.review", bno);
	}
	
	//리뷰 삭제
	public int delete(int rno) {
		return sqlSession.delete("review.delete", rno);
	}
	
	//리뷰수정
	public int update(Review review) {
		return sqlSession.update("review.update", review);
	}

}
