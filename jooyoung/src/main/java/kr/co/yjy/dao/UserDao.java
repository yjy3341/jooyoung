package kr.co.yjy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yjy.domain.User;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//�α���
	public User login(String id) {
		return sqlSession.selectOne("user.login", id);
	}
	
	//���̵� �ߺ�üũ
	public String idCheck(String id) {
		return sqlSession.selectOne("user.idcheck",id);
	}
	
	//�г��� �ߺ�üũ
	public String nicknameCheck(String nickname) {
		return sqlSession.selectOne("user.nicknamecheck",nickname);
	}
	
	//ȸ������
	public int register(User user) {
		return sqlSession.insert("user.register", user);
	}
	
	//ȸ�� Ż��
	public int delete(String id) {
		return sqlSession.delete("user.delete", id);
	}
	
	//��й�ȣ ����
	public void update(User user) {
		sqlSession.update("user.update", user);
	}
	
	//���̵� ã��
	/*public User find(String name) {
		return sqlSession.selectOne("user.find", name);
	}*/
	public User idfind(String name) {
		return sqlSession.selectOne("user.idfind", name);
	}
}
