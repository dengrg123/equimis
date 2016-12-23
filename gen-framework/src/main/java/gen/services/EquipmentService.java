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
		Map<String,Object> condition=null;

		if(StringUtils.isNotBlank(deptid)){
			condition=new HashMap<String,Object>(); 
			condition.put("DEPARTMENTID", deptid);
		}

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
		

		CommonSearchBean commonSearchBean=new CommonSearchBean("em_equipment","LASTUPDATE DESC","t1.NAME ename,t1.MODEL emodel,t1.id eid",page.getStartRow(),page.getEndRow(),condition,
				new CommonChildBean("em_assettype", "code", "ASSETTYPECODE", condition_assettype),
				new CommonChildBean("em_subject", "code", "SUBJECTCODE", condition_subject),
				new CommonChildBean("em_equipmentphoto", "EQUIPMENTID", "ID", null));

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
