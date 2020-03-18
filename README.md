# BootDemo
SpringBoot Demo是一个集成了SpringBoot+MyBatis的Demo工程，以书籍数据管理为例提供了书籍的增删改查的Restfull格式的API接口。

### 开发环境
IDEA 2019.3
MySQL 8.0.19
Tomcat 9
Maven 3.6
### 目录结构
```shell
├── src                                                           # 
│   └── main                                                      # 
│       ├── java                                                  # 
│       │   └── com                                               # 
│       │       └── dzq                                           # 
│       │           └── bootdemo                                  # 
│       │               ├── Application.java                      # 程序入口
│       │               ├── SwaggerConfig.java                    # Swagger配置
│       │               ├── controller                            # 
│       │               │   └── BookAPIController.java            # 书籍增删改查API
│       │               ├── dao                                   # 
│       │               │   ├── BookMapper.java                   # 书籍Mapper接口
│       │               ├── pojo                                  # 
│       │               │   └── Books.java                        # 书籍数据模型
│       │               ├── service                               # 
│       │               │   ├── BookService.java                  # 书籍Service接口
│       │               │   └── BookServiceImpl.java              # 书籍Service实现
│       │               └── vo                                    # 
│       │                   └── ResponseBody.java                 # 返回对象
│       └── resources                                             # 
│           └── application.yaml                                  # SpringBoot配置文件
├── BootDemo.iml                                                  # 
├── LICENSE                                                       # 
├── README.md                                                     # 
├── pom.xml                                                       # 
```
###  数据库
```shell
CREATE DATABASE `ssmbuild`;

USE `ssmbuild`;
create table books
(
	id int auto_increment comment '书id'
		primary key,
	name varchar(100) not null comment '书名',
	num int not null comment '数量',
	detail varchar(200) not null comment '描述'
)
charset=utf8;


INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (1, 'Java', 1, '从入门到放弃');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (2, 'MySQL', 10, '从删库到跑路');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (3, 'Linux', 5, '从进门到进牢');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (4, '安慰我', 100, '大声道撒');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (5, 'MySQL', 10, '从删库到跑路');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (6, 'Linux', 5, '从进门到进牢');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (7, 'Java', 1, '从入门到放弃');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (8, 'MySQL', 10, '从删库到跑路');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (9, 'Linux', 5, '从进门到进牢');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (10, '阿斯顿撒', 1, '实时');
```

### Maven项目
#### pom依赖

```shell
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.5.RELEASE</version>
    </parent>
    <dependencies>
        <!--  Spring Boot      -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>
        <!-- 数据库连接池 -->
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.5.2</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/tk.mybatis/mapper-spring-boot-starter -->
                <dependency>
                    <groupId>tk.mybatis</groupId>
                    <artifactId>mapper-spring-boot-starter</artifactId>
                    <version>2.0.3</version>
                </dependency>

        <!-- JSON-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.5</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.9.5</version>
        </dependency>
        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
        </dependency>
        <!--      Swagger-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
    </dependencies>
```
 #### Maven资源过滤设置
 ```shell
<resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
 ```
#### Spring Boot 配置文件
 ```shell
logging:
  level:
    root: info
    com.dzq.bootdemo: debug
spring:
  datasource:
    type: com.mysql.cj.jdbc.MysqlConnectionPoolDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ssmbuild?useSSL=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: 12345678
mybatis:
  mapper-locations: classpath:com/dzq/bootdemo/dao/*.xml
  type-aliases-package: com.dzq.bootdemo.pojo
 ```


#### 提供的接口
 ```shell
POST /book 添加书籍
PUT /book 更新书籍
GET /book/{id} 查询指定ID的书籍
DELETE /book/{id} 删除书籍
GET /book/list 查询所有书籍
GET /book/search/{name} 查询包含指定名称书籍
 ```