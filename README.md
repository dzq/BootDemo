# BootDemo
 SpringBoot Demo是一个集成了SpringBoot+MyBatis的Demo工程，以书籍数据管理为例提供了书籍的增删改查的Restfull格式的API接口。
 
## 介绍

#### 开发环境
IDEA
MySQL 8.0.19
Tomcat 9
Maven 3.6
#### 目录结构
```shell

├── BootDemo.iml                                                  # 
├── LICENSE                                                       # 
├── README.md                                                     # 
├── pom.xml                                                       # 
└── src                                                           # 
    └── main                                                      # 
        ├── java                                                  # 
        │   └── com                                               # 
        │       └── dzq                                           # 
        │           └── bootdemo                                  # 
        │               ├── Application.java                      # 程序入口
        │               ├── SwaggerConfig.java                    # Swagger配置
        │               ├── controller                            # 
        │               │   └── BookAPIController.java            # 书籍增删改查API
        │               ├── dao                                   # 
        │               │   ├── BookMapper.java                   # 书籍Mapper接口
        │               │   └── BookMapper.xml                    # 书籍Mapper的MyBatis文件
        │               ├── pojo                                  # 
        │               │   └── Books.java                        # 书籍数据模型
        │               ├── service                               # 
        │               │   ├── BookService.java                  # 书籍Service接口
        │               │   └── BookServiceImpl.java              # 书籍Service实现
        │               └── vo                                    # 
        │                   ├── BookListResponse.java             # 书籍列表返回对象
        │                   ├── BookResponse.java                 # 书籍返回对象
        │                   └── ResponseBody.java                 # 返回对象
        └── resources                                             # 
            └── application.yaml                                  # SpringBoot配置文件

```
####  数据库
```shell
CREATE DATABASE `ssmbuild`;
 
 USE `ssmbuild`;
 
 DROP TABLE IF EXISTS `books`;
 
 CREATE TABLE `books` (
   `bookID` INT(10) NOT NULL AUTO_INCREMENT COMMENT '书id',
   `bookName` VARCHAR(100) NOT NULL COMMENT '书名',
   `bookCounts` INT(11) NOT NULL COMMENT '数量',
   `detail` VARCHAR(200) NOT NULL COMMENT '描述',
   KEY `bookID` (`bookID`)
 ) ENGINE=INNODB DEFAULT CHARSET=utf8
 
 INSERT  INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`)VALUES 
 (1,'Java',1,'从入门到放弃'),
 (2,'MySQL',10,'从删库到跑路'),
 (3,'Linux',5,'从进门到进牢');
```

#### Maven项目
1,pom依赖
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
        <!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
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
    password: 123456
mybatis:
  mapper-locations: classpath:com/dzq/bootdemo/dao/*.xml
  type-aliases-package: com.dzq.bootdemo.pojo
  ```


#### 提供的接口
 ```shell
/**
     * 书籍列表
     * @return
     */
    @GetMapping(value = "/book/list")
    @ApiOperation(value = "查询所有书籍", notes = "查询所有书籍", code = 200, produces = "application/json")
    public BookListResponse list() {
        BookListResponse body = new BookListResponse();
        List<Books> list =  bookService.queryAllBook();
        body.setData(list);
        return body;
    }

    /**
     * 查询指定id的数据
     * @param id
     * @return
     */
    @GetMapping(value = "/book/{id}")
    @ApiOperation(value = "查询指定ID的书籍", notes = "书籍ID", code = 200, produces = "application/json")
    public BookResponse queryBookById(@PathVariable("id") int id) {
        BookResponse body = new BookResponse();
        body.setData(bookService.queryBookById(id));
        return body;
    }

    /**
     * 添加书籍
     * @param books 书籍数据
     * @return
     */
    @PostMapping(value = "/book")
    @ApiOperation(value = "添加书籍", notes = "添加书籍", code = 200, produces = "application/json")
    public BookResponse addBook(Books books) {
        BookResponse body = new BookResponse();
        body.setData(bookService.addBook(books));
        return body;
    }
    /**
     * 删除书籍
     * @param id 书籍id
     * @return
     */
    @DeleteMapping(value = "/book/{id}")
    @ApiOperation(value = "删除书籍", notes = "删除指定ID的书籍", code = 200, produces = "application/json")
    public BookResponse deleteBook(@PathVariable("id") int id) {
        BookResponse body = new BookResponse();
        body.setData(bookService.deleteBookById(id));
        return body;
    }
    /**
     * 更新书籍
     * @param books 书籍数据
     * @return
     */
    @PutMapping(value = "/book")
    @ApiOperation(value = "更新书籍", notes = "更新书籍信息", code = 200, produces = "application/json")
    public BookResponse updateBook(Books books) {
        BookResponse body = new BookResponse();
        body.setData(bookService.updateBook(books));
        return body;
    }
```