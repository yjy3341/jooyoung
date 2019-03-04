package kr.co.yjy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.co.yjy.domain.User;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	//true를 리턴하면 Controller로 넘어가고
	//false를 리턴하면 Controller로 넘어가지 않습니다.
	//Controller가 처리하기 전에 호출되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user.getAuthority() == null) {
			//서버의 주소
			String contextPath = request.getContextPath();
				
			response.sendRedirect(contextPath + "/");
			return false;
		
		}
		return true;
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	

	}

}
