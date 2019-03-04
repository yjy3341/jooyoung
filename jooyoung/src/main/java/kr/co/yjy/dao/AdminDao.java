package kr.co.yjy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.SearchCriteria;
import kr.co.yjy.domain.User;

@Repository
public class AdminDao {

	@Autowired
	private SqlSession sqlSession;
	
	//유저 목록 가져오기
	public List<User> userlist(Criteria criteria) {
		return sqlSession.selectList("admin.userlist", criteria);
	}
	
	//전체유저 개수 가져오기
	public int userCount(Criteria criteria) {
		return sqlSession.selectOne("admin.usercount",criteria);
	}
	
	//댓글 삭제
	public int delete(String id) {
		return sqlSession.delete("admin.delete", id);
	}
		
	//유저 상세보기
	public User userdetail(String id) {
		return sqlSession.selectOne("admin.userdetail", id);
	}
	
	//유저 삭제
	public void userdelete(String id) {
		sqlSession.delete("admin.userdelete", id);
	}
}
