package com.care.get_post;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	public MyController() {
		System.out.println("MyController 생성자 실행");
	}
	
	@RequestMapping(value="my/index", method = RequestMethod.GET)  //이방법과
	public String index() {
		return "/get_post/index";
	}
	
	@GetMapping("my/result") //이방법은 같다
	public String result_get(HttpServletRequest request, Model model) {//이렇게 하면 사용자가 입력한 정보가 request 객체에 들어온다
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("get방식으로 들어왔습니다");
		System.out.println("name : "+name);
		System.out.println("age : "+age);
		
		model.addAttribute("method", request.getMethod() );
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "/get_post/result";
	}
	//@PostMapping("my/result")
	@RequestMapping(value="my/result", method = RequestMethod.POST)
	public String reuslt_post(HttpServletRequest request, Model model,
								@RequestParam("name") String name,      //어노테이션으로 처리. @RequestParam:사용자가 요청한값 받아옴
								@RequestParam("age") String age) {     //age로 넘어오는 값은 age에 저장하겠다
		System.out.println("post방식으로 들어왔습니다");
		
		model.addAttribute("method", request.getMethod() );
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "/get_post/result";
	}
}	