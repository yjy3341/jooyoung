package kr.co.yjy;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.User;
import kr.co.yjy.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="admin/userlist", method=RequestMethod.GET)
	public String userlist(Criteria criteria,Model model) {
		Map<String, Object> map = adminService.userlist(criteria);
		model.addAttribute("map",map);
		return "admin/userlist";
	}
	
	@RequestMapping(value="admin/userdetail", method=RequestMethod.GET)
	public String userdetail(Criteria criteria,Model model,HttpServletRequest request) {
		User user = adminService.userdetail(request);
		model.addAttribute("vo", user);
		return "admin/userdetail";
	}
	
	@RequestMapping(value="admin/userdelete", method=RequestMethod.GET)
	public String userdelete(Criteria criteria,Model model,HttpServletRequest request) {
		adminService.userdelete(request);
		
		return "redirect:userlist?page=" + criteria.getPage() + "&perPageNum=" + criteria.getPerPageNum();
	}
	
}
