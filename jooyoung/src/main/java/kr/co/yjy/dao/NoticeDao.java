package kr.co.yjy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.Notice;
import kr.co.yjy.domain.SearchCriteria;

@Repository
public class NoticeDao {

	@Autowired
	private SqlSession sqlSession;
	
	//게시글 작성
	public void register(Notice notice) {
		sqlSession.insert("notice.register", notice);
	}

	//게시글 목록 가져오기
	public List<Notice> notice(Criteria criteria){
		return sqlSession.selectList("notice.notice", criteria);
	}
	
	//게시글 상세보기
	public Notice detail(int nno) {
		return sqlSession.selectOne("notice.detail", nno);
	}
	
	//글번호에 해당하는 게시글에 조회수 1 증가
	public void updatecnt(int nno) {
		sqlSession.update("board.updatecnt",nno);
	}
	
	//글번호에 해당하는 게시글 수정
	public void update(Notice notice) {
		sqlSession.update("notice.update", notice);
	}
	
	//글번호에 해당하는 게시글 삭제
	public void delete(int nno) {
		sqlSession.delete("notice.delete", nno);
	}
	
	//게시글 전체개수 가져오기
	public int totalCount(Criteria criteria) {
		return sqlSession.selectOne("notice.totalcount",criteria);
	}
}


