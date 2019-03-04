package kr.co.yjy.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.User;

public interface UserService {
	
	//로그인
	public User login(HttpServletRequest request);
	//아이디 중복 체크
	public String idCheck(HttpServletRequest request);
	//아이디 중복 체크
	public String nicknameCheck(HttpServletRequest request);
	//회원가입
	public void register(HttpServletRequest request);
	//회원 탈퇴
	public boolean delete(String id);

	//비밀번호 변경
	public void update(String id, HttpServletRequest request);
	
	//아이디 찾기
	public User idfind(HttpServletRequest request);
}
