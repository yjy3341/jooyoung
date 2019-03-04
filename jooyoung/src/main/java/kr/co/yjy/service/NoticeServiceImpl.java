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

	//게시글 작성
	@Override
	public void register(HttpServletRequest request) {
		//파라미터 읽기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//로그인 한 유저의 id와 nickname
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

	//게시글 목록 가져오기
	@Override
	public Map<String, Object> notice(Criteria criteria) {
		//결과를 저장할 Map을 생성
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Notice> list = noticeDao.notice(criteria);
		//마지막 페이지에 있는 데이터가 1개 밖에 없을 때
		//그 데이터를 삭제하면 그 페이지의 데이터는 없습니다.
		if(list.size() == 0) {
			//현재 페이지 번호를 1감소시켜서 데이터를 다시 가져오기
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
		//페이지 번호 목록 만들기
		PageMaker pageMaker = new PageMaker();
		//현재 페이지와 페이지 당 출력 개수는 저장
		pageMaker.setCriteria(criteria);
		//전체 데이터 개수 저장 
		pageMaker.setTotalCount(noticeDao.totalCount(criteria));
		//페이지 번호 목록 Map에 저장
		map.put("pageMaker", pageMaker);
		
		return map;
	}

	//게시글 상세보기
	@Override
	public Notice detail(HttpServletRequest request) {
		String nno = request.getParameter("nno");
		
		//조회수 1증가 메소드 호출
		//String형이므로 Integer로 형변환 
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
