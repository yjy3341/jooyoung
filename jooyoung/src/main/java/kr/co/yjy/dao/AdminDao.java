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
	
	//���� ��� ��������
	public List<User> userlist(Criteria criteria) {
		return sqlSession.selectList("admin.userlist", criteria);
	}
	
	//��ü���� ���� ��������
	public int userCount(Criteria criteria) {
		return sqlSession.selectOne("admin.usercount",criteria);
	}
	
	//��� ����
	public int delete(String id) {
		return sqlSession.delete("admin.delete", id);
	}
		
	//���� �󼼺���
	public User userdetail(String id) {
		return sqlSession.selectOne("admin.userdetail", id);
	}
	
	//���� ����
	public void userdelete(String id) {
		sqlSession.delete("admin.userdelete", id);
	}
}
