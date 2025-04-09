#一、什么是框架？

 

框架是一个半成品项目,已经对基础的代码进行封装并提供相应的API,开发者在使用框架时直接调用封装好的API可以减

少编写代码, 从而提高工作效率和开发速度。

 

#二、框架的分类

 

框架大致分为两类:重量级(开发大型企业应用)、轻量级(开发中小型企业应用)框架

 

***\*2.1、如何区分重量级和轻量级框架？\****

 

***\*主要衡量的指标是以消耗的资源来决定的。\****

重量级框架在启动时需要消耗大量的资源、内存、CPU等,比如EJB

轻量级框架相对于而言消耗的资源较小，比如spring

 

***\*其次的区别是框架的侵入性程度。\****

重量级框架需要继承和实现框架中的类或者接口，以方便使用框架中间件的特性，

这就意味着，需要实例化大量的类并且注册到应用中。

轻量级框架则不一定需要继承或者实现框架中的类来注册和实例化组件

 

***\*开发的方便程度\****

重量级框架开发时则要编写一些框架绑定的类，部署、运行及测试过程都较为复杂，开发起来并不方便。

轻量级框架在开发中应用相对考虑的因素较少，开发简单

 

***\*解决的侧重点不同\****

重量级框架强调可伸缩性(扩展性)，适合于开发大型企业应用

轻量级框架侧重于减小开发的复杂度，相应它的处理能力较弱，适用于开发中小型企业应用



#三、Spring框架



![image-20250407141622005](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250407141622.png)

##3.1、什么是Spring?

Spring是于2003年兴起的一个轻量级、开源的Java开发框架，由Rod Johnson创建。Spring的出生为了简化企业级开发，使

用Spring开发可以将Bean对象，Dao组件对象，Service组件对象等交给Spring容器来管理，这样使得很多复杂的代码在Spring

中开发却变得非常的优雅和简洁，有效的降低代码的耦合度，极大的方便项目的后期维护、升级和扩展。

简单来说，Spring是一个分层的JavaSE/EEfull-stack(一站式)轻量级开源框架





#四、SpringIOC



##4.1、IOC介绍？

IOC是指在程序开发中，实例(对象)的创建不再由调用者管理，而是由 Spring 容器创建。Spring 容器会负责控制程序之间的关系，而不是

由程序代码直接控制，因此，控制权由程序代码转移到了 Spring 容器中，控制权发生了反转，这就是 Spring 的 IoC 思想。



## 4.2、IOC实现方式



###1、通过配置文件实现



实现步骤:

1、导入Spring框架依赖

pom.xml

```xml
 <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <spring.version>5.2.20.RELEASE</spring.version>
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



2、创建类

User类:

```java
/**
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String uid;
    private String uname;
    private Integer age;
}
```



3、创建Spring核心配置文件

applicationContext.xml文件

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

    <!--  通过配置文件实现创建指定类对象  -->
    <bean id="user" class="com.wn.pojo.User"></bean>

    <!--  通过静态工厂类创建对象 ，把对象交给Spring容器管理 -->
    <bean id="factoryBean" class="com.wn.util.BeanFactory" factory-method="getBean"></bean>

</beans>
```



4、创建测试类进行测试

```java
public class UserBeanTest {

    public static void main(String[] args) {
        //1.加载spring核心配置文件，创建ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从Spring容器中获取指定对象
        User user = (User) context.getBean("factoryBean");
        System.out.println(user);

    }
}
```



通过静态工厂类实现：

BeanFactory类:

```java
public class BeanFactory {

    public static User getBean(){
        return new User();
    }
}
```



##4.3、DI(依赖注入)



DI，即依赖注入，以前对象通过手动创建并设置对象中属性值，现在通过spring容器管理依赖关系，在程序运行期间，通过spring容器自动租入组件之间依赖关系。



DI实现方式:

### 1、set注入



1、定义实体类

注意：所有属性必须定义 set 方法

```java
/**
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    普通字段注入
    private String uid;
    private String uname;
    private Integer age;
}
```



2、xml配置文件

```xml
    <!--  通过配置文件实现创建指定类对象  -->
    <bean id="user" class="com.wn.pojo.User">
        <!--    通过set注入，实现给属性注入值    -->
        <property name="uid" value="1001"></property>
        <property name="uname" value="小张"></property>
        <property name="age" value="24"></property>
    </bean>
```



引用类型的字段注入:

1、实体类



User.java类:

```java
/**
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    引用类型属性注入
    private Panda panda;
}
```

Panda.java类:

```java
/**
 * 熊猫类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Panda {

    private String pid;
    private String pname;
    private Integer age;
}
```



2、核心配置文件

```xml
    <!--    创建PAnda类型对象-->
    <bean id="panda" class="com.wn.pojo.Panda">
        <property name="pid" value="20000"></property>
        <property name="pname" value="花花"></property>
        <property name="age" value="22"></property>
    </bean>

    <!--  通过配置文件实现创建指定类对象  -->
    <bean id="user" class="com.wn.pojo.User">
        <!--    通过set注入，实现给属性注入值    -->
        <property name="uid" value="1001"></property>
        <property name="uname" value="小张"></property>
        <property name="age" value="24"></property>
        <property name="panda" ref="panda"></property>
    </bean>
```



集合类型属性注入:

1、Student类:

```java
/**
 * 学生类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    /**爱好*/
    private String[] likes;
    /**旅游城市*/
    private List<String> list;
    /**set集合*/
    private Set<String> set;
    /**map集合*/
    private Map<String, Object> map;
    
}
```



2、核心配置文件

```xml
<!--  创建Student对象  -->
    <bean id="student" class="com.wn.pojo.Student">
        <property name="likes">
            <array>
                <value>敲代码</value>
                <value>打游戏</value>
                <value>睡觉</value>
            </array>
        </property>

        <property name="list">
            <list>
                <value>成都市</value>
                <value>乐山市</value>
                <value>绵阳市</value>
            </list>
        </property>
        <property name="set">
            <set>
                <value>aaa</value>
                <value>bbb</value>
                <value>cc</value>
            </set>
        </property>
        <property name="map">
            <map>
                <entry key="code" value="200"></entry>
                <entry key="msg" value="success"></entry>
                <entry key="data" value="请求成功!"></entry>
            </map>
        </property>
    </bean>
```





### 2、构造注入

 1、创建User类

注意：定义构造方法

```java
@Data
public class User {
//    普通字段注入
    private String uid;
    private String uname;
    private Integer age;
//    引用类型属性注入
    private Panda panda;

    public User(){
    }

    public User(String uid, String uname, Integer age) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }
}
```



2、核心配置文件

```xml
<!--    创建User对象-->
    <bean class="com.wn.pojo.User" id="user2">
<!--        构造方法参数名称注入-->
<!--        <constructor-arg name="uid" value="2002"></constructor-arg>-->
<!--        <constructor-arg name="uname" value="张泡泡"></constructor-arg>-->
<!--        <constructor-arg name="age" value="20"></constructor-arg>-->
<!--        构造方法参数顺序注入 -->
<!--        <constructor-arg index="0" value="2003"></constructor-arg>-->
<!--        <constructor-arg index="2" value="23"></constructor-arg>-->
<!--        <constructor-arg index="1" value="李泡泡"></constructor-arg>-->
<!--        构造方法参数类型注入-->
        <constructor-arg type="java.lang.String" value="2004"></constructor-arg>
        <constructor-arg type="java.lang.String" value="王泡泡"></constructor-arg>
        <constructor-arg type="java.lang.Integer" value="34"></constructor-arg>
    </bean>
```







##4.4、SpringIOC和DI注解开发方式



IOC（控制反转）的注解开发：

​	@Component ：该注解相当于：`<bean id='user' class="com.wn.pojo.User"></bean>`

​		默认情况下：id值为该类的类名首字母小写

@Component 注解衍生出如下注解:  (一般在工具类中使用，或者实体类对象)

​	@Repository  作用于dao层类注解

​	@Service 		作用于service层类注解

​	@Controller 	作用于service层类注解

实现方式:

注意： 本人jdk为17，spring版本更改为 5.3.3  

​	1、创建实体类  在类上添加 @Component

```java
/**
 * 教师类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component  //等价于  <bean id='user' class="com.wn.pojo.User"></bean>
//@Component("tea")
@Service
public class Teacher {

    private Integer tid;
    private String tname;

}
```

​	2、在核心配置文件  扫描指定包

```xml
    <!--    扫描指定包下spring注解-->
    <context:component-scan base-package="com.wn.pojo" />
```



​	3、测试

```java
public class UserBeanTest {

    public static void main(String[] args) {
        //1.加载spring核心配置文件，创建ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取spring容器中teacher对象
        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher);
    }
}
```





DI（依赖注入）： 注解开发方式

@Value :如果类中属性是常规字段，使用该注解



如果类中是引用类型属性，使用如下两个注解:

@Autowired  :根据属性类型进行注入，其次操作根据名称注入(该注解是由spring框架提供)

@Resource : 首先根据 名称注入，其次，根据属性类型进行注入(该注解是由java API提供)



案例:

```java
/**
 * 教师类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component  //等价于  <bean id='user' class="com.wn.pojo.User"></bean>
//@Component("tea")
@Service
public class Teacher {

    @Value("1001")
    private Integer tid;
    @Value("老徐")
    private String tname;

    /**持有Panda对象引用*/
//    @Autowired  //根据类型注入Panda对象
    @Resource
    private Panda panda;
}
```



**案例2： 通过注解开发实现 mapper层、service层、controller层对象创建和依赖注入**



**1、创建User类**

```java
/**
 * 用户类
 */
@Data
public class User {
//    普通字段注入
    private String uid;
    private String uname;
    private Integer age;

    public User(){
    }

    public User(String uid, String uname, Integer age) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }
}
```



**2、创建UserMapper类**

```java
/**
 * mapper层类
 */
@Repository
public class UserMapper {

    public User findById(){
        return new User("1003", "小刘", 23);
    }
}
```



**3、service层**



UserService接口:

```java
public interface UserService {

    User findById();
}
```



UserServiceImpl实现类:

```java
@Service
public class UserServiceImpl implements UserService {

    @Autowired //从spring容器中注入类型对象
    private UserMapper userMapper;


    @Override
    public User findById() {
        return userMapper.findById();
    }
}
```



**4、创建UserController类**

```java
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public User findById(){
        return userService.findById();
    }
}
```



5、修改spring核心配置文件

扫描指定spring 注解包路径:

```xml
    <!--    扫描指定包下spring注解-->
    <context:component-scan base-package="com.wn" />
```



**6、测试类**

```java
public class UserControllerTest {
    public static void main(String[] args) {
        //1.加载spring核心配置文件，创建ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、获取UserController对象
        UserController controller  = (UserController) context.getBean("userController");
        User user = controller.findById();
        System.out.println(user);

    }
}
```

