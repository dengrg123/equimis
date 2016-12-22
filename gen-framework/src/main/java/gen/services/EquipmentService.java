package gen.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import gen.framework.common.beans.CommonChildBean;
import gen.framework.common.beans.CommonCountBean;
import gen.framework.common.beans.CommonSearchBean;
import gen.framework.common.dao.CommonMapper;
import gen.framework.common.util.Page;

@Service
public class EquipmentService {
	
	@Autowired
	private CommonMapper commonMapper;
	
	public String equipmentList(String typeName,String subjectName,String deptid,Integer pageNum,Integer pageSize) throws Exception{
		Page page=new Page(pageNum, pageSize);
		Map<String,Object> condition=new HashMap<String,Object>(); 
		condition.put("startNum", page.getStartRow());
		condition.put("endNum", page.getEndRow());
		if(StringUtils.isNotBlank(deptid)){
			condition.put("DEPARTMENTID", deptid);
		}
		CommonSearchBean commonSearchBean=new CommonSearchBean("em_equipment","LASTUPDATE DESC","NAME ename,MODEL emodel,id eid",condition);
		List<Object> childs=new ArrayList<Object>();
		Map<String,Object> condition_assettype=null;
		if(StringUtils.isNotBlank(typeName)){
			condition_assettype=new HashMap<String,Object>();
			
			condition_assettype.put("NAME,like", typeName.replaceAll("%", "")+"%");
		}
		Map<String,Object> condition_subject=null;
		if(StringUtils.isNotBlank(subjectName)){
			condition_subject=new HashMap<String,Object>();
			
			condition_subject.put("NAME,like", subjectName.replaceAll("%", "")+"%");
		}
		
		childs.add(new CommonChildBean("em_assettype", "code", "ASSETTYPECODE", condition_assettype));
		childs.add(new CommonChildBean("em_subject", "code", "SUBJECTCODE", condition_subject));
		childs.add(new CommonChildBean("em_equipmentphoto", "EQUIPMENTID", "ID", null));
		CommonCountBean ccb = new CommonCountBean();

		PropertyUtils.copyProperties(ccb, commonSearchBean);
		long count = commonMapper.selectCount(ccb);
		if(count>0){
			List list=this.commonMapper.selectObjects(commonSearchBean);
			page.setResult(list);
			page.setTotal(count);
		}
		
		
		return JSONObject.toJSONString(page);
	}
}
