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

	//댓글 저장
	@Override
	public boolean register(HttpServletRequest request) {
		boolean result = false;
		
		//파라미터 읽기
		String bno = request.getParameter("bno");
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String replytext = request.getParameter("replytext");


		
		//Dao의 파라미터 만들기
		Reply reply = new Reply();
		reply.setBno(Integer.parseInt(bno));
		reply.setId(id);
		reply.setNickname(nickname);
		reply.setReplytext(replytext);

		
		//Dao메소드 호출
		int r = replyDao.register(reply);
		
		//Dao의 호출결과 가지고 리턴할 결과 만들기
		if(r > 0)
			result = true;
		return result;
	}

	//글번호에 해당하는 댓글 목록 가져오기
	@Override
	public List<Reply> reply(HttpServletRequest request) {
		List<Reply> reply = new ArrayList<Reply>();
		
		//파라미터 읽기
		String bno = request.getParameter("bno");
		
		//Dao메소드 호출
		reply = replyDao.reply(Integer.parseInt(bno));
		
		return reply;
	}

	@Override
	public boolean delete(HttpServletRequest request) {
		boolean result = false;
		
		//파라미터 읽기
		String rno = request.getParameter("rno");
		
		//Dao메소드 호출
		int r = replyDao.delete(Integer.parseInt(rno));
		
		//Dao의 호출결과 가지고 리턴할 결과 만들기
		if(r > 0)
			result = true;
		return result;
	}

	@Override
	public boolean update(HttpServletRequest request) {
		boolean result = false;
		
		//파라미터 읽기
		String rno = request.getParameter("rno");
		String replytext = request.getParameter("replytext");
		
		//Dao 파라미터 만들기
		Reply reply = new Reply();
		reply.setRno(Integer.parseInt(rno));
		reply.setReplytext(replytext);
		
		//Dao 메소드 호출
		int r = replyDao.update(reply);
		
		if(r > 0)
			result = true;
		return result;
	}

}
