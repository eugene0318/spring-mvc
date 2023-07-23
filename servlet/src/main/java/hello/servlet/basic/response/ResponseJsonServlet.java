package hello.servlet.basic.response;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Content-Type: application/json
		resp.setHeader("content-type", "application/json");
		 resp.setCharacterEncoding("utf-8");
		 HelloData data = new HelloData();
		 data.setUsername("kim");
		 data.setAge(20);
		 //{"username":"kim","age":20}
		 String result = objectMapper.writeValueAsString(data);
		 resp.getWriter().write(result);
	}
}
