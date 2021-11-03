package com.care.root;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	//@Autowired //빈주입해주는데 자료형을 보고 주입한다
	@Inject
	@Qualifier("mmm")
	MemberService ms;
	
	@RequestMapping("insert")
	public String insert(Model model) {
		//ms = new MemberService();
		int result = ms.insert(); //service에 insert만들기
		System.out.println("ms : " + ms);
		model.addAttribute("result",result);
		return "di/index";
	}

}
