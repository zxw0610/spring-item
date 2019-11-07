Day05 Spring
1. airsys
		jsp + servlet + jdbc + javabean

2.JSP（视图） + Servlet(控制) + Spring（后台）
								 搭建 web 项目
									IOC AOP Test JDBCTemplate
									
3. airsys2
	(1) 新建maven project
	(2) 配置pom.xml文件
		a. 项目的基本信息：名字、ID
		b. 项目中所依赖jar :servlet jsp db test  spring
	    c. 项目中用到的插件
		   编译插件（clean install）、Tomcat（tomcat7:run）
		
	(3)更新项目：重新编译并引入必要的jar
		Maven -》Update Project
		
	(4) 建立J2EE分层架构的包
			entity dao service  servlet  util
	
	(5) 加入Spring的配置
		XML / 配置类： 写一个Spring的配置类
		AppConfig: 总的配置
		DBConfig： 数据库的配置
	
	(6) 建立数据库:
			src/main/resources:   db.sql
			
	(7) 建立实体类 --> 包 entity
			account表 --- Account类
			
	(8) 编写Dao层代码
			dao
				prototype: IAccountDao
				impl: AccountDaoSpringImpl  @Repository
			
	(9) Dao 单元测试
				不是JUnit ，而是SpringTest	
			
	(10) 建立Service 层代码
			service:
				prototype: IAccountService
				impl: AccountServiceDaoImpl
				
	(11)