package kr.co.yjy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yjy.domain.Board;
import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.SearchCriteria;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	//글 쓰기
	public void register(Board board) {
		sqlSession.insert("board.register", board);
	}
	
	//글 목록 가져오기
	/*public List<Board> board(){
		return sqlSession.selectList("board.board");
	}*/
	
	//글 목록 가져오기
	public List<Board> board(SearchCriteria criteria){
		return sqlSession.selectList("board.board", criteria);
	}
	
	//글번호에 해당하는 게시글에 조회수 1 증가
	public void updatecnt(int bno) {
		sqlSession.update("board.updatecnt",bno);
	}
	
	//글번호에 해당하는 게시글 가져오기
	public Board detail(int bno) {
		return sqlSession.selectOne("board.detail", bno);
	}
	
	//글번호에 해당하는 게시글 수정
	public void update(Board board) {
		sqlSession.update("board.update", board);
	}
	
	//글번호에 해당하는 게시글 삭제
	public void delete(int bno) {
		sqlSession.delete("board.delete", bno);
	}
	
	//게시글 전체개수 가져오기
	public int totalCount(SearchCriteria criteria) {
		return sqlSession.selectOne("board.totalcount",criteria);
	}
	
	//댓글 개수
	public int replycnt(int bno) {
		return sqlSession.selectOne("board.replycnt", bno);
	}
	
	//id에 해당하는 게시글 가져오기
	public List<Board> mypage(Criteria criteria) {
		return sqlSession.selectList("board.mypage",criteria);
	}
	
	//id에 해당하는 게시글 전체개수 가져오기
	public int mypageCount(String id) {
		return sqlSession.selectOne("board.mypagecount", id);
	}
	
	
}
