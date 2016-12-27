package gen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gen.beans.AppointmentBean;
import gen.beans.UserBean;
import gen.services.AppointmentService;
import gen.services.UserService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("appointmentList")
	public String toCommon(
			String userid,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			ModelMap model){
		try {
			model.addAttribute("appoPage", appointmentService.list(userid, pageNum, pageSize));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return "pages/manager/commonpage";
	}
	@RequestMapping("userList")
	public String userList(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			ModelMap model){
		try {
			model.addAttribute("userPage", this.userService.list(pageNum, pageSize));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "pages/manager/commonpage";
	}
	@RequestMapping("doShenpi")
	@ResponseBody
	public String doShenpi(String id,String auditmessage,Integer status){
		try {

			return this.appointmentService.shenpi( id, auditmessage, status);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}
	}
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(UserBean user){
		try {
			
			return this.userService.add(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}
	}
}
