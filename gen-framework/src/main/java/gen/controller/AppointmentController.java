package gen.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/toSubmit",method=RequestMethod.POST)
	@ResponseBody
	public String toSubmit(AppointmentBean appointmentBean){
		try {
			return this.appointmentService.submit(appointmentBean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}
	}
}
