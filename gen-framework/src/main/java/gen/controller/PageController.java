package gen.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import gen.services.DirectoryDataService;

@Controller
@RequestMapping("/pages")
public class PageController {
	

	

	
	@Autowired
	private DirectoryDataService directoryDataService;
	@RequestMapping("toEquipmentList")
	public String toEquipmentList(ModelMap model){
		ArrayList list=(ArrayList)this.directoryDataService.get("dept");
		ArrayList projectlist=(ArrayList)this.directoryDataService.get("projecttype");
		ArrayList useTypeCodelist=(ArrayList)this.directoryDataService.get("useTypeCode");
		model.addAttribute("deptListTop10", list.subList(0, 10));
		model.addAttribute("deptList",JSONObject.toJSONString(list.subList(10, list.size())));
		model.addAttribute("projecttype",projectlist);
		model.addAttribute("useTypeCode",useTypeCodelist);
		return "pages/equipmentList";
	}
	@RequestMapping("toLogin")
	public String toLogin(ModelMap model,HttpServletRequest request){
		/*String referer=request.getHeader("referer");
		System.out.println(request.getRequestURI());
		if(referer==null && request.getRequestURI().startsWith("/manager/")){
			referer=request.getRequestURI();
		}else if(referer==null || referer.equals(loginurl)){
			referer=weburl;
		}
		model.addAttribute("jumpurl", referer);*/
		return "pages/login";
	}
	@RequestMapping("toShenPi")
	public String toShenPi(String eid){
		return "pages/manager/shenpi";
	}
	@RequestMapping("toEditUser")
	public String toEditUser(String eid){
		return "pages/manager/editUser";
	}
	@RequestMapping("toEquipmentCircs")
	public String toEquipmentCircs(String eid){
		return "pages/equipmentCircs";
	}
}
