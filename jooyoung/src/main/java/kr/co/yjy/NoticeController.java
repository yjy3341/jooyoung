package kr.co.yjy;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.yjy.domain.Board;
import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.Notice;
import kr.co.yjy.domain.SearchCriteria;
import kr.co.yjy.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="notice/notice", method=RequestMethod.GET)
	public String board(Criteria criteria,Model model) {
		Map<String, Object> notice = noticeService.notice(criteria);
		model.addAttribute("map",notice);
		return "notice/notice";
	}
	
	@RequestMapping(value="notice/register", method=RequestMethod.GET)
	public String register() {
		return "notice/register";
	}
	
	@RequestMapping(value="notice/register", method=RequestMethod.POST)
	public String noticeboard(HttpServletRequest request, RedirectAttributes attr) {
		noticeService.register(request);
		return "redirect:notice";
	}
	
	@RequestMapping(value="notice/detail", method=RequestMethod.GET)
	public String detail(Criteria criteria,HttpServletRequest request, Model model) {
		Notice notice = noticeService.detail(request);
		model.addAttribute("vo", notice);
		return "notice/detail";
	}
	
	@RequestMapping(value="notice/update", method=RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		Notice notice = noticeService.updateView(request);
		model.addAttribute("vo", notice);
		return "notice/update";
	}
	
	@RequestMapping(value="notice/update", method=RequestMethod.POST)
	public String update(HttpServletRequest request, Model model, RedirectAttributes attr) {
		noticeService.updateView(request);
		return "redirect:notice";
	}
	
	@RequestMapping(value="notice/delete", method=RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model, RedirectAttributes attr) {
		noticeService.delete(request);
		return "redirect:notice";
	}
	
	
}
