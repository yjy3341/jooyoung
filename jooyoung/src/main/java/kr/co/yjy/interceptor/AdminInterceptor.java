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

	//true�� �����ϸ� Controller�� �Ѿ��
	//false�� �����ϸ� Controller�� �Ѿ�� �ʽ��ϴ�.
	//Controller�� ó���ϱ� ���� ȣ��Ǵ� �޼ҵ�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user.getAuthority() == null) {
			//������ �ּ�
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
