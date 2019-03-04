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
	
	//���� ����
	public int register(Review review) {
		return sqlSession.insert("review.register", review);
	}
	
	//�Խñۿ� �ش��ϴ� ���� ���
	public List<Review> review(int bno){
		return sqlSession.selectList("review.review", bno);
	}
	
	//���� ����
	public int delete(int rno) {
		return sqlSession.delete("review.delete", rno);
	}
	
	//�������
	public int update(Review review) {
		return sqlSession.update("review.update", review);
	}

}
