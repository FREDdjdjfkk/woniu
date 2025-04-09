回顾:

IOC(控制反转)： 把new对象的行为交给Spring IOC来控制和管理，

DI（依赖注入）： 在遵循ioc前提下，实现对对象属性进行赋值

1、配置文件实现方式

​	`<bean id='' class=''>`

​	`<property name='' value='' ref=''>`

`</bean>`



2、注解开发方式

​	@Component   

​		（@Repository、@Service、@Controller）

​	DI(@Value、@Autowired、@Resource)



# 一、SpringAOP



##1.1、aop介绍



AOP全称Aspect Oriented Pragraming,即面向切面编程(面相方面编程)。AOP是一种编程方式，不是编程语言，我们在开发中主要使用

AOP来解决一些系统层面上的问题，比如权限控制、缓存控制、事务控制、审计日志、性能监控、分布式追踪、异常处理

等，但是它不能解决所有的问题，AOP是OOP(面向对象)的补充，不是代替

 aop如何实现? 通过编程方式和程序在运行时通过动态代理方式给程序中指定拦截方法进行功能性增强(新增功能)。

动态代理特点: 在程序运行时才创建目标对象的代理对象，由代理对象实现指定功能同时可以进行增强



![image-20250408103115816](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250408103115.png)



动态代理实现方式有两种：

1、JDK动态代理  

2、cglib动态代理

在Spring框架中支持以上两种代理方式，如果代理对象有实现一个或者多个接口情况下，使用JDK动态代理。如果增强类，没有实现接口，则底层一定是使用cglib代理模式。



##1.2、AOP相关术语

连接点:  泛指程序中方法

切入点: 泛指被拦截(进行增强)的方法

增强(advice):  拦截到方法之后要执行的内容

切面(aspect): 泛指 切入点和增强的内容的结合。本质就是一个类

目标类：  泛指代理对象

......



**增强方式:**

​	前置增强:  指在执行拦截方法之前进行增强

​	后置增强: 指在执行拦截方法之后进行增强

​	环绕增强：指在执行拦截方法之前后进行增强

​	异常增强:    指在执行拦截方法出现异常进行增强

​	最终增强:   指在执行拦截方法不管是否出现异常都会进行增强



拦截切入点语法:

​	excation(<访问修饰符>?<返回值类型> 方法名(<参数>)<异常类型>)

​	比如: `execution(* com.wn.service.UserService.delById(*))`

​			`execution(* com.wn.service.*.delById(*))`

​			`execution(* com.wn.service.*.*(*))`



##1.3、代码实现



1、导入Spring相关依赖

```xml
  <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <spring.version>5.3.3</spring.version>
  </properties>
  <dependencies>
    <!-- spring相关依赖-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-orm</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.10.0</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.10.0</version>
    </dependency>
    <dependency>
      <groupId>javax.annotation</groupId>
      <artifactId>javax.annotation-api</artifactId>
      <version>1.3.2</version>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.30</version>
    </dependency>
  </dependencies>
```

2、创建目标类(被增强类)

UserService接口:

```java
public interface UserService {
    //删除数据
    void delById(String id);
}
```



UserServiceImpl实现类:

```java
/**
 * 被增强类
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 需要增强的方法
     * @param id
     */
    @Override
    public void delById(String id) {
        System.out.println("id = " + id + ",删除成功!!!");
    }
}
```



3、创建切面(定义切入点、定义增强方法)

```java
/**
 * 增强类
 */
@Aspect //声明当前类为切面
@Component  //创建对象
public class UserServiceAdvice {
    /**
     * 拦截到指定方法之后增强的内容
     */
    @Before("execution(* com.wn.service.impl.UserServiceImpl.delById(*))")
    public void delByIdAdvice(){
        //调用记录日志方法
        System.out.println("记录日志成功!!");
    }
}
```



4、在核心配置文件中开启aop注解开发

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/aop
	http://www.springframework.org/schema/aop/spring-aop.xsd
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd" >

    <!--  1.扫描指定包  -->
    <context:component-scan base-package="com.wn" />
    <!-- 2.开启aop注解开发   -->
    <aop:aspectj-autoproxy />

</beans>
```



5、创建测试类

```java
public class UserServiceTest {
    public static void main(String[] args) {
        //1.加载spring核心配置，创建ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取UserServiceImpl对象
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.delById("33");
    }
}
```



#二、Spring整合Mybatis



## 2.1、整合思路

把Mybatis中所有对象都交由spring 容器进行管理



## 2.2、整合步骤

1、准备数据库表

```sql
CREATE TABLE `t_account` (
  `aid` varchar(32) NOT NULL,
  `aname` varchar(32) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

2、创建并导入相关依赖

```xml
  <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <spring.version>5.3.3</spring.version>
  </properties>
  <dependencies>
    <!-- spring相关依赖-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-orm</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.10.0</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.10.0</version>
    </dependency>
    <dependency>
      <groupId>javax.annotation</groupId>
      <artifactId>javax.annotation-api</artifactId>
      <version>1.3.2</version>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.30</version>
    </dependency>
<!--    导入mybatis依赖-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.9</version>
    </dependency>
<!--    导入jdbc依赖-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.20</version>
    </dependency>
<!--    导入数据库连接池依赖-->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.2.12</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>2.1.2</version>
    </dependency>
  </dependencies>
```

3、创建项目结构

 ![image-20250408144305278](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250408144305.png)

4、创建实体类

```java
/**
 * 账户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String aid;
    private String aname;
    private String pwd;
    private String phone;
}
```



5、创建Mapper接口

```java
public interface AccountMapper {
    /**
     * 查询所有账户信息
     */
    @Select("select  * from t_account")
    List<Account> selectAll();

}
```



6、创建service接口和实现类

AccountService接口:

```java
public interface AccountService {

    List<Account> selectAll();
}
```



AccountService实现类:

```java
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> selectAll() {
        return accountMapper.selectAll();
    }
}
```



7、创建controller层类

```java
/**
 * 账户类控制层实现类
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 查询所有账户信息
     */
    public List<Account> selectAll() {
        return accountService.selectAll();
    }
}
```



8、创建db.properties配置文件

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mydb7?serverTimezone=GMT%2B8
jdbc.user=root
jdbc.pwd=123456
```



9、创建Mybatis核心配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--  设置mybatis日志打印  -->
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
    <mappers>
        <package name="com.wn.mapper"/>
    </mappers>
</configuration>
```



10、创建Spring核心配置文件

​		10.1、加载db.propertoes配置文件

​		10.2、配置数据源(数据库连接池)

​		10.3、配置SqlsessionFactory工厂对象

​		10.4、配置扫描指定mapper包

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/aop
	http://www.springframework.org/schema/aop/spring-aop.xsd
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd" >

    <!--  1.扫描指定包  -->
    <context:component-scan base-package="com.wn" />
    <!-- 2.开启aop注解开发   -->
    <aop:aspectj-autoproxy />

    <!--  整合mybatis框架配置  -->
    <!--  加载db.properties配置文件  -->
    <context:property-placeholder location="classpath:db.properties" />
    <!-- 配置数据源(配置数据库连接池)   -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <!--        配置连接数据库参数-->
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.user}"></property>
        <property name="password" value="${jdbc.pwd}"></property>
    </bean>

    <!-- 配置sqlsessionFactory工厂对象   -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <!--        加载mybatis核心配置文件-->
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
    </bean>

    <!-- 扫描Mapper接口包   -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.wn.mapper"></property>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>

</beans>
```



11、创建测试类

```java
public class AccountControllerTest {
    public static void main(String[] args) {

        //1.加载spring核心配置，创建ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountController accountController = (AccountController) context.getBean("accountController");
        List<Account> list = accountController.selectAll();
        list.forEach(System.out::println); //输出打印

    }
}
```







#三、Spring事务管理



## 3.1、什么是事务?



把多条sql语句看做一组操作，在操作中，内容sql语句要么全部成功，要么全部失败! 不能出现部分成功或者部分失败.



## 3.2、事务四大特征

原子性:  一个事务中所有操作，要么全部成功，要么全部失败。不可在分割

一致性: 事务执行之前和执行之后，参与到事务数据前后要保持一致 （前后总和不变）

隔离性: 指多个事务之间应该隔离开来，相互不受干扰。（提高执行效率设置事务隔离级别）

持久性: 事务一旦执行成功，对数据库的影响是永久性的



## 3.3、Mysql中事务



默认情况下，mysql中一条sql语句就是一个事务(默认提交事务)

如果需要手动管理事务，设置如下几个操作:

-- 开启事务  start TRANSACTION

-- 提交事务   commit

--事务回滚   rollback;

案例:

```sql
#开启事务
start TRANSACTION 

update t_account set money=money - 1000 where aname='大乔'
update t_account set money=money + 1000 where aname='李四'

COMMIT; #提交事务

rollback  #事务回滚
```



##3.4、JDBC事务管理



jdbc中默认情况下，执行一条sql语句就是一个事务。

如果开启事务，必须使用Connection对象实现。 注意： 一个事务中connection对象必须是同一个对象

开启事务方法: `setAutoCommit(boolean autoCommit)` ,该方法参数默认值为true，使用是设置参数为false，即表示开启事务

提交事务:`commit()`   

事务回滚: `rollback()` 



代码实现案例:

```java
//1.获取Connection 对象
try{
	//2.开启事务
	connection.setAutoCommit(false);
    ----执行sql语句---
	
    //3.提交事务
    connection.commit();
}catch(Exception e){
	//事务回滚
    connection.rollback();
    
}finally{
    //关闭资源
    connection.close();
}

```



##3.5、Spring管理事务



案例： 转账业务逻辑演示



1、在AccountMapper新增修改方法

```java
    /**
     * 根据用户名修改账户余额
     */
    @Update("update t_account set money=money + #{money} where aname=#{aname}")
    void updateByName(@Param("aname") String aname,@Param("money") double money);

```



2、编辑service层接口和实现类



AccountService接口:

```java
    /**
     * 用户转账业务方法
     */
    void transferAccounts(String fromName, String toName, double money);
```

AccountServiceImpl实现类

```java
    /**
     * 用户转账业务方法
     */
    @Transactional //对该方法进行事务管理
    @Override
    public void transferAccounts(String fromName, String toName, double money) {
        //具体用户转账操作
        accountMapper.updateByName(fromName, -money);
        String str = null;
        str.trim();
        accountMapper.updateByName(toName, money);
    }
```



3、编辑AccountController类

```java
    /**
     * 用户转账方法
     */
    public void transferAccounts(String from, String to,double money) {
        accountService.transferAccounts(from, to, money);
    }
```



4、在Spring核心配置文件中配置事务管理器和开启事务注解开发

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/aop
	http://www.springframework.org/schema/aop/spring-aop.xsd
	http://www.springframework.org/schema/tx
	http://www.springframework.org/schema/tx/spring-tx.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd" >

    <!--  1.扫描指定包  -->
    <context:component-scan base-package="com.wn" />
    <!-- 2.开启aop注解开发   -->
    <aop:aspectj-autoproxy />

    <!--  整合mybatis框架配置  -->
    <!--  加载db.properties配置文件  -->
    <context:property-placeholder location="classpath:db.properties" />
    <!-- 配置数据源(配置数据库连接池)   -->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <!--        配置连接数据库参数-->
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="url" value="${jdbc.url}"></property>
        <property name="username" value="${jdbc.user}"></property>
        <property name="password" value="${jdbc.pwd}"></property>
    </bean>

    <!-- 配置sqlsessionFactory工厂对象   -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <!--        加载mybatis核心配置文件-->
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
    </bean>

    <!-- 扫描Mapper接口包   -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.wn.mapper"></property>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>

    <!--    配置spring事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <!--    开启事务注解开发-->
    <tx:annotation-driven transaction-manager="transactionManager" />
</beans>
```



5、进行测试

```java
public class AccountControllerTest {
    public static void main(String[] args) {

        //1.加载spring核心配置，创建ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountController accountController = (AccountController) context.getBean("accountController");
        /**
         * 实现用户之间转账操作
         */
        accountController.transferAccounts("大乔", "李四", 1000);
    }
}
```









