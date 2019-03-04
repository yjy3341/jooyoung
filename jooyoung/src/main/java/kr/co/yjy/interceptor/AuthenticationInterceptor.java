package kr.co.yjy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.co.yjy.domain.User;

//한번 알아볼것
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
		
		//true를 리턴하면 Controller로 넘어가고
		//false를 리턴하면 Controller로 넘어가지 않습니다.
		//Controller가 처리하기 전에 호출되는 메소드
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			//로그인을 확인하기 위해서 session가져오기
			HttpSession session = request.getSession();
			
			User user = (User) session.getAttribute("user");
			//로그인 정보는 session 의 user 속성에 저장되어 있습니다.
			//로그인 되어 있지 않으면 Controller로 가지 않습니다.
			if(session.getAttribute("user") == null) {
				
				//서버의 주소
				String contextPath = request.getContextPath();

				//로그인 페이지로 리다이렉트
				response.sendRedirect(contextPath + "/");
				return false;
			}
			//로그인 되어 있는 경우는 Controller가 처리
			return true;
		}
		
		//Controller가 사용자의 요청을 정상적으로 처리하고 난 후 호출되는 메소드
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
		}

		//Controller에서 예외 발생 여부에 상관없이 호출되는 메소드
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
		}

	}

