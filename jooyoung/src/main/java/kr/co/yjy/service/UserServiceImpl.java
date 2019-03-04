package kr.co.yjy.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.yjy.dao.UserDao;
import kr.co.yjy.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	//������ ��ť��Ƽ���� �⺻������ ����ϴ� ��ȣȭ ������� ��ȣȭ�� �ɶ����� ���ο� ���� ���� BCryptPasswordEncoder
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	//���̵� �ߺ� üũ
	@Override
	public String idCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		return userDao.idCheck(id);
	}
	
	//ȸ������
	@Override
	public void register(HttpServletRequest request) {

		//rawPass ��ȣȭ ���� ���� ��ȣ
		String rawPass = request.getParameter("pw");
		
		String id = request.getParameter("id");
		//��ȣȭ�� ��ȣ
		String pw = passEncoder.encode(rawPass);
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		/*String authority = request.getParameter("authority");*/
		
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		user.setNickname(nickname);
		user.setName(name);
		user.setGender(gender);
/*		user.setAuthority(authority);*/
		
		userDao.register(user);
	}

	//�α���
	@Override
	public User login(HttpServletRequest request) {
		String id = request.getParameter("loginid");
		String pw = request.getParameter("loginpw");
			
		User user = userDao.login(id);
		if(user != null) {
			// matches �޼���� �Է��� �н������ ����� �н����带 ���ϰ�, ���ٸ� true Ʋ���� false�� �����մϴ�.
			boolean passMatch = passEncoder.matches(pw, user.getPw());
			//��й�ȣ�� ��ġ�ϸ� ��й�ȣ�� �ʱ�ȭ
			if(passMatch == true) {
				user.setPw("");
			}
			//��ġ����������
			else {
				user = null;
			}
		}
		return user;
	}

	@Override
	public String nicknameCheck(HttpServletRequest request) {
		String nickname = request.getParameter("nickname");
		return userDao.nicknameCheck(nickname);
	}

	@Override
	public boolean delete(String id) {
		boolean result = false;
		
		int r = userDao.delete(id);
		if(r > 0) {
			result = true;
		}
		return result;
	}

	//��й�ȣ ����
	@Override
	public void update(String id, HttpServletRequest request) {
		//�Ķ���� �б�
		//rawPass ��ȣȭ ���� ���� ��ȣ
		String rawPass = request.getParameter("pw");
		//��ȣȭ�� ��ȣ
		String pw = passEncoder.encode(rawPass);
		User user = new User();
		user.setPw(pw);
		user.setId(id);
		
		userDao.update(user);
		
	}

	@Override
	public User idfind(HttpServletRequest request) {
		//�Ķ���� �б�
		String name = request.getParameter("name");
		
		User user = userDao.idfind(name);
		if(user == null) {
			
				user = null;
			}
		return user;
		}
		/*return userDao.idfind(name);*/

	}

	
	


