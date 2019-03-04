package kr.co.yjy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.co.yjy.domain.User;

//�ѹ� �˾ƺ���
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
		
		//true�� �����ϸ� Controller�� �Ѿ��
		//false�� �����ϸ� Controller�� �Ѿ�� �ʽ��ϴ�.
		//Controller�� ó���ϱ� ���� ȣ��Ǵ� �޼ҵ�
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			//�α����� Ȯ���ϱ� ���ؼ� session��������
			HttpSession session = request.getSession();
			
			User user = (User) session.getAttribute("user");
			//�α��� ������ session �� user �Ӽ��� ����Ǿ� �ֽ��ϴ�.
			//�α��� �Ǿ� ���� ������ Controller�� ���� �ʽ��ϴ�.
			if(session.getAttribute("user") == null) {
				
				//������ �ּ�
				String contextPath = request.getContextPath();

				//�α��� �������� �����̷�Ʈ
				response.sendRedirect(contextPath + "/");
				return false;
			}
			//�α��� �Ǿ� �ִ� ���� Controller�� ó��
			return true;
		}
		
		//Controller�� ������� ��û�� ���������� ó���ϰ� �� �� ȣ��Ǵ� �޼ҵ�
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
		}

		//Controller���� ���� �߻� ���ο� ������� ȣ��Ǵ� �޼ҵ�
		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
		}

	}

