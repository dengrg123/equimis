package gen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/yuyue")
public class YuYueController {
	public YuYueController() {
		// TODO Auto-generated constructor stub
		System.out.println("---------");
	}
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		System.out.println("------------");
		return "test";
	}
}
