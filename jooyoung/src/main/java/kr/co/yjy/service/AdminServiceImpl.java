package kr.co.yjy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yjy.dao.AdminDao;
import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.PageMaker;
import kr.co.yjy.domain.User;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Map<String, Object> userlist(Criteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<User> userlist = adminDao.userlist(criteria);
		
		if(userlist.size() == 0) {
			//현재 페이지 번호를 1감소시켜서 데이터를 다시 가져오기
			criteria.setPage(criteria.getPage()-1);
			userlist = adminDao.userlist(criteria);
		}
		
		
		map.put("userlist", userlist);
		
		
		//페이지 번호 목록 만들기
		PageMaker pageMaker = new PageMaker();
		//현재 페이지와 페이지 당 출력 개수는 저장
		pageMaker.setCriteria(criteria);
		//전체 데이터 개수 저장
		pageMaker.setTotalCount(adminDao.userCount(criteria));
		//페이지 번호 목록 Map에 저장
		map.put("pageMaker", pageMaker);
		return map;
	}

	@Override
	public boolean delete(HttpServletRequest request) {
boolean result = false;
		
		//파라미터 읽기
		String id = request.getParameter("id");
		
		//Dao메소드 호출
		int r = adminDao.delete(id);
		
		//Dao의 호출결과 가지고 리턴할 결과 만들기
		if(r > 0)
			result = true;
		return result;
	}

	@Override
	public User userdetail(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		
		return adminDao.userdetail(id);
	}

	@Override
	public void userdelete(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		adminDao.userdelete(id);
	}

}
