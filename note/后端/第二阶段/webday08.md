#一、SpringBoot入门



##1.1、SpringBoot概述

场景启动器  web

jar   war   springboot  打包方式为 jar包

SpringBoot是Spring家族中的一个全新的框架，它用来简化Spring应用程序的创建和开发过程，也可以说SpringBoot

能简化我们之前采用SpringMVC + Spring + MyBatis框架进行开发的过程。

 

在以往我们采用SpringMVC + Spring + MyBatis框架进行开发的时候，搭建和整合三大框架，我们需要做很多工作，比

如配置web.xml，配置Spring，配置MyBatis，并将它们整合在一起等，而SpringBoot框架对此开发过程进行了革命性 

的、颠覆，完全抛弃了繁琐的xml配置过程，采用大量的默认配置简化我们的开发过程。

 

所以采用SpringBoot可以非常容易和快速地创建基于Spring框架的应用程序，它让编码变简单了，配置变简单了，部署

变简单了，监控变简单了。正因为 SpringBoot 它化繁为简，让开发变得极其简单和快速，所以在业界备受关注。





## 1.2、SpringBoot框架优缺点



1、优点

快速构建项目。

对主流开发框架的无配置集成。

项目可独立运行，无须外部依赖Servlet容器。

提供运行时的应用监控。

极大地提高了开发、部署效率。

与云计算的天然集成。

 

2、缺点

版本迭代速度很快，一些模块改动很大。

由于不用自己做配置，报错时很难定位。 //百度一下

网上现成的解决方案比较少。





##1.3、SpringBoot快速创建项目



###1、idea创建Springboot项目

![image-20250409110939023](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250409110939.png)



### 2、添加场景启动器

![image-20250409110914101](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250409110914.png)



### 3、修改pom.xml依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!--    继承springboot父项目-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.9</version>
    </parent>
    <!-- 项目本身GAV坐标   -->
    <groupId>com.wn</groupId>
    <artifactId>webday08boot01</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>webday08boot01</name>
    <!-- 依赖版本控制   -->
    <properties>
        <java.version>17</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <spring-boot.version>3.0.2</spring-boot.version>
    </properties>
    <dependencies>
        <!--   web开发环境的场景启动器     -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--  单元(Junit)测试 场景启动器     -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```



### 4、项目目录如下

 ![image-20250409111111228](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250409111111.png)



### 5、启动项目

![image-20250409111146095](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250409111146.png)





#二、SpringBootAllication注解



SpringBootAllication是一个组合注解，

```
@Configuration  //
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
```



##2.1、@Configuration 注解

@SpringBootConfiguration 该注解也是组合注解，其注解中有一个@Configuration ，声明当前类是一个配置类。

配置类 等价于 之前定义 Spring配置文件  (applicationContext.xml)



案例：自定义配置类

```java
/**
 * 自定义配置类
 */
@Configuration  //该类等价于  applicationContext.xml
public class MyConfiguration {

    /**
     * 创建bean对象 交给Spring容器管理
     */
    @Bean  //等价于  <bean id=“getUser” class="com.wn.webday08boot01.bean.User" />
    public User getUser(){
        User user = new User();
        user.setUid("wn1001");
        user.setUsername("倩倩");
        return user;
    }
}
```





##2.2、@EnableAutoConfiguration注解

@EnableAutoConfiguration的作用启动自动的配置，@EnableAutoConfiguration注解的意思就是Springboot根据你添

加的jar包来配置你项目的默认配置，比如根据spring-boot-starter-web ，来判断你的项目是否需要添加了webmvc

和tomcat，就会自动的帮你配置web项目中所需要的默认配置。在下面博客会具体分析这个注解，快速入门的demo

实际没有用到该注解。



另可以参考博客: https://blog.csdn.net/a1148233614/article/details/100132038





##2.3、@注解ComponentScan



ComponentScan相当于 之前在xml文件中 `<context:component-scan base-package="com.wn"/>`

在指定类上使用该注解，自动扫描该类所在的包及其子包下的所有类中 spring注解

```java
@SpringBootApplication  //启动类注解
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class Webday08boot01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Webday08boot01Application.class, args);
        //获取Spring容器中对象
        User user = (User) context.getBean("getUser");
        System.out.println(user);
    }
}
```



# 三、SpringBoot核心配置文件



springBoot基于Spring框架全新框架，使用Springboot简化配置，讲究 约定优于配置，springBoot框架提供两种配置文件分别是application.properties和application.yml 配置文件，通过这两中配置文件修改默认的配置和环境。

比如: 修改内嵌tomcat 端口号  

​		设置连接数据库参数  url、username、password、driverClass等等





## 3.1、application.properties配置文件



application.properties配置是Springboot提供修改默认配置一种文件，application.properties书写方式通过 key-value设置。

比如: 修改端口号   server.port=8089

```properties
server.port=8088
#设置访问路径
server.servlet.context-path=/webday08boot01
#设置mysql连接参数
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:msyql://location:3306/mydb?serverTimezone=GMT
spring.datasource.username=root
spring.datasource.password=123456
```



## 3.2、application.yml文件

yml全称叫yaml，注意yml不是一个标记文档，该文件也是springboot框架提供修改默认配置文件。



注意:

1、yml赋值方式: K:空格V

2、通过垂直关系指定层次关系，比如:

server:

port: 9090

path: /a/b/c

```yaml
#设置端口号
server:
  port: 8089
  servlet:
    context-path: /webday08
#设置mysql连接参数
spring:
  datasource:
    url: jdbc:msyql://location:3306/mydb?serverTimezone=GMT
    driver-class-name: com.mysql.cj.jdbc.Driver
    #type:   指定数据库连接池
    username: root
    password: 123456

```



在springboot应用中，properties 优先级 大于 yaml文件，所有优先加载properties配置文件，其次才是加载yaml文件。如果properties中没有配置，而在yaml文件中有对应配置，则进行互补。





##3.3、javaBean属性绑定参数



在springboot应用，可以通过yaml或者properties配置文件实现给javaBean绑定属性值。



###1、创建Java类

```java
/**
 * 学生类
 */
@Component //创建对象交由spring容器进行管理
//使用@ConfigurationProperties执行前缀
@ConfigurationProperties(prefix = "stu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer sid;
    private String sname;
    private String telphone;
    private Date birthday;
    /**持有熊猫类型对象引用*/
    private Panda panda;

    /**爱好*/
    private String[] likes;
    /**旅游城市*/
    private List<String> citys;
    /**学生详情信息*/
    private Map<String,Object> details;

}
```

### 2、在配置文件中配置对应属性值

application.yml：

```yaml
#给javaBean绑定参数
stu:
  sid: 1002
  sname: 景甜
  telphone: 13399002233
  birthday: 2024/10/01
  panda: {pid: 23,pname: 小迪,age: 2}  #引用类型属性绑定
  likes: #[游泳,打篮球，打羽毛球]    #敲代码,打游戏，跳舞
    - 打排球
    - 打钢球
  citys: 成都市,y宜宾市,乐山市
  details: {did: 1,desc: 我是大神}
```



###3、测试类

```java
@SpringBootTest
class Webday08boot01ApplicationTests {

    @Autowired
    private Student  student;

    @Test
    void contextLoads() {

        System.out.println(student);
    }

}
```





通过@Value注解给实体对象属性注入值:

```java
/**
 * 学生类
 */
@Component //创建对象交由spring容器进行管理
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Value("${stu.sid}")
    private Integer sid;
    @Value("${stu.sname}")
    private String sname;
    @Value("${stu.telphone}")
    private String telphone;
    @Value("${stu.birthday}")
    private Date birthday;

}
```



注意： 只能针对简单类型可以，复杂类型或自定义引用类型不支持



# 四、SpringBoot整合Mybatis框架



##4.1、整合案例

1、创建数据库表

```sql
CREATE TABLE `dept` (
  `deptno` int NOT NULL,
  `dname` varchar(15) DEFAULT NULL,
  `loc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


```

2、创建springboot项目，并导入相关依赖

```xml
    <!--    继承springboot父项目-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.9</version>
    </parent>
    <!-- 项目本身GAV坐标   -->
    <groupId>com.wn</groupId>
    <artifactId>webday08boot01</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>webday08boot01</name>
    <!-- 依赖版本控制   -->
    <properties>
        <java.version>17</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <spring-boot.version>3.0.2</spring-boot.version>
    </properties>
    <dependencies>
        <!--   web开发环境的场景启动器     -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--  单元(Junit)测试 场景启动器     -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--        添加lombok依赖-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
<!--        mybatis框架依赖-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>3.0.3</version>
        </dependency>
<!--        导入jdbc驱动包-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.12</version>
        </dependency>
    </dependencies>
```



3、配置连接数据库的参数和数据库连接池

```yaml
#设置端口号
server:
  port: 8999
  servlet:
    context-path: /webday08
#设置mysql连接参数
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT
    #type:   指定数据库连接池
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource #数据库连接池(数据源)
```



4、创建实体类

```java
/**
 * 部门类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    private Integer deptno;
    private String dname;
    private String loc;
}
```



5、创建mapper接口

```java
@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门信息
     */
    @Select("select * from dept")
    List<Dept> selectAll();

}
```



6、创建service层接口和实现类

DeptService接口:

```java
public interface DeptService {

    List<Dept> selectAll();
}
```

DeptServiceImpl实现类:

```java
@Service
public class DeptServiceImpl implements DeptService{

    //持有mapper引用
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }
}
```



7、创建controller接口

```java
@Controller
public class DeptController {

    //持有service层对象的引用
    @Resource
    private DeptService deptService;

    /**
     * 查询所有
     */
    public List<Dept> findAll(){
        return deptService.selectAll();
    }
}
```



8、测试

```java
@SpringBootTest
class Webday08boot01ApplicationTests {
    @Autowired
    private DeptController deptController;

    @Test
    void selectAllTest(){
        //查询所有员工信息
        deptController.findAll().forEach(System.out::println);
    }
}
```





##4.2、实现分页查询



springBoot整合mybatis实现分页查询：



实现步骤:

1、导入分页插件

```xml
        <!-- 分页依赖 -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.4.6</version>
        </dependency>
```



2、在application.yml进行配置分页相关内容

```yaml
#设置端口号
server:
  port: 8999
  servlet:
    context-path: /webday08
#设置mysql连接参数
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT
    #type:   指定数据库连接池
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource
#配置分页相关信息
pagehelper:
  helperDialect: mysql
  reasonable: true
  supportMethodsArguments: true
  params: count=countSql
```



3、编辑mapper接口

```java
@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门信息
     */
    @Select("select * from dept")
    List<Dept> selectAll();

}
```



4、编辑service层接口和实现类

DeptService接口:

```java
public interface DeptService {
    /**
     * 查询所有部门信息，进行分页
     * @param pageNum  当前页
     * @param pageSize 每页记录数
     * @return
     */
    List<Dept> selectAll(Integer pageNum, Integer pageSize);
}
```

DeptServiceImpl实现类:

```java
@Service
public class DeptServiceImpl implements DeptService{

    //持有mapper引用
    @Autowired
    private DeptMapper deptMapper;

    /**
     *
     * @param pageNum  当前页
     * @param pageSize 每页记录数
     * @return 当前页面所有数据
     */
    @Override
    public List<Dept> selectAll(Integer pageNum, Integer pageSize) {
        //1.设置当前页和每页记录数
        PageHelper.startPage(pageNum, pageSize);
        //2.调用mapper方法查询所有部门信息
        List<Dept> depts = deptMapper.selectAll();
        //3.创建PageInfo对象
        PageInfo<Dept> info = new PageInfo<>(depts);
        info.getPageNum(); //获取当前页
        Integer size = info.getPageSize();//获取每页记录数
        info.getPages();//总页数
        long total = info.getTotal(); //总记录数
        //total / size == 0 ? total / size : (total / size) + 1
        //分页过后返回的数据
        return info.getList();
    }
}
```



5、编辑controller层类

```java
@Controller
public class DeptController {

    //持有service层对象的引用
    @Resource
    private DeptService deptService;

    /**
     * 查询所有
     */
    public List<Dept> findAll(Integer pageNum, Integer pageSize){
        return deptService.selectAll(pageNum,pageSize);
    }
}
```





6、创建测试类进行测试

```java
@SpringBootTest
class Webday08boot01ApplicationTests {
    @Autowired
    private DeptController deptController;

    @Test
    void selectAllTest(){
        //查询所有员工信息
        deptController.findAll(1,5).forEach(System.out::println);
    }
}
```









