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
	
	//��� ����       register
	public int register(Reply reply) {
		return sqlSession.insert("reply.register", reply);
	
	}
	
	//�Խñۿ� �ش��ϴ� ��۸�� ��������
	public List<Reply> reply(int bno){
		return sqlSession.selectList("reply.reply", bno);
	}
	
	//��� ����
	public int delete(int rno) {
		return sqlSession.delete("reply.delete", rno);
	}
	
	//��� ����
	public int update(Reply reply) {
		return sqlSession.update("reply.update", reply);
	}

}
