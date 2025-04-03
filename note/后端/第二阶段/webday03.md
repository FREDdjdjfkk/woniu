#一、Servlet



## 1.1、servlet介绍

Servlet又称为Java Servlet是一个基于java技术的web组件，运行在服务器端，用于生成动态的内容。

Servlet是平台独立的java类，编写一个Servlet实际上就是按照Servlet规范编写的java类。



## 1.2、servlet使用

使用servlet有3中实现方式:

1、创建一个java类实现Servlet接口

2、创建java类继承GenericServlet类

**3、创建java类继承HttpServlet类**



###2.1、实现servlet第一种方法

使用步骤:

1、引入servlet相关的依赖

```xml
  <dependencies>
    <!--    导入Servlet相关依赖-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
    </dependency>
    <!--    JSP依赖-->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.1</version>
    </dependency>
  </dependencies>
```



2、创建java类实现servlet接口

```java
/**
 * 创建一个java类  实现 servlet 接口
 */
@WebServlet("/ServletA")
public class ServletA implements Servlet {
    /**
     * 初始化方法  该方法实在servlet对象创建时 就自动调用init一次
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init 方法 ----");
    }

    /**
     * 客户端 访问一次当前servlet，就会调用一次service方法
     * 该方法 主用于处理用户请求和完成响应 关键方法
     */
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("service  方法 --- ");
    }

    /**
     * 当servlet对象 被销毁时 自动调用destroy 方法一次
     */
    public void destroy() {
        System.out.println("destroy 方法 --- ");
    }

    public ServletConfig getServletConfig() {
        return null;
    }
    public String getServletInfo() {
        return "";
    }
}
```



###2.2、实现servlet第三种方式

1、导入依赖

2、创建java类继承HttpServlet类

```java
/**
 * 实现servlet第三种方式  继承HttpServlet类
 */
@WebServlet("/ServletB")
public class ServletB extends HttpServlet {

    /**
     * 重写doGet方法  该方法只能处理前端发送的  get 方式请求
     * @param request  请求对象
     * @param response 响应对象
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet 方法----");
    }
    /**
     * 重写doPost方法  该方法只能处理前端发送的  post 方式请求
     * @param request  请求对象
     * @param response 响应对象
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost 方法----");
        //调用doget方法
        doGet(request, response);
    }
}
```



### 2.3、HttpServlet执行原理

![image-20250402120152892](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250402120153.png)





# 二、HttpServletRequest对象



HttpServletRequest对象：主要作用是用来接收客户端发送过来的请求信息，例如：请求的参数，发送的头信息等都属于客户端发来的信
息，Service(方法中形参接收的是HttpServletRequest接口的实例化对象，表示该对象主要应用在HTTP协议上，该对象是由Tomcat
封装好传递过来。
HttpServletRequest是ServletRequest的子接口,ServletRequest只有一个子接口，就是HttpServletRequest。



HttpServletRequest对象作用:

1、设置请求头

2、获取请求参数

3、实现多个servlet之间数据共享(当做域对象使用)

4、实现请求转发和请求包含





## 2.1、获取请求参数

```java
/**
 * 通过Request对象获取请求参数
 */
@WebServlet("/ServletC")
public class ServletC extends HttpServlet {
    /**
     * 重写doget方法获取 用户每次请求中携带参数
     * @param request
     * @param response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取指定名称请求参数
//        String uname = request.getParameter("uname");
//        String pwd = request.getParameter("pwd");
//        String email = request.getParameter("email");
//        System.out.println("uname = " + uname + ",pwd = " + pwd + ",email = " + email);
        //2.获取所有请求中参数
//        Map<String, String[]> map = request.getParameterMap();
//        //遍历
//        Set<String> set = map.keySet();
//        for(String key : set){
//            System.out.print(key + ":");
//            for(String value : map.get(key)){
//                System.out.print(value + "\t");
//            }
//            System.out.println();
//        }
        //获取请求中所有key值
//        Enumeration<String> e = request.getParameterNames();
        //遍历
//        while(e.hasMoreElements()){
//            System.out.println(e.nextElement());
//        }
        //根据指定key获取对应的values值(针对一个key对应多个值的情况)
        String[] likes = request.getParameterValues("likes");
        Arrays.stream(likes).forEach(System.out::println); //遍历
    }
}
```



获取请求URL相关信息:

```java
/**
 * 通过Request对象获取请求中 url 内容
 */
@WebServlet("/ServletD")
public class ServletD extends HttpServlet {

    /**
     * 获取请求路径中内容
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //http://localhost:8080/webday03/ServletC?uname=ykj&pwd=233&email=123456@qq.com&likes=code&likes=games
        System.out.println(request.getScheme()); //http
        System.out.println(request.getProtocol()); //HTTP/1.1
        System.out.println(request.getServerPort()); //8080
        System.out.println(request.getRemoteHost()); //172.172.9.176
        System.out.println(request.getRemoteAddr()); //172.172.9.176
        System.out.println(request.getRequestURI()); //  /webday03/ServletD
        System.out.println(request.getContextPath());//  /webday03
        System.out.println(request.getServletPath()); // /ServletD
        System.out.println(request.getQueryString());//  uname=ykj&pwd=233&email=123456@qq.com&likes=code&likes=games
        System.out.println(request.getMethod());    //   GET
        System.out.println(request.getServerName());//    172.172.9.176
    }
}
```





## 2.2、实现请求转发和请求包含



请求转发和请求包含实现  **项目内部**  之间资源跳转。比如： 通过请求转发从ServletA跳转到ServletB



getRequestDispatcher(String path) //path ：项目内容资源路径

​	**[forward](../../javax/servlet/RequestDispatcher.html#forward(javax.servlet.ServletRequest, javax.servlet.ServletResponse))**(ServletRequest request, ServletResponse response) ：请求转发

​	**[include](../../javax/servlet/RequestDispatcher.html#include(javax.servlet.ServletRequest, javax.servlet.ServletResponse))**(ServletRequest request, ServletResponse response) : 请求 包含



代码实现:

```java
/**
 * 实现请求转发和请求包含
 */
@WebServlet("/ServletE")
public class ServletE extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //实现请求转发操作   注意: 资源路径中不需要包含项目名
//        req.getRequestDispatcher("/login.html").forward(req, resp);
        //通过请求包含实现跳转
        req.getRequestDispatcher("/login.html").include(req, resp);
    }
}
```



## 2.3、Servlet域对象







#三、实现前后端交互



## 3.1、实现如下功能

1、查询所有员工信息，用表格显示

2、新增一条员工数据

3、修改指定员工数据

4、删除指定员工数据



## 3.2、实现查询所有员工信息



大致步骤如下:

1、创建员工表

```sql
-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int NOT NULL,
  `ename` varchar(20) DEFAULT NULL,
  `job` varchar(10) DEFAULT NULL,
  `mgr` int DEFAULT NULL,
  `sal` double(8,2) DEFAULT NULL,
  `comm` double(7,2) DEFAULT NULL,
  `deptno` int DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  PRIMARY KEY (`empno`),
  KEY `fk_dept_emp` (`deptno`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1001', '刘备', '保安', '1009', '8000.00', null, '50', '1990-01-23 00:00:00');
INSERT INTO `emp` VALUES ('1002', '韦一笑', '销售员', '1013', '8000.00', '9000.00', '10', '1995-01-01 00:00:00');
INSERT INTO `emp` VALUES ('1003', '牛魔王', '保安', '1001', '6000.00', null, '50', '1994-07-01 00:00:00');
INSERT INTO `emp` VALUES ('1004', '唐僧', '销售员', '1013', '2000.00', '400.00', '10', '1995-01-01 00:00:00');
INSERT INTO `emp` VALUES ('1005', '曹操', '经理', '1009', '19000.00', null, '40', '1991-12-01 00:00:00');
INSERT INTO `emp` VALUES ('1006', '诸葛亮', '人事专员', '1005', '12500.00', null, '40', '1995-01-01 00:00:00');
INSERT INTO `emp` VALUES ('1007', '和珅', '经理', '1009', '25000.00', '1000.00', '20', '1990-03-03 00:00:00');
INSERT INTO `emp` VALUES ('1008', '任盈盈', '设计', '1011', '25000.00', '666.00', '30', '1994-08-01 00:00:00');
INSERT INTO `emp` VALUES ('1009', '刘邦', '董事长', null, '30000.00', null, '20', '1989-08-01 00:00:00');
INSERT INTO `emp` VALUES ('1010', '张三丰', '设计', '1011', '22500.00', null, '30', '1994-08-01 00:00:00');
INSERT INTO `emp` VALUES ('1011', '司马懿', '经理', '1009', '21000.00', null, '30', '1992-08-01 00:00:00');
INSERT INTO `emp` VALUES ('1012', '郭襄', '人事专员', '1005', '10000.00', null, '40', '1995-01-01 00:00:00');
INSERT INTO `emp` VALUES ('1013', '韦小宝', '经理', '1009', '26000.00', '5000.00', '10', '1991-12-01 00:00:00');
INSERT INTO `emp` VALUES ('1014', '白骨精', '销售员', '1013', '15000.00', '0.00', '10', '1992-10-01 00:00:00');
INSERT INTO `emp` VALUES ('1015', '西施', '销售员', '1013', '10000.00', '20.00', '10', '1995-01-01 00:00:00');
INSERT INTO `emp` VALUES ('1016', '典韦', '人事专员', '1005', '6000.00', null, '40', '2003-02-01 11:44:18');
INSERT INTO `emp` VALUES ('1020', '倩倩', '保安', '1009', '9000.00', null, '10', '2025-04-03 10:21:57');
```

2、创建web项目，并导入相关依赖(lombok、servlet、jsp、jdbc、mybatis、fastjson)

```xml
  <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  <dependencies>
    <!--    导入Servlet相关依赖-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
    </dependency>
    <!--    JSP依赖-->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.1</version>
    </dependency>
    <!--    引入fastjson依赖 序列化 数据-->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.83</version>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.30</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.9</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.20</version>
    </dependency>
  </dependencies>
```

3、创建mybatis核心配置文件

db.properties：

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mydb7?serverTimezone=GMT%2B8
jdbc.user=root
jdbc.pwd=123456
```

mybatis-config.xml文件:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--    加载指定properties配置文件-->
    <properties resource="db.properties"></properties>
    <!--  设置mybatis日志打印  -->
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>

    <!--    配置指定类型的别名-->
    <typeAliases>
        <!--        配置TUser的别名-->
<!--        <typeAlias type="com.wn.pojo.TUser" alias="user"></typeAlias>-->
        <package name="com.wn.entity"/>
    </typeAliases>


    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.user}"/>
                <property name="password" value="${jdbc.pwd}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <package name="com.wn.mapper"/>
    </mappers>
</configuration>
```

4、复制之前MybatisUtils工具类到工具包

mybatisUtils.java

```java
/**
 * mybatis工具类
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        //加载核心配置文件创建SqlsessionFactory工厂类对象
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace(); //打印堆栈信息
        }
    }

    /**
     * 获取会话功能对象
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 根据会话工厂对象回去Sqlsession对象
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
```

5、创建数据表 对应 实体类 Emp

```java
/**
 * 员工类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    /**员工编号*/
    private Integer empno;
    /**员工姓名*/
    private String ename;
    /**职位名称*/
    private String job;
    /**上级编号*/
    private String mgr;
    /**工资*/
    private Double sal;
    /**补偿金*/
    private Double comm;
    /**部门编号*/
    private Integer deptno;
    /**入职时间*/
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date hiredate;

}
```

6、创建EmpMapper接口 和 EmpMapper.xml映射文件

EmpMapper.java

```java
public interface EmpMapper {

    /**
     * 查询所有员工信息
     */
    @Select("select * from emp")
    List<Emp> findEmps();

}
```

7、创建service层接口和实现类

EmpService接口:

```java
public interface EmpService {

    List<Emp> findEmps();
}
```

EmpserviceImpl实现类:

```java
public class EmpServiceImpl implements EmpService {

    private SqlSession sqlSession = MybatisUtil.getSqlSession();
    private EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

    /**
     * 查询所有员工信息
     */
    @Override
    public List<Emp> findEmps() {
        return empMapper.findEmps();
    }
}
```

8、创建 servlet 类(接收前端请求和完成响应)

​	8.1、调用service层方法，获取所有员工信息

​	8.2、把查询数据集合 通过 fastJson 转换成 json格式字符串

​	8.3、通过response对象响应给前端( response.getWriter().write(json字符串) )



```java
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理响应中文乱码
        resp.setContentType("text/html;charset=utf-8");
        
        //1.调用service层方法 获取所有员工数据
        List<Emp> emps = empService.findEmps();

        //2.把集合转换成json格式字符串
        String jsonStr = JSONObject.toJSONString(emps);

        //3.把集合响应给前端
        resp.getWriter().write(jsonStr);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用get方法
        doGet(req, resp);
    }
}
```



9、编辑前端页面(emp.html)

​		9.1、在加载当前页面时发送请求，获取所有员工信息

​		9.2、遍历数据集合，把数据中表格显示出来

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>显示员工详情信息</title>
    <style>
        .empData{
            margin:auto;
            width: 1000px;
            border-collapse: collapse;
        }
        .empData th,.empData td{
            border: 1px solid red;
            text-align: center;
        }
    </style>
    <script src="./js/jquery-3.6.4.min.js"></script>
</head>
<body>
    <table class="empData">
        <thead>
            <tr>
                <th>员工编号</th>
                <th>姓名</th>
                <th>职位名称</th>
                <th>工资</th>
                <th>补偿金</th>
                <th>上级编号</th>
                <th>部门编号</th>
                <th>入职时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody id="empTbody">

        </tbody>
    </table>

<script>
    //加载页面时 查询所有员工信息
    $(function(){
        //发送异步请求
        $.get("/webday04/EmpServlet",function(result){
            //判断集合是否为null
            if(result.length > 0 ){
                //遍历数组
                for(var i = 0;i < result.length;i++) {
                    //获取当前json对象
                    var emp = result[i];
                    //通过jquery创建tr和td对象
                    $("<tr/>").append("<td>" + emp.empno + "</td>")
                        .append("<td>" + emp.ename + "</td>")
                        .append("<td>" + emp.job + "</td>")
                        .append("<td>" + emp.sal + "</td>")
                        .append("<td>" + emp.comm + "</td>")
                        .append("<td>" + emp.mgr + "</td>")
                        .append("<td>" + emp.deptno + "</td>")
                        .append("<td>" + emp.hiredate + "</td>")
                        .append("<td>" +
                            "<a href='#' onclick='showDialog("+emp.empno+")'>修  改</a>" +
                            "<a href='#' onclick='deleteById('+emo.empno+')'>删  除</a>" +
                            "</td>")
                        .appendTo($("#empTbody"))
                }
            }
        }, 'json');
    })
</script>
</body>
</html>
```



------其它功能相似步骤-------------









