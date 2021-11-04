package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import model.service.MemberService;


@WebServlet(urlPatterns={"/member/login.controller"})
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	
	@Override
	public void init() throws ServletException {
		ApplicationContext context = (ApplicationContext)this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		memberService = (MemberService)context.getBean("memberService");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收資料
		String account = request.getParameter("useraccount");
		String password = request.getParameter("userpassword");
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		if(account==null || account.length()==0) {
			errors.put("useraccount", "請輸入帳號");
		}
		if(password==null || password.length()==0) {
			errors.put("userpassword", "請輸入密碼");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/member/login.jsp").forward(request, response);
			return;
		}
		//呼叫model
		
		//導向view
		
		
	}

}
