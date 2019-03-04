package kr.co.yjy.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.User;

public interface AdminService {

	//유저 목록 가져오기
	public Map<String, Object> userlist(Criteria criteria);
	
	//댓글 삭제
	public boolean delete(HttpServletRequest request);
	
	//유저 상세보기
	public User userdetail(HttpServletRequest request);
	
	//회원 삭제
	public void userdelete(HttpServletRequest request);
}
