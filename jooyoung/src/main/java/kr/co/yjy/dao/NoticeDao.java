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
	
	//�Խñ� �ۼ�
	public void register(Notice notice) {
		sqlSession.insert("notice.register", notice);
	}

	//�Խñ� ��� ��������
	public List<Notice> notice(Criteria criteria){
		return sqlSession.selectList("notice.notice", criteria);
	}
	
	//�Խñ� �󼼺���
	public Notice detail(int nno) {
		return sqlSession.selectOne("notice.detail", nno);
	}
	
	//�۹�ȣ�� �ش��ϴ� �Խñۿ� ��ȸ�� 1 ����
	public void updatecnt(int nno) {
		sqlSession.update("board.updatecnt",nno);
	}
	
	//�۹�ȣ�� �ش��ϴ� �Խñ� ����
	public void update(Notice notice) {
		sqlSession.update("notice.update", notice);
	}
	
	//�۹�ȣ�� �ش��ϴ� �Խñ� ����
	public void delete(int nno) {
		sqlSession.delete("notice.delete", nno);
	}
	
	//�Խñ� ��ü���� ��������
	public int totalCount(Criteria criteria) {
		return sqlSession.selectOne("notice.totalcount",criteria);
	}
}


