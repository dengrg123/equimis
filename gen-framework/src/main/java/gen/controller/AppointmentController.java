package gen.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gen.beans.AppointmentBean;
import gen.services.AppointmentService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);
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
			logger.error("AppointmentController.ajaxSubmit", e);
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
			logger.error("AppointmentController.ajaxGetDataByDate", e);
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}

	}
	@RequestMapping("toAppoList")
	public String toAppointmentList(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			ModelMap model,
			HttpSession session){
		
		try {
			Map<String,String> loginInfo=(Map<String,String>)session.getAttribute("loginInfo");
			model.addAttribute("appoPage", this.appointmentService.list(loginInfo.get("id"), pageNum, pageSize));
		} catch (Exception e) {
			logger.error("AppointmentController.toAppointmentList", e);
			e.printStackTrace();
		}
		return "pages/appointmentList";
	}

	@RequestMapping("ajaxAssess")
	@ResponseBody
	public String ajaxAssess(
			String assess,
			String aid,
			HttpSession session){
		
		try {
			Map<String,String> loginInfo=(Map<String,String>)session.getAttribute("loginInfo");
			return this.appointmentService.assess(assess, aid);
		} catch (Exception e) {
			logger.error("AppointmentController.toAppointmentList", e);
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}
	
	}
}
