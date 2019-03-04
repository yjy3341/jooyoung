package kr.co.yjy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.yjy.domain.Reply;

@Repository
public class ReplyDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//댓글 저장       register
	public int register(Reply reply) {
		return sqlSession.insert("reply.register", reply);
	
	}
	
	//게시글에 해당하는 댓글목록 가져오기
	public List<Reply> reply(int bno){
		return sqlSession.selectList("reply.reply", bno);
	}
	
	//댓글 삭제
	public int delete(int rno) {
		return sqlSession.delete("reply.delete", rno);
	}
	
	//댓글 수정
	public int update(Reply reply) {
		return sqlSession.update("reply.update", reply);
	}

}
