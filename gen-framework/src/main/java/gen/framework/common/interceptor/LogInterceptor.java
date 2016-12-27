package gen.framework.common.interceptor;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;

/**
 * 记录请求相关日志
 * @author cancheung
 *
 */
@Component
public class LogInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(LogInterceptor.class);
	private ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	@Value("${gen.framework.login.intercept.urls}")
	private String interUrl;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path=request.getRequestURI();
		if(path.startsWith("/manager/")){
			HttpSession session=request.getSession();
			Map<String,String> loginInfo=(Map<String,String>)session.getAttribute("loginInfo");
			if(loginInfo==null){
				request.getRequestDispatcher("/pages/toLogin").forward(request, response);
				return false;
			}else if(loginInfo.containsKey("ACCOUNT") && loginInfo.get("ACCOUNT").equals("sysadmin")){
				return true;
			}else{
				request.getRequestDispatcher("/pages/toLogin").forward(request, response);
				return false;
			}
		}
		if(interUrl!=null){
			
			List<String> urlList=Arrays.asList(interUrl.replaceAll(" ","").split(","));
			if(urlList.contains(path)){
				HttpSession session=request.getSession();
				if(session.getAttribute("loginInfo")==null){
					JSONObject jsonObject=new  JSONObject();
					jsonObject.put("retCode", 10000);
					jsonObject.put("jumpurl", "/pages/toLogin");
					
					PrintWriter out=response.getWriter();
					out.print(jsonObject.toJSONString());
					out.close();
					out.flush();
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("------rr++");
	}

}