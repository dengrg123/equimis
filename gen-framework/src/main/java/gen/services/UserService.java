package gen.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import gen.beans.UserBean;
import gen.framework.common.beans.CommonCountBean;
import gen.framework.common.beans.CommonInsertBean;
import gen.framework.common.beans.CommonSearchBean;
import gen.framework.common.beans.CommonUpdateBean;
import gen.framework.common.dao.CommonMapper;

public class UserService {
	@Autowired
	private CommonMapper commonMapper;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String add(UserBean user){
		JSONObject result=new  JSONObject();
		if(user==null){
			result.put("retCode", "-7");
			result.put("retMsg", "请填写用户信息");
			return result.toJSONString();
		}
		if(StringUtils.isBlank(user.getAccount())){
			result.put("retCode", "-10");
			result.put("retMsg", "请填写用户信息");
			return result.toJSONString();
		}
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("account", user.getAccount());
		CommonCountBean csb=new CommonCountBean("em_user",condition);
		long size=this.commonMapper.selectCount(csb);
		if(size>0){
			result.put("retCode", "-11");
			result.put("retMsg", "此账号名已经被用了");
			return result.toJSONString();
		}
		user.setPassword("123456");
		user.setUserid(UUID.randomUUID().toString().replaceAll("-", ""));
		CommonInsertBean cib=new CommonInsertBean("em_user",user);
		this.commonMapper.insertObjects(cib);
		result.put("retCode", "1");
		result.put("retMsg", "添加成功");
		return result.toJSONString();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String update(UserBean user,String currentUserid){
		JSONObject result=new  JSONObject();
		if(user==null){
			result.put("retCode", "-7");
			result.put("retMsg", "请填写用户信息");
			return result.toJSONString();
		}
		if(StringUtils.isBlank(currentUserid)){
			result.put("retCode", "-13");
			result.put("retMsg", "请登录");
			return result.toJSONString();
		}

		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("account", user.getAccount());
		CommonCountBean csb=new CommonCountBean("em_user",condition);
		long size=this.commonMapper.selectCount(csb);
		if(size>0){
			result.put("retCode", "-11");
			result.put("retMsg", "此账号名已经被用了");
			return result.toJSONString();
		}
		condition.remove("account");
		condition.put("userid", currentUserid);
		CommonUpdateBean cub=new CommonUpdateBean("em_user", user, condition);
		this.commonMapper.updateObject(cub);
		result.put("retCode", "2");
		result.put("retMsg", "修改成功");
		return result.toJSONString();

	}
	public String login(String account,String password){
		JSONObject result=new  JSONObject();
		if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
			result.put("retCode", "-14");
			result.put("retMsg", "请输入用户名或者密码");
			return result.toJSONString();
		}
		
		Map<String,Object> condition=new HashMap<String,Object>();
		condition.put("account", account);
		condition.put("password", password);
		CommonSearchBean csb=new CommonSearchBean("em_user", null, "userid", null,null,condition);
		List userIdList=this.commonMapper.selectObjects(csb);
		if(userIdList!=null && !userIdList.isEmpty()){
			result.put("retCode", "1");
			result.put("retMsg", "登录成功");
		}else{
			result.put("retCode", "-15");
			result.put("retMsg", "登录失败");
		}

		return result.toJSONString();
	}
}
