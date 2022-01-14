package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CodeUtils;
import utils.EmailUtils;

public class MailServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		try {
			if (method.equals("toMail")) {
				toMail(request,response);
			}
		} catch (UnsupportedEncodingException | MessagingException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void toMail(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, MessagingException, GeneralSecurityException {
		// TODO Auto-generated method stub
		//获得地址
		String ucode = CodeUtils.createCode();
		EmailUtils.sendMail("2381479088@qq.com");
		
		}
	
}
