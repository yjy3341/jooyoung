package kr.co.yjy;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.yjy.domain.Board;
import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.SearchCriteria;
import kr.co.yjy.service.BoardService;



@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value="board/board", method=RequestMethod.GET)
	public String board(SearchCriteria criteria,Model model) {
		Map<String, Object> map = boardService.board(criteria);
		model.addAttribute("map",map);
		return "board/board";
	}
	

	
	@RequestMapping(value="board/register", method=RequestMethod.GET)
	public String register() {
		return "board/register";
	}
	
	@RequestMapping(value="board/register", method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest request, RedirectAttributes attr) {
		boardService.register(request);
		return "redirect:board";
	}
	
	@RequestMapping(value="board/detail", method=RequestMethod.GET)
	//현재 페이지 번호와 페이지 당 출력 개수를 criteria를 저장하고
	//다음 페이지에 자동으로 전달
	public String detail(Criteria criteria, HttpServletRequest request, Model model) {
		Board board = boardService.detail(request);
		model.addAttribute("vo",board);
		return "board/detail";
	}
	
	@RequestMapping(value="board/update", method=RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		Board board = boardService.updateView(request);
		model.addAttribute("vo", board);
		return "board/update";
	}
	
	@RequestMapping(value="board/update", method=RequestMethod.POST)
	public String update(Criteria criteria, HttpServletRequest request, Model model, RedirectAttributes attr) {
		boardService.update(request);
		return "redirect:board";
	}
	
	@RequestMapping(value="board/delete", method=RequestMethod.GET)
	public String delete(Criteria criteria, HttpServletRequest request, RedirectAttributes attr) {
		boardService.delete(request);
		return "redirect:board?page=" + criteria.getPage() + "&perPageNum=" + criteria.getPerPageNum();
	}	


	
}
