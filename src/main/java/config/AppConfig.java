package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/*
 * 应用配置（Spring配置）
 * 相当于xml的替代者
 * @author Administrator
 *
 */
@Configuration
@ComponentScan({"dao","service","controller"})
@Import(DBConfig.class)
@EnableAspectJAutoProxy
//@EnableWebMvc   切记注释这个标准，如果使用WebApplicationObjectSupport类   继承这个类，就不用@EnableWebMvc标注了，
public class AppConfig extends WebMvcConfigurationSupport{
	/*
	 * jsp的解析器
	 *  这个Bean的作用就是告诉Spring MVC你写的jsp文件的位置
	 * @return
	 */
	@Bean
	public UrlBasedViewResolver  setupViewResolver(){
		UrlBasedViewResolver resolver  = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");    //位置（受保护的，不可以直接访问）
		resolver.setSuffix(".jsp");    //jsp文件的后缀，你在写页面的时候就省略掉后缀
		resolver.setViewClass(JstlView.class);
		return resolver;	
	}
	
	
	/*
	 * 配置处理静态资源 
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		super.addResourceHandlers(registry);
	}
}
