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
	
	//스프링 시큐리티에서 기본적으로 사용하는 암호화 방식으로 함호화가 될때마다 새로운 값을 생성 BCryptPasswordEncoder
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	//아이디 중복 체크
	@Override
	public String idCheck(HttpServletRequest request) {
		String id = request.getParameter("id");
		return userDao.idCheck(id);
	}
	
	//회원가입
	@Override
	public void register(HttpServletRequest request) {

		//rawPass 암호화 되지 않음 암호
		String rawPass = request.getParameter("pw");
		
		String id = request.getParameter("id");
		//암호화된 암호
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

	//로그인
	@Override
	public User login(HttpServletRequest request) {
		String id = request.getParameter("loginid");
		String pw = request.getParameter("loginpw");
			
		User user = userDao.login(id);
		if(user != null) {
			// matches 메서드는 입력한 패스워드와 저장된 패스워드를 비교하고, 같다면 true 틀리면 false를 리턴합니다.
			boolean passMatch = passEncoder.matches(pw, user.getPw());
			//비밀번호가 일치하면 비밀번호만 초기화
			if(passMatch == true) {
				user.setPw("");
			}
			//일치하지않으면
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

	//비밀번호 변경
	@Override
	public void update(String id, HttpServletRequest request) {
		//파라미터 읽기
		//rawPass 암호화 되지 않음 암호
		String rawPass = request.getParameter("pw");
		//암호화된 암호
		String pw = passEncoder.encode(rawPass);
		User user = new User();
		user.setPw(pw);
		user.setId(id);
		
		userDao.update(user);
		
	}

	@Override
	public User idfind(HttpServletRequest request) {
		//파라미터 읽기
		String name = request.getParameter("name");
		
		User user = userDao.idfind(name);
		if(user == null) {
			
				user = null;
			}
		return user;
		}
		/*return userDao.idfind(name);*/

	}

	
	


