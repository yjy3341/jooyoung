package kr.co.yjy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.yjy.service.UserService;

@RestController
public class UserJsonController {

	@Autowired
	private UserService userService;
	
/*	@RequestMapping(value="user/register",method=RequestMethod.POST)
	public Map<String, Object> sunregister(HttpServletRequest request){
		boolean result = userService.register(request);
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}*/
	
	//아이디 중복 체크
	@RequestMapping(value="user/idcheck",method=RequestMethod.GET)
	public Map<String, Object> idCheck(HttpServletRequest request){
		
		String id = userService.idCheck(request);
		
		Map<String, Object> map =
				new HashMap<String, Object>();
		map.put("result", id == null);
		
		return map;
	}
	
	//닉네임 중복 체크
	@RequestMapping(value="user/nicknamecheck",method=RequestMethod.GET)
	public Map<String, Object> nicknameCheck(HttpServletRequest request){
		
		String nickname = userService.nicknameCheck(request);
		
		Map<String, Object> map =
				new HashMap<String, Object>();
		map.put("result", nickname == null);
		
		return map;
	}
	
	//회원 탈퇴
	@RequestMapping(value="user/delete",method=RequestMethod.GET)
	public Map<String, Object> delete(HttpSession session,HttpServletRequest request, String id){

		boolean result = userService.delete(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		//세션을 초기화
		session.invalidate();
		return map;
	}
	
}
