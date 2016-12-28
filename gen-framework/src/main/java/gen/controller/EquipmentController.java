package gen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gen.services.EquipmentService;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	
	@Autowired
	private EquipmentService equipmentService;
	
	public EquipmentController() {
		// TODO Auto-generated constructor stub
		System.out.println("---------");
	}
	@RequestMapping(value="/ajaxList")
	@ResponseBody
	public String list(String typeName,
			String subjectName,
			String deptid,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
		try {
			return this.equipmentService.equipmentList(typeName, subjectName, deptid, pageNum, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}

	}
	@RequestMapping(value="/ajaxInfo")
	@ResponseBody
	public String info(String id){
		try {
			return this.equipmentService.equipmentInfo(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "{\"retCode\":-1,\"retMsg\":\"系统出现异常\"}";
		}
	}
}
