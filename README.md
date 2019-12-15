## Jonathan社区

## 资料
[Spring 文档](https://spring.io/guides)  
[Spring Web](https://spring.io/guides/gs/serving-web-content/)  
[elasticsearch 社区](https://elasticsearch.cn/explore)  
[Github deptloy key](https://help.github.com/cn/github/authenticating-to-github/adding-a-new-ssh-key-to-your-github-account)  
[Github Oauth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[Github Oauth 注册](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)  
[Mybatis-spring-boot](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)  
[Spring-Boot](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)  
[菜鸟教程](https://www.runoob.com/mysql/mysql-tutorial.html)

## 工具
[Git](https://git-scm.com/download)  
[Bootstrap](https://v3.boo\tcss.com/components/)  
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)

##脚本
```sql
CREATE TABLE USER
(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN VARCHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);
```
```bash
mvn flyway:migrate
```

##测试
* 问题标题：请用精简的语言描述您发布的问题，不能超过25字；
* 问题补充：详细补充您的问题内容，并确保问题描述清晰直观，并提供一些相关资料；
* 选择标签：选择一个或者多个合适的标签，用逗号隔开，每个标签不超过10个字；