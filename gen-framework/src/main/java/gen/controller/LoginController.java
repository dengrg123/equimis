package gen.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import gen.services.UserService;

@Controller

public class LoginController {
	
		@Autowired
		private UserService userService;
	
		@RequestMapping("/login")
		@ResponseBody
		public String login(String account,String password,String jumpurl,HttpSession session){
			try {
				Map callbackMap=new HashMap();
				String callback=userService.login(account, password,jumpurl,callbackMap);
				if(callback.indexOf("登录成功")>-1){
					
					session.setAttribute("loginInfo", callbackMap);
				}
				return callback;
			} catch (Exception e) {
				e.printStackTrace();
				return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
			}
			
		}
}
