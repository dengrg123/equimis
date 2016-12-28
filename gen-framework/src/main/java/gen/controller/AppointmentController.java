package gen.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gen.beans.AppointmentBean;
import gen.services.AppointmentService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping(value="/ajaxSubmit",method=RequestMethod.POST)
	@ResponseBody
	public String ajaxSubmit(AppointmentBean appointmentBean,HttpSession session){
		try {
			Map<String,String> loginInfo=(Map<String,String>)session.getAttribute("loginInfo");
			appointmentBean.setProjectmanager(loginInfo.get("name"));
			appointmentBean.setUserid(loginInfo.get("id"));
			return this.appointmentService.submit(appointmentBean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}
	}
	@RequestMapping(value="/ajaxGetDataByDate",method=RequestMethod.POST)
	@ResponseBody
	public String ajaxGetDataByDate(String equipmentid,@DateTimeFormat(pattern="yyyy-MM-dd")Date date){
		try {
			return this.appointmentService.appoCircs(equipmentid, date);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}
	
		
	}
}
