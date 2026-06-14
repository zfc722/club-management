# 校园社团管理系统 (club-management)

技术栈：Spring Boot + MyBatis + Thymeleaf + MySQL

快速开始：
1. 安装 JDK 17+, Maven, MySQL
2. 在 MySQL 中运行 src/main/resources/schema.sql 创建数据库与测试数据
3. 修改 src/main/resources/application.yml 中的数据库连接（username/password）
4. 在项目根目录运行：
   mvn spring-boot:run
5. 访问：http://localhost:8080/login
   默认用户：admin / admin123

说明：
- 本项目为课程作业脚手架，包含登录、社团信息的增删改查、分页和模糊查询。
- 推荐使用 IntelliJ IDEA 导入该 Maven 项目.
