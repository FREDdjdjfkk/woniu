#一、JDBC概述



## 1.1、JDBC介绍

JDBC（Java Data Base Connectivity,java数据库连接）是一种用于执行SQL语句的Java API，可以为多种关系数据库提供统一访问，它由一组用Java语言编写的类和接口组成。JDBC提供了一种基准，据此可以构建更高级的工具和接口，使数 据库开发人员能够编写数据库应用程序，同时，JDBC也是个商标名。



**JDBC流程如下:**

![img](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319144538.png)



## 1.2、JDBC优缺点



**优点：**
直接底层操作，提供了很简单、便捷的访问数据库的方法，跨平台性比较强。灵活性比较强，可以写很复杂的SQL语句。

**缺点：**
因为JAVA是面向对象的，JDBC没有做到使数据能够面向对象的编程，使程序员的思考仍停留在SQL语句上。

操作比较繁琐，很多代码需要重复写很多次。
如果遇到批量操作，频繁与数据库进行交互，容易造成效率的下降。

输出参数

输入参数: 





#二、Mybatis概述



## 2.1、什么是Mybatis？

​		MyBatis(半自动) 是一款优秀的持久层框架hibrnate(全自动持久层框架)\DBUtils\Spring JPA，它支持自定义 SQL、存储过程以及高级映射。MyBatis 免除了几乎所有的 JDBC 代码以及设置参数和获取结果集的工作。MyBatis 可以通过简单的 XML 或注解来配置和映射原始类型、接口和 Java POJO（Plain Old Java Objects，普通老式 Java 对象）为数据库中的记录。



mybatis中文官网:https://mybatis.net.cn/index.html



## 2.2、mybatis框架优缺点

**优点：**

1、与JDBC相比，减少了50%的代码量

2、 最简单的持久化框架，简单易学

3、SQL代码从程序代码中彻底分离出来，可以重用    

4、提供XML标签，支持编写动态SQL

5、提供映射标签，支持对象与数据库的ORM字段关系映射

**缺点：**

1、SQL语句编写工作量大，熟练度要高

2、数据库移植性比较差，如果需要切换数据库的话，SQL语句会有很大的差异



#三、mybatis使用



## 3.1、mybatis入门案例



###3.1.1、创建数据表

```sql
-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int NOT NULL,
  `dname` varchar(15) DEFAULT NULL,
  `loc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', '营销部', '上海');
INSERT INTO `dept` VALUES ('20', '财务部', '北京');
INSERT INTO `dept` VALUES ('30', '策划部', '杭州');
INSERT INTO `dept` VALUES ('40', '人事部', '成都');
INSERT INTO `dept` VALUES ('50', '保安部', '嘉兴');
INSERT INTO `dept` VALUES ('60', '公关部', '东莞');
```



### 3.1.2、Idea创建Java项目

![image-20250319150153222](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319150153.png)





###3.1.3、pom.xml导入依赖

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <!--  当前项目GAV坐标-->
  <groupId>com.wn</groupId>
  <artifactId>mybatis-first</artifactId>
  <version>1.0-SNAPSHOT</version>
  <name>Archetype - mybatis-first</name>
  <url>http://maven.apache.org</url>

  <properties>
    <java.version>17</java.version>
  </properties>
  <!--  添加项目依赖-->
  <dependencies>
    <!-- 引入mysql驱动依赖   -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.20</version>
    </dependency>
    <!--  引入mybatis框架依赖  -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.10</version>
    </dependency>
    <!--  lombok依赖  -->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.30</version>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.1</version>
        <configuration>
          <!--当前jdk版本-->
          <source>17</source>
          <target>17</target>
        </configuration>
      </plugin>
    </plugins>
    <!--    maven运行时，默认不会加载src/main/java目录下的xml文件，通过以下配置方可解决-->
    <resources>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>true</filtering>
      </resource>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.*</include>
        </includes>
        <filtering>true</filtering>
      </resource>
    </resources>
  </build>
</project>
```



### 3.1.4、创建表对应实体类

Dept.java类:

```java
/**
 * 部门类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    /**部门编号*/
    private Integer deptno;
    /**部门名称*/
    private String dname;
    /**部门地址*/
    private String loc;
}
```



###3.1.5、db.properties配置文件

在src/main/resources目录下创建db.properties配置文件

```properties
jdbcDriver=com.mysql.cj.jdbc.Driver
jdbcUrl=jdbc:mysql://localhost:3306/mydb2?serverTimezone=GMT%2B8
JdbcUsername=root
jdbcPwd=123456
```



###3.1.6、mybatis核心配置文件

在src/main/resources/下创建mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mydb2?serverTimezone=GMT%2B8"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="org/wn/dao/DeptDao.xml"/>
    </mappers>
</configuration>
```



###3.1.7、创建sql映射文件

在org/wn/dao目录下创建DeptDao.xml文件，内容如下:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--
    namespace:命令空间，本案例中此处可以任意填写。但是到实际开发只能是对应dao层类的全路径
-->
<mapper namespace="dpet">
    <!-- 根据id查询部门信息
        select: 所有查询操作都使用此标签
            id:唯一标识符，此案例中可以任意取值，但是后期实际开发只能是对应接口中的 方法名称
            resultType: 指定查询到的数据最终封装的java类型
            parameterType:指定参数类型
     -->
    <select id="findById" resultType="org.wn.pojo.Dept" parameterType="int">
        select * from dept where deptno=#{deptno}
    </select>
</mapper>
```



###3.1.8、创建测试类

```java
/**
 * 测试类
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心配置文件，创建一个SqlSessionFactory工厂类对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.通过sqlSessionFactory创建sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.通过sqlSession发送sql语句,自动封装数据为指定类型并返回
        Dept dept = sqlSession.selectOne("dpet.findById",30);
        System.out.println(dept);
    }
}
```



启动类:

 ![image-20250319160005355](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319160005.png)



## 3.2、mybaits框架执行流程



执行流程图:

 <img src="https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319160355.png" alt="image-20250319160355502" style="zoom:80%;" />



**mybatis框架执行流程文字描述:**

1、读取 MyBatis 配置文件：mybatis-config.xml为 MyBatis 的全局配置文件，配置了 MyBatis 的运行环境等信息，例如数据库连接信息。

2、加载映射文件。映射文件即 SQL 映射文件，该文件中配置了操作数据库的 SQL 语句，需要在 MyBatis 配置文件 mybatis-config.xml 中加载。mybatis-config.xml 文件可以加载多个映射文件，每个文件对应数据库中的一张表。

3、构造会话工厂：通过 MyBatis 的环境等配置信息构建会话工厂 SqlSessionFactory。

4、创建会话对象：由会话工厂创建 SqlSession 对象，该对象中包含了执行 SQL 语句的所有方法。

5、Executor 执行器：MyBatis 底层定义了一个 Executor 接口来操作数据库，它将根据 SqlSession 传递的参数动态地生成需要执行的 SQL 语句，同时负责查询缓存的维护。

6、MappedStatement 对象：在 Executor 接口的执行方法中有一个 MappedStatement 类型的参数，该参数是对映射信息的封装，用于存储要映射的 SQL 语句的 id、参数等信息。

7、输入参数映射：输入参数类型可以是 Map、List 等集合类型，也可以是基本数据类型和 POJO 类型。输入参数映射过程类似于 JDBC 对 preparedStatement 对象设置参数的过程。

8、输出结果映射：输出结果类型可以是 Map、 List 等集合类型，也可以是基本数据类型和 POJO 类型。输出结果映射过程类似于 JDBC 对结果集的解析过程。



##3.3、基于mapper动态代理开发

**基于mapper开发的规范:**

1、接口和mapper映射文件要在同一个目录下

2、接口的名称要和配置文件的名称相同(后缀名不同)

3、mapper映射文件namespace值必须是接口的全路径

4、mapper映射文件中的唯一标识id要和接口中的方法名相同

5、mapper映射文件中每个sql的输出映射类型要和Mapper接口中的方法返回值类型相同

6、mapper映射文件中每个sql的输入参数类型要和mapper接口中的参数类型相同



###3.3.1、创建DeptMapper接口

```java
/**
 * 部门mapper接口
 */
public interface DeptMapper {
    /**根据id查询部门信息*/
    Dept findById(Integer deptno);
    /**根据查询所有部门数据*/
    List<Dept> findAll();
    /**新增部门信息*/
    void insetDept(Dept dept);
    /**根据id修改指定部门名称和地址*/
    void updateDept(Dept dept);
    /**根据id删除指定部门信息*/
    void deleteDept(Integer deptno);
}
```



### 3.3.2、创建映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.wn.dao.DeptMapper">
    <!--    根据id查询部门信息-->
    <select id="findById" parameterType="int" resultType="org.wn.pojo.Dept">
        select * from dept where deptno=#{deptno}
    </select>
    <!--    根据查询所有部门数据-->
    <select id="findAll" resultType="org.wn.pojo.Dept">
        select * from dept
    </select>
    <!--    新增部门信息-->
    <insert id="insetDept" parameterType="org.wn.pojo.Dept">
        insert into dept values(#{deptno},#{dname},#{loc})
    </insert>
    <!--    根据id修改指定部门名称和地址-->
    <update id="updateDept" parameterType="org.wn.pojo.Dept">
        update dept set dname=#{dname},loc=#{loc} where deptno=#{deptno}
    </update>
    <!--    根据id删除指定部门信息-->
    <delete id="deleteDept" parameterType="int">
        delete from dept where deptno=#{deptno}
    </delete>
</mapper>
```



### 3.3.3、修改mybatis核心配置文件

![image-20250319165442542](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319165442.png)



### 3.3.4、创建测试类

```java
public class MybatisMapperTest {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心配置文件，创建一个SqlSessionFactory工厂类对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.通过sqlSessionFactory创建sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.通过sqlSession对象获取DeptMapper的代理对象
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        /**根据id查询部门信息*/
        Dept dept = deptMapper.findById(30);
        System.out.println(dept);
        /**根据查询所有部门数据*/
        List<Dept> list = deptMapper.findAll();
        list.forEach(System.out::println); //遍历集合
        /**新增部门信息*/
        //创建Dept对象
        Dept insertDept = new Dept(70,"教学部","成都市");
        deptMapper.insetDept(insertDept);
        sqlSession.commit(); //提交事务,mybatis实现增、删、改时必须提交事务才能生效
        /**根据id修改指定部门名称和地址*/
        //查询指定id部门信息
        Dept updateDept = deptMapper.findById(70);
        //修改部门名称和地址
        dept.setDname("国安部");
        dept.setLoc("北京市");
        //修改
        deptMapper.updateDept(updateDept);
        sqlSession.commit();

        /**根据id删除指定部门信息*/
        deptMapper.deleteDept(60);
        sqlSession.commit();
    }
}
```



##3.4、Mybatis基于注解开发



在Mybatis中如果使用注解式开发，那么注解需要添加在Mapper接口中的抽象方法上，在注解中给定需要执行的SQL语句即可，这样就可

以不需要映射配置文件。Mybatis支持纯注解方式，支持纯映射配置文件方式，也支持注解和映射配置文件混合形式。当只有接口没有映

射配置文件在Mybatis-3-config.xml中对于引入映射可以通过加载指定接口类。也可以使用指定加载包.



###3.4.1、使用注解完成CRUD操作



####1、UserMapper接口

![image-20250319174026847](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319174026.png)



####2、测试类

 ![image-20250319174142185](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319174142.png)



###3.4.2、注解开发中的映射处理



在Mybatis中注解开发中，对于结果集的映射处理也是比较繁琐的，所以如果有结果集映射操作，建议使用映射配置文件方式实现



####1、映射注解介绍

#####1.1、@Results注解

代替的标签是`<ResultMap>`

@Results中的属性介绍:

id:表示唯一标识，相当于ResultMap的唯一标识

value:通过@Result注解配置映射关系



#####1.2、@Result注解

代替了`<id>`和`<Result>`标签

@Result中的属性介绍:

id:是否是主键字段

column:数据库列名

property:需要装配的属性名

one:需要使用@One注解(@Result(one=@One))

many:需要使用@Many注解(@Result(many=@Many))



#####1.3、@ResultMap注解

可通过该注解复用其它方法上的映射配置，value:指定其它@Results的id值



#### 2、使用案例:

##### 2.1、编辑UserMapper接口

![image-20250319174722433](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319174722.png)



#####2.2、测试类

 ![image-20250319174748850](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319174748.png)



###3.4.3、注解开发中使用动态SQL



在Mybatis中的注解开发中，对于动态SQL的处理是比较繁琐的，所以如果有动态SQL的操作，建议使用映射配置文件方式实现。



####1、使用脚本SQL实现

在`<script>`标签中通过动态SQL的标签完成SQL的拼接。



#####1.1、在UserMapper接口定义方法

![image-20250319175439478](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319175439.png)



#####1.2、测试类

 ![image-20250319175508480](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319175508.png)





####2、在方法中构建SQL



在Mybatis的注解中包含了@SelectProvider、@UpdateProvider、@DeleteProvider、@InsertProvider,这些注解统称为SqlProvider,它

们分别对应这查询、修改、删除、插入操作。当使用这些注解时将不在注解中注解直接编写SQL，而是调用某个类的特定方法类生成

SQL。



#####2.1、修改UserMapper接口

![image-20250319175807017](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319175807.png)



#####2.2、定义UserMapperProvider类

 ![image-20250319175834813](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319175834.png)



#####2.3、测试类

 ![image-20250319175859967](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319175900.png)









# 四、Mybatis核心配置文件



##4.1、标签properties



###4.1.1、创建properties文件

 ![image-20250319165748514](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319165748.png)



###4.1.2、核心配置文件中引入properties文件

 ![image-20250319165901650](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319165901.png)



##4.2、setting标签(全局设置)



这是MyBatis 中极为重要的调整设置，它们会改变 MyBatis 的运行时行为(影响全局)。 下表描述了设置中各项的意图、默认值等:

| 设置名                    | 描述                                                         | 有效值                       | 默认值                                                |
| ------------------------- | ------------------------------------------------------------ | ---------------------------- | ----------------------------------------------------- |
| cacheEnabled              | 全局地开启或关闭配置文件中的所有映射器已经配置的任何缓存。   | true \| false                | true                                                  |
| lazyLoadingEnabled        | 延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置 fetchType 属性来覆盖该项的开关状态。 | true \| false                | false                                                 |
| aggressiveLazyLoading     | 当开启时，任何方法的调用都会加载该对象的所有属性。 否则，每个属性会按需加载（参考 lazyLoadTriggerMethods)。 | true \| false                | false （在 3.4.1 及之前的版本默认值为 true）          |
| defaultStatementTimeout   | 设置超时时间，它决定驱动等待数据库响应的秒数。               | 任意正整数                   | 未设置 (null)                                         |
| safeRowBoundsEnabled      | 允许在嵌套语句中使用分页（RowBounds）。如果允许使用则设置为 false。 | true \| false                | false                                                 |
| safeResultHandlerEnabled  | 允许在嵌套语句中使用分页（ResultHandler）。如果允许使用则设置为 false。 | true \| false                | true                                                  |
| lazyLoadTriggerMethods    | 指定哪个对象的方法触发一次延迟加载。                         | 用逗号分隔的方法列表。       | equals,clone,hashCode,toString                        |
| defaultScriptingLanguage  | 指定动态 SQL 生成的默认语言。                                | 一个类型别名或完全限定类名。 | org.apache.ibatis.scripting.xmltags.XMLLanguageDriver |
| defaultFetchSize          | 为驱动的结果集获取数量（fetchSize）设置一个提示值。此参数只可以在查询设置中被覆盖。 | 任意正整数                   | 未设置 (null)                                         |
| multipleResultSetsEnabled | 是否允许单一语句返回多结果集（需要驱动支持）。               | true \| false                | true                                                  |



##4.3、typeAliases(类型别名)



下面是一些为常见的 Java 类型内建的类型别名。它们都是不区分大小写的，注意，为了应对原始类型的命名重复，采取了特殊的命名风格。

 ![image-20250319170102280](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319170102.png)



##4.4、mappers标签配置

Resource和class属性配置如下:

 ![image-20250319170155625](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319170155.png)



#五、Mybatis之sql映射文件



## 5.1、输入映射

在mybatis中参数传递三种方式。如下:



###5.1.1、顺序传参法

注解案例:

![image-20250319171109557](../AppData/Roaming/Typora/typora-user-images/image-20250319171109557.png)

配置文件案例:

 ![image-20250319171137816](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319171137.png)



###5.1.2、POJO传参法

注解开发案例:

 ![image-20250319171258365](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319171258.png)

配置文件案例:

 ![image-20250319171237395](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319171237.png)



###5.1.3、Map传参法

注解开发案例:

 ![image-20250319171339459](../AppData/Roaming/Typora/typora-user-images/image-20250319171339459.png)

注意:Map传参，根据key获取value方式取值



###5.1.4、@Param注解传参



**在什么情况使用@Param注解呢？**  

1.当方法有多个参数时。（最常用）

2.想给方法的参数取别名。（可以将复杂的参数名称换个简单的）

3.当xml文件的sql语句含有占位符$（$占位符稍后会讲解）

4.如果在动态 SQL 中使用了参数作为变量，那么也需要 @Param 注解，即使你只有一个参数。

**案例:**

 ![image-20250319172100254](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319172100.png)



##5.2、Mybatis输出映射



###5.2.1、在mapper配置文件中配置如下:

 ![image-20250319172248499](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319172248.png)



###5.2.2、编写测试类

 ![image-20250319172326392](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319172326.png)



##5.3、Mybatis动态SQL



在jdbc中我们经常会遇到字符串拼接sql语句，然后把参数传入再查询等等。而动态sql的出现就是为

了解决这个拼接的问题。



###5.3.1、mybatis常见的动态标签

```
<if>、<choose>、<foreach>、<where>、<trim>等
```



###5.3.2、if判断(重点掌握）

 ![image-20250319172606040](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319172606.png)



###5.3.3、sql片段使用(掌握)

 ![image-20250319172715874](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250319172715.png)



###5.3.4、forEach(了解)





#六、Mybatis关系映射

​	

Mybatis关系映射分为:一对一、一对多、多对多



##6.1、一对一关系映射

(案例：一个用户对应一个身份证 ，用户表和用户详情信息表 )



###6.1.1、创建数据库表并添加数据

**用户表:**

 ![image-20250320192939359](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320192939.png)



**身份证表:**

 ![image-20250320193007584](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320193007.png)



###6.1.2、创建实体类

**用户类:**

 ![image-20250320193058846](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320193058.png)

**身份证类:**

 ![image-20250320193133945](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320193134.png)



###6.1.3、创建mapper接口

 ![image-20250320193209088](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320193209.png)



###6.1.4、创建Mapper接口对应的映射文件(使用resultMap方式)

 ![image-20250320193248514](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320193248.png)



###6.1.5、配置核心配置文件

 ![image-20250320193330540](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320193330.png)



###6.1.6、编写测试类

![image-20250320193401725](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320193401.png)





## 6.2、一对多关系映射

案例:一个用户对应多个订单

​		部门和员工之间的关系



###6.2.1、创建数据库表

**订单表:**

 ![image-20250320200116211](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320200116.png)

**用户表:**

 ![image-20250320200138326](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320200138.png)



###6.2.2、创建对应的实体类

 ![image-20250320200203641](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320200203.png)



###6.2.3、创建mapper接口

 ![image-20250320200228657](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320200228.png)



###6.2.4、创建映射文件并进行配置

 ![image-20250320200308049](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320200308.png)

###6.2.5、核心配置文件配置

![image-20250320200338375](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320200338.png)

###6.2.6、编写测试类

![image-20250320200406041](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320200406.png)





##6.3、多对多映射关系

案例:一个订单对应多个订单单项，一个订单单项对应多个订单。

​		学生和教师之间的关系。



###6.3.1、创建数据库表

**订单表:**

 ![image-20250320201149177](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201149.png)

**订单单项表:**

 ![image-20250320201232613](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201232.png)

**中间表:**

 ![image-20250320201256874](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201256.png)



###6.3.2、创建实体类

**订单类:**

 ![image-20250320201339992](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201340.png)

**订单单项类:**

 ![image-20250320201359937](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201359.png)



###6.3.3、创建对应的Mapper接口

**订单接口:**

 ![image-20250320201438945](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201439.png)

**订单单项接口:**

 ![image-20250320201459141](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201459.png)



###6.3.4、创建接口对应的映射文件

**订单项映射文件配置:**

 ![image-20250320201536339](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201536.png)



**订单单项配置文件配置:**

 ![image-20250320201559440](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201559.png)



###6.3.5、编写测试类

![image-20250320201629761](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250320201629.png)





