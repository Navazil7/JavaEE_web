# 项目总体情况
### 系统结构  
> 三层结构：  
> View层-JSP  
> Spring-项目的整合核心，管理所有 Bean 的生命周期行为  
> SpringMVC的Controller作为整个应用的控制器  
> Dao层-MyBatis，MySQL作为数据库  
### 项目开发框架  
> Spring+SpringMvc+Mybatis  
> Maven管理jar包  
> IDE：IDEA  
> JDBC连接池：com.alibaba.druid  

# 应用基本功能
### 用户
> 注册：邮箱格式，邮箱验证码验证  
> 登录  
> 首页信息展示：
> 景点、酒店、论坛（留言和回复）  
> 下单订购（查看订单）  
> 定制功能（一键定制）：用户喜好景点、离景点最近酒店、定制方案  
> 首页景点智能推荐

### 管理员
> 用户、酒店、景点、论坛帖子、留言和回复、交通出行的站点及票据的增删改查
