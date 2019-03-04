package kr.co.yjy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import kr.co.yjy.domain.Review;
import kr.co.yjy.service.ReviewService;

//����� html ȭ������ ����� ���� �ƴϰ�
//text �� json���� ������ִ� Contorller�� ����� �ִ�
//������̼�

@RestController
public class ReviewJsonController {
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="review/register", method=RequestMethod.GET)
	public Map<String, Object> register(HttpServletRequest request){
		boolean result = reviewService.register(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
	@RequestMapping(value="review/review", method=RequestMethod.GET)
	public List<Review> review(HttpServletRequest request){
		return reviewService.review(request);
	}

	@RequestMapping(value="review/delete", method=RequestMethod.GET)
	public Map<String, Object> delete(HttpServletRequest request){
		boolean result = reviewService.delete(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
	
	@RequestMapping(value="review/update", method=RequestMethod.GET)
	public Map<String, Object> update(HttpServletRequest request){
		boolean result = reviewService.update(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
}
