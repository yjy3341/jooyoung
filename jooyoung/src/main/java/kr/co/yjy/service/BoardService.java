package kr.co.yjy.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.yjy.domain.Board;
import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.SearchCriteria;

public interface BoardService {

	//글 쓰기
	//파일이 있을 때는 HttpServletRequest 대신에 MultipartHttpServletRequest를 사용
	public void register(MultipartHttpServletRequest request);
	
	//게시물 목록 가져오기
/*	public List<Board> board();*/
	
	//게시물 목록 가져오기
	public Map<String, Object> board(SearchCriteria criteria);
	
	//게시글 상세보기
	public Board detail(HttpServletRequest request);
	
	//게시글 수정화면 
	public Board updateView(HttpServletRequest request);
	
	//게시글 수정처리
	public void update(HttpServletRequest request);
	
	//게시글 삭제
	public void delete(HttpServletRequest request);
	
	//id에 해당하는 게시글 가져오기
	public Map<String, Object> mypage(Criteria criteria, String id);


	

}
