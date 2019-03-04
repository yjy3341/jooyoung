package kr.co.yjy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.yjy.domain.Reply;
import kr.co.yjy.service.ReplyService;

//결과를 html 화면으로 만드는 것이 아니고
//text 나 json으로 만들어주는 Contorller를 만들어 주는
//어노테이션

@RestController
public class ReplyJsonController {

	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="reply/register", method=RequestMethod.GET)
	public Map<String, Object> register(HttpServletRequest request){
		boolean result = replyService.register(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
	@RequestMapping(value="reply/reply", method=RequestMethod.GET)
	public List<Reply> reply(HttpServletRequest request){
		return replyService.reply(request);
	}
	
	@RequestMapping(value="reply/delete", method=RequestMethod.GET)
	public Map<String, Object> delete(HttpServletRequest request){
		boolean result = replyService.delete(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
	@RequestMapping(value="reply/update", method=RequestMethod.GET)
	public Map<String, Object> update(HttpServletRequest request){
		boolean result = replyService.update(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
}
