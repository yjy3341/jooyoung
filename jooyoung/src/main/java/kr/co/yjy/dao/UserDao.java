package kr.co.yjy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yjy.domain.User;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//로그인
	public User login(String id) {
		return sqlSession.selectOne("user.login", id);
	}
	
	//아이디 중복체크
	public String idCheck(String id) {
		return sqlSession.selectOne("user.idcheck",id);
	}
	
	//닉네임 중복체크
	public String nicknameCheck(String nickname) {
		return sqlSession.selectOne("user.nicknamecheck",nickname);
	}
	
	//회원가입
	public int register(User user) {
		return sqlSession.insert("user.register", user);
	}
	
	//회원 탈퇴
	public int delete(String id) {
		return sqlSession.delete("user.delete", id);
	}
	
	//비밀번호 변경
	public void update(User user) {
		sqlSession.update("user.update", user);
	}
	
	//아이디 찾기
	/*public User find(String name) {
		return sqlSession.selectOne("user.find", name);
	}*/
	public User idfind(String name) {
		return sqlSession.selectOne("user.idfind", name);
	}
}
