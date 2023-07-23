package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.net.http.HttpResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// [status-line]
		resp.setStatus(HttpServletResponse.SC_OK);
		// [response-header]
		resp.setHeader("Content-Type", "text/plain;chareset=utf-8");
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("my-header", "hello");
		//cookie(resp);
		Redirect(resp);
		PrintWriter writer = resp.getWriter();
		writer.print("ok");
	}

	private void Redirect(HttpServletResponse resp) throws IOException {
		resp.setStatus(HttpServletResponse.SC_FOUND);
		resp.sendRedirect("/basic/hello-form.html");
		
	}

	private void content(HttpServletResponse response) {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
	}
	
	private void cookie(HttpServletResponse response) {
		 //Set-Cookie: myCookie=good; Max-Age=600;
		 //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
		 Cookie cookie = new Cookie("myCookie", "good");
		 cookie.setMaxAge(600); //600초
		 response.addCookie(cookie);
		}
}
