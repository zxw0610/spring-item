# 建立项目数据库的表

# Module  one  权限模块  [RBAC设计模式去设计表，非常灵活，扩展性也好]
airsys_user
airsys_role 
sirsys_resouece


# Module  two  人资模块  [其实并没有统一的标准，就是根据实际情况设置表]
# ...
# ...
# ...

# Module  three  行政模块  [考勤管理   车辆管理    帮工用品管理]
# ...
# ...
# ...


# 例子模块
create table in not exists account(
	id int primary key auto_increment,
	name varchar(50) not null;
	balance double
)