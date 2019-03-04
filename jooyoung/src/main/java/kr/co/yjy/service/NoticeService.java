package kr.co.yjy.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.Notice;
import kr.co.yjy.domain.SearchCriteria;

public interface NoticeService {

	//게시글 작성
	public void register(HttpServletRequest request);
	
	//게시글 목록 가져오기
	public Map<String, Object> notice(Criteria criteria);
	
	//게시글 상세보기 
	public Notice detail(HttpServletRequest request);
	
	//게시글 수정 화면
	public Notice updateView(HttpServletRequest request);
	
	//게시글 수정
	public void update(HttpServletRequest request);
	
	//게시글 삭제
	public void delete(HttpServletRequest request);
}
