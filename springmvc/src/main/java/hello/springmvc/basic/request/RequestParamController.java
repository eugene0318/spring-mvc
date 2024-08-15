package hello.springmvc.basic.request;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {

	@RequestMapping("/request-param-v1")
	public void requestParamv1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		response.getWriter().write("ok");
	}

	@ResponseBody
	@RequestMapping("/request-param-v2")
	public String requestParamV2(@RequestParam("username") String username, @RequestParam("age") int memberAge) {
		log.info("username={}, age={}", username, memberAge);
		return "ok";

	}

	/**
	 * @RequestParam 사용 String, int 등의 단순 타입이면 @RequestParam 도 생략 가능
	 */
	@ResponseBody
	@RequestMapping("/request-param-v4")
	public String requestParamV4(String username, int age) {
		log.info("username={}, age={}", username, age);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-required")
	public String requestParamRequired(@RequestParam(required = true) String username,
			@RequestParam(required = false) Integer age) {
		log.info("username={}, age={}", username, age);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
			@RequestParam(required = false, defaultValue = "-1") int age) {
		log.info("username={}, age={}", username, age);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-mpa")
	public String requestParamMap(@RequestParam Map<String, Object> paramJMap) {
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/model-attribute-v1")
	public String modelAttributeV1(@ModelAttribute HelloData helloData) {
		log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/model-attribute-v2")
	public String modelAttributeV2(HelloData helloData) {
		log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
		return "ok";
	}
}
