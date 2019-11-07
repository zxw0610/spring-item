package util.pager;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import util.Pager;

@Aspect
@Component
public class PagerAspect {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//-- 1. 自定义切点，指定目标方法的位置
		@Pointcut("execution(* service..*(..))")
		public void selfPointcut() {
			
		}
	
		@SuppressWarnings({ "unchecked", "unused" })
		@Around("selfPointcut()")
		public Object testAround(ProceedingJoinPoint jp) {
			System.out.println("分页：");
			Object o = null;
			
			//--1. 根据jp对象获取Method对象
			MethodSignature signature = (MethodSignature) jp.getSignature();
			Method m = signature.getMethod();
			
			//-- 2. Method对象获取是否含有标注
			MiniPager miniPager = m.getAnnotation(MiniPager.class);
			System.out.println(miniPager.tableName());
			
			//-- 3. 做判断
			if(miniPager == null) {
				try {
					o = jp.proceed();
				} catch (Throwable e) {
						e.printStackTrace();
				}
				return o;
			}
			
			//-- 4. 若有@MiniPager标注，则加入分页代码
			System.out.println("分页成功");
			
			//-- (1).获取某实体类对应的总的条目数
			String tableName = miniPager.tableName();
			int totalItems = jdbcTemplate.queryForObject(
					"select count(*) from "+ tableName,
					Integer.class);
			System.out.println(totalItems);
			
			//-- (2). 根据页大小计算的总的页数
			int pageSize = (Integer)jp.getArgs()[1];
			int pageNo = (Integer)jp.getArgs()[0];
			System.out.println(pageSize);
			int totalPages = (totalItems + pageSize -1)/pageSize;
			if(pageNo>=totalPages)pageNo = totalPages;
			
			//-- (3).返回Pager对象
			Pager pager = new Pager();
			try {
				List data = (List)jp.proceed(new Object[]{pageNo,pageSize});
				pager.setData(data);
				pager.setTotal(totalPages);
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return pager;
		}
		
//		//-- 2. 通知
//		@Before("selfPointcut()")
//		public void testBefore() {
//System.out.println("before do something...");
//		}
//		
//		@After("selfPointcut()")
//		public void testAfter() {
//System.out.println("After do something...");
//		}
}
