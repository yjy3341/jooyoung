package kr.co.yjy;


import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.User;
import kr.co.yjy.service.BoardService;
import kr.co.yjy.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="user/register",method=RequestMethod.GET)
	public String register() {
		return "user/register";	
	}
	//ȸ������
	@RequestMapping(value="user/register",method=RequestMethod.POST)
	public String register(HttpServletRequest request,RedirectAttributes attr) {
		userService.register(request);
		attr.addFlashAttribute("registermsg", "ȸ�������� �Ϸ�Ǿ����ϴ�.");
		return "redirect:/";
	}
	
	@RequestMapping(value="user/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request,RedirectAttributes attr, HttpSession session) {
		User user = userService.login(request);
	
		if(user == null) {
			attr.addFlashAttribute("loginmsg","���̵� ��й�ȣ Ȯ�ιٶ��ϴ�.");
			return "redirect:/";
		}
		else {
		
			session.setAttribute("user", user);
			session.setAttribute("id", user.getId());
			session.setAttribute("authority", user.getAuthority());
	
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="user/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		//������ �ʱ�ȭ
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="user/mypage", method=RequestMethod.GET)
	public String mypage(Model model,HttpSession session,Criteria criteria) {
		String id = (String) session.getAttribute("id");
		
		Map<String, Object>map = boardService.mypage(criteria, id);
		model.addAttribute("map", map);
		
		return "user/mypage";
	}
	
	@RequestMapping(value="user/update",method=RequestMethod.GET)
	public String update() {
		return "user/update";	
	}
	
	@RequestMapping(value="user/update",method=RequestMethod.POST)
	public String update(HttpSession session,RedirectAttributes attr,HttpServletRequest request) {
		String id = (String) session.getAttribute("id");
		userService.update(id, request);
		attr.addFlashAttribute("updatemsg","��й�ȣ ������ �Ϸ�Ǿ����ϴ�.!");		
		return "redirect:/";	
	}
	

	
}
