package util.mypager;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import util.Pager;

@Aspect
@Component
public class MyPager  {
	@Autowired
	private JdbcTemplate jt;
	
	@Pointcut("execution(* service..*(..))")
	public void aspect() {}
	
	@Around("aspect()")
	public Object around(ProceedingJoinPoint pjp) {
		Object obj = null;
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		SelfPager annotation = method.getAnnotation(SelfPager.class);
		
		if (annotation == null) {
			try {
				obj = pjp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return obj;
		}
		
System.out.println("分页：");
		String tableName = annotation.tableName();
		int totals  = jt.queryForObject("select count(*) from "+tableName,Integer.class );
		
		int pageNo = (int) pjp.getArgs()[0];
		int pageSize = (int) pjp.getArgs()[1];
		Pager pager = new Pager();
		
		List list = null;
		try {
			list = (List) pjp.proceed(new Object[] {pageNo,pageSize});
		} catch (Throwable e) {e.printStackTrace();}

		pager.setTotal(totals);
		pager.setData(list);
		return pager;
	}
	
	
}
