package kr.co.yjy.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yjy.dao.ReplyDao;
import kr.co.yjy.domain.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;

	//��� ����
	@Override
	public boolean register(HttpServletRequest request) {
		boolean result = false;
		
		//�Ķ���� �б�
		String bno = request.getParameter("bno");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String replytext = request.getParameter("replytext");


		
		//Dao�� �Ķ���� �����
		Reply reply = new Reply();
		reply.setBno(Integer.parseInt(bno));
		reply.setId(id);
		reply.setNickname(nickname);
		reply.setReplytext(replytext);

		
		//Dao�޼ҵ� ȣ��
		int r = replyDao.register(reply);
		
		//Dao�� ȣ���� ������ ������ ��� �����
		if(r > 0)
			result = true;
		return result;
	}

	//�۹�ȣ�� �ش��ϴ� ��� ��� ��������
	@Override
	public List<Reply> reply(HttpServletRequest request) {
		List<Reply> reply = new ArrayList<Reply>();
		
		//�Ķ���� �б�
		String bno = request.getParameter("bno");
		
		//Dao�޼ҵ� ȣ��
		reply = replyDao.reply(Integer.parseInt(bno));
		
		return reply;
	}

	@Override
	public boolean delete(HttpServletRequest request) {
		boolean result = false;
		
		//�Ķ���� �б�
		String rno = request.getParameter("rno");
		
		//Dao�޼ҵ� ȣ��
		int r = replyDao.delete(Integer.parseInt(rno));
		
		//Dao�� ȣ���� ������ ������ ��� �����
		if(r > 0)
			result = true;
		return result;
	}

	@Override
	public boolean update(HttpServletRequest request) {
		boolean result = false;
		
		//�Ķ���� �б�
		String rno = request.getParameter("rno");
		String replytext = request.getParameter("replytext");
		
		//Dao �Ķ���� �����
		Reply reply = new Reply();
		reply.setRno(Integer.parseInt(rno));
		reply.setReplytext(replytext);
		
		//Dao �޼ҵ� ȣ��
		int r = replyDao.update(reply);
		
		if(r > 0)
			result = true;
		return result;
	}

}
