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
	
	//�� ����
	public void register(Board board) {
		sqlSession.insert("board.register", board);
	}
	
	//�� ��� ��������
	/*public List<Board> board(){
		return sqlSession.selectList("board.board");
	}*/
	
	//�� ��� ��������
	public List<Board> board(SearchCriteria criteria){
		return sqlSession.selectList("board.board", criteria);
	}
	
	//�۹�ȣ�� �ش��ϴ� �Խñۿ� ��ȸ�� 1 ����
	public void updatecnt(int bno) {
		sqlSession.update("board.updatecnt",bno);
	}
	
	//�۹�ȣ�� �ش��ϴ� �Խñ� ��������
	public Board detail(int bno) {
		return sqlSession.selectOne("board.detail", bno);
	}
	
	//�۹�ȣ�� �ش��ϴ� �Խñ� ����
	public void update(Board board) {
		sqlSession.update("board.update", board);
	}
	
	//�۹�ȣ�� �ش��ϴ� �Խñ� ����
	public void delete(int bno) {
		sqlSession.delete("board.delete", bno);
	}
	
	//�Խñ� ��ü���� ��������
	public int totalCount(SearchCriteria criteria) {
		return sqlSession.selectOne("board.totalcount",criteria);
	}
	
	//��� ����
	public int replycnt(int bno) {
		return sqlSession.selectOne("board.replycnt", bno);
	}
	
	//id�� �ش��ϴ� �Խñ� ��������
	public List<Board> mypage(Criteria criteria) {
		return sqlSession.selectList("board.mypage",criteria);
	}
	
	//id�� �ش��ϴ� �Խñ� ��ü���� ��������
	public int mypageCount(String id) {
		return sqlSession.selectOne("board.mypagecount", id);
	}
	
	
}
