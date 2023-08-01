package hello.servlet.web.frontcontroller.v1.controller;

import java.io.IOException;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV1 implements ControllerV1 {
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("username==="+ username);
		Member member = new Member(username, age);

		memberRepository.save(member);
		// model에 데이터 보관
		request.setAttribute("member", member);
		String viewPath = "WEB-INF/views/save-result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		System.out.println("3333333333333333");
		dispatcher.forward(request, response);
		
		System.out.println("4444444444444444444");
	}
}
