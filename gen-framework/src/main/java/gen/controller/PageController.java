package gen.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
		model.addAttribute("deptListTop10", list.subList(0, 10));
		model.addAttribute("deptList",JSONObject.toJSONString(list.subList(10, list.size())));
		return "pages/equipmentList";
	}
}
