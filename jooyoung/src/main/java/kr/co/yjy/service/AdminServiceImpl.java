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
			//���� ������ ��ȣ�� 1���ҽ��Ѽ� �����͸� �ٽ� ��������
			criteria.setPage(criteria.getPage()-1);
			userlist = adminDao.userlist(criteria);
		}
		
		
		map.put("userlist", userlist);
		
		
		//������ ��ȣ ��� �����
		PageMaker pageMaker = new PageMaker();
		//���� �������� ������ �� ��� ������ ����
		pageMaker.setCriteria(criteria);
		//��ü ������ ���� ����
		pageMaker.setTotalCount(adminDao.userCount(criteria));
		//������ ��ȣ ��� Map�� ����
		map.put("pageMaker", pageMaker);
		return map;
	}

	@Override
	public boolean delete(HttpServletRequest request) {
boolean result = false;
		
		//�Ķ���� �б�
		String id = request.getParameter("id");
		
		//Dao�޼ҵ� ȣ��
		int r = adminDao.delete(id);
		
		//Dao�� ȣ���� ������ ������ ��� �����
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
