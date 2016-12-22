package gen.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import gen.beans.AppointmentBean;
import gen.framework.common.beans.CommonCountBean;
import gen.framework.common.beans.CommonInsertBean;
import gen.framework.common.beans.CommonSearchBean;
import gen.framework.common.beans.CommonUpdateBean;
import gen.framework.common.dao.CommonMapper;
import gen.framework.common.util.Page;

@Service
public class AppointmentService {
	
	@Autowired
	private CommonMapper commonMapper;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String submit(AppointmentBean appointmentBean){
		JSONObject result=new  JSONObject();
		if(appointmentBean==null){
			result.put("retCode", "-7");
			result.put("retMsg", "请填写预约信息");
			return result.toJSONString();
		}
		if(StringUtils.isBlank(appointmentBean.getProjectname())){
			result.put("retCode", "-1");
			result.put("retMsg", "项目名为空");
			return result.toJSONString();
		}
		if(StringUtils.isBlank(appointmentBean.getProjecttypecode())){
			result.put("retCode", "-2");
			result.put("retMsg", "项目类型为空");
			return result.toJSONString();
		}
		if(appointmentBean.getBegintime()==null){
			result.put("retCode", "-3");
			result.put("retMsg", "开始时间为空");
			return result.toJSONString();
		}
		if(appointmentBean.getEndtime()==null){
			result.put("retCode", "-4");
			result.put("retMsg", "结束时间为空");
			return result.toJSONString();
		}
		if(StringUtils.isBlank(appointmentBean.getSamplename())){
			result.put("retCode", "-5");
			result.put("retMsg", "样品名称为空");
			return result.toJSONString();
		}
		if(appointmentBean.getSamples()==null || appointmentBean.getSamples()<=0){
			result.put("retCode", "-6");
			result.put("retMsg", "样品数量不能为空或者小于1");
			return result.toJSONString();
		}
		appointmentBean.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		appointmentBean.setStatus(0);
		CommonInsertBean cib=new CommonInsertBean("em_appointment", appointmentBean);
		
		this.commonMapper.insertObjects(cib);
		result.put("retCode", "1");
		result.put("retMsg", "添加成功");
		return result.toJSONString();
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public String update(AppointmentBean appointmentBean){
		JSONObject result=new  JSONObject();
		if(appointmentBean==null){
			result.put("retCode", "-7");
			result.put("retMsg", "请填写修改的资料");
			return result.toJSONString();
		}
		if(StringUtils.isBlank(appointmentBean.getId())){
			result.put("retCode", "-8");
			result.put("retMsg", "流水号为空");
			return result.toJSONString();
		}
		Map<String,Object> params=new HashMap<String,Object>();
		if(appointmentBean.getBegintime()!=null && appointmentBean.getEndtime()!=null){
			params.put("begintime", appointmentBean.getBegintime());
			params.put("endtime", appointmentBean.getEndtime());
			result.put("retMsg", "修改成功");
		}else if(appointmentBean.getStatus()!=null && appointmentBean.getStatus()==-1){
			params.put("status", appointmentBean.getStatus());
			result.put("retMsg", "取消成功");
		}
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("id", appointmentBean.getId());
		CommonUpdateBean cub=new CommonUpdateBean("em_appointment", params, condition);
		this.commonMapper.updateObject(cub);
		result.put("retCode", "1");
		
		return result.toJSONString();
		
	}
	public String list(String userid,Integer pageNum,Integer pageSize)throws Exception{
		JSONObject result=new  JSONObject();
		Page page=new Page(pageNum, pageSize);
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("startNum", page.getStartRow());
		condition.put("endNum", page.getEndRow());
		if(StringUtils.isNotBlank(userid)){
			
			condition.put("userid", userid);
		}
		CommonSearchBean csb=new CommonSearchBean("em_appointment",null,null,condition);
		CommonCountBean ccb = new CommonCountBean();

		PropertyUtils.copyProperties(ccb, csb);
		long count = commonMapper.selectCount(ccb);
		if(count>0){
			List list=this.commonMapper.selectObjects(csb);
			page.setResult(list);
			page.setTotal(count);
		}
		result.put("retCode", "1");
		result.put("retMsg", "success");
		result.put("data", page);
		return result.toJSONString();
	}
	public static void main(String[] args) {
		System.out.println();
	}
}
