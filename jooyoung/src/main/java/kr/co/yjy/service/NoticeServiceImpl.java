package kr.co.yjy.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yjy.dao.NoticeDao;
import kr.co.yjy.domain.Board;
import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.Notice;
import kr.co.yjy.domain.PageMaker;
import kr.co.yjy.domain.SearchCriteria;
import kr.co.yjy.domain.User;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	//�Խñ� �ۼ�
	@Override
	public void register(HttpServletRequest request) {
		//�Ķ���� �б�
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//�α��� �� ������ id�� nickname
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String id = user.getId();
		String nickname = user.getNickname();
		
		Notice noard = new Notice();
		noard.setTitle(title);
		noard.setContent(content);
		noard.setNickname(nickname);
		noard.setId(id);
		
		noticeDao.register(noard);
	}

	//�Խñ� ��� ��������
	@Override
	public Map<String, Object> notice(Criteria criteria) {
		//����� ������ Map�� ����
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Notice> list = noticeDao.notice(criteria);
		//������ �������� �ִ� �����Ͱ� 1�� �ۿ� ���� ��
		//�� �����͸� �����ϸ� �� �������� �����ʹ� �����ϴ�.
		if(list.size() == 0) {
			//���� ������ ��ȣ�� 1���ҽ��Ѽ� �����͸� �ٽ� ��������
			criteria.setPage(criteria.getPage()-1);
			list = noticeDao.notice(criteria);
		}
		
		Calendar cal = Calendar.getInstance();
		Date today = new Date(cal.getTimeInMillis());
		for(Notice notice : list) {
			String regdate = notice.getRegdate().substring(0, 10);
			if(today.toString().equals(regdate)) {
				notice.setDispDate(notice.getRegdate().substring(11, 16));;
			}else {
				notice.setDispDate(regdate);
			}
		}
		map.put("list", list);
		//������ ��ȣ ��� �����
		PageMaker pageMaker = new PageMaker();
		//���� �������� ������ �� ��� ������ ����
		pageMaker.setCriteria(criteria);
		//��ü ������ ���� ���� 
		pageMaker.setTotalCount(noticeDao.totalCount(criteria));
		//������ ��ȣ ��� Map�� ����
		map.put("pageMaker", pageMaker);
		
		return map;
	}

	//�Խñ� �󼼺���
	@Override
	public Notice detail(HttpServletRequest request) {
		String nno = request.getParameter("nno");
		
		//��ȸ�� 1���� �޼ҵ� ȣ��
		//String���̹Ƿ� Integer�� ����ȯ 
		noticeDao.updatecnt(Integer.parseInt(nno));
		return noticeDao.detail(Integer.parseInt(nno));
	}

	@Override
	public Notice updateView(HttpServletRequest request) {
		String nno = request.getParameter("nno");
		return noticeDao.detail(Integer.parseInt(nno));
	}

	@Override
	public void update(HttpServletRequest request) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String nno = request.getParameter("nno");
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setNno(Integer.parseInt(nno));
		
		noticeDao.update(notice);
	}

	@Override
	public void delete(HttpServletRequest request) {
		String nno = request.getParameter("nno");
		
		noticeDao.delete(Integer.parseInt(nno));
		
	}


	
	
}
