package gen.framework.common;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import gen.framework.common.datasources.DatabaseContextHolder;

/**
 * 
 * @author gen
 *
 */
@Aspect
@Component
public class AspectCommon {
		@Pointcut("execution(* com.tuandai.services.*.*(..))")  
		public void pointCut(){}; 
		@Before(value = "pointCut()")
		 public void before(JoinPoint point){
			Object obj=point.getTarget();
			Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
				try {
					Method m = obj.getClass().getMethod(point.getSignature().getName(), parameterTypes);
					if (m != null && m.isAnnotationPresent(DataSource.class)) {
						DataSource data = m.getAnnotation(DataSource.class);
						DatabaseContextHolder.setDatabaseType(data.value());
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		}
}
