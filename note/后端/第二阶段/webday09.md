#一、SpringMVC

![image-20250410094404266](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/yangkaijun/20250410094404.png)



##1.1、springMVC概述?

SpringMVC全称叫Spring web mvc,它是Spring框架中的一部分，所以不需要Spring与其整合，SpringMVC

和Strus2框架一样作用于web层的框架。





#二、跳转页面方式



## 2.1、使用request和response跳转

### 1、请求转发

```java
/**
 * 演示页面跳转案例
 */
@Controller //声明当前类是一个controller层类，并且创建该类对象交给Spring容器管理
public class ToPageController {
    /**
     * 通过request对象实现请求转发
     */
    @RequestMapping("/forwardTest1") //该注解设置请求映射
    public void forwardTest1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实现请求转发
        request.getRequestDispatcher("/login.html").forward(request, response);
    }
}
```



### 2、重定向

```java
    /**
     * 通过Response对象实现重定向
     */
    @RequestMapping("/redirectTest1") //该注解设置请求映射
    public void redirectTest1(HttpServletResponse response) throws ServletException, IOException {
        //实现请求重定向
        response.sendRedirect("/login.html");
    }
```



## 2.2、通过ModelAndView对象跳转

### 1、请求转发

```java
    /**
     * 通过ModelandView对象实现请求转发和重定向
     */
    @RequestMapping("forwardTest2")
    public ModelAndView forwardTest2(){
        //创建ModelAndView对象
        ModelAndView mav = new ModelAndView();
        //设置跳转的路径
        mav.setViewName("forward:/login.html");
        //返回ModelAndView对象
        return mav;
    }
```



### 2、重定向

```java
    /**
     * 通过ModelAndView实现重定向
     */
    @RequestMapping("/redirectTest2") //该注解设置请求映射
    public ModelAndView redirectTest2() throws ServletException, IOException {
        //创建ModelAndView对象
        ModelAndView mav = new ModelAndView();
        //设置跳转的路径
        mav.setViewName("redirect:/login.html");
        //返回ModelAndView对象
        return mav;
    }
```





##2.3、springMVC框架跳转方式

### 1、请求转发

```java
    /**
     * SpringMVC优化后请求转发和重定向
     * 1、使用Controller注解
     * 2、方法返回值是string类型
     * 3、返回字符串类型的视图名称
     */
    @RequestMapping("forwardTest3")
    public String forwardTest3(){
        return "forward:/login.html";
    }
```



### 2、重定向

```java

    /**
     * 实现重定向
     */
    @RequestMapping("/redirectTest3") //该注解设置请求映射
    public String redirectTest3() throws ServletException, IOException {
        return "redirect:/login.html";
    }

```



# 三、请求参数绑定



## 3.1、通过Request对象获取

```java
/**
 * 演示请求参数绑定
 */
@Controller
@RequestMapping("param") //表示访问当前controller类中请求映射时，必须以当前类上RequestMapping值作为前缀,比如: /param/selectAll
public class ParamController {


    /**
     * 通过request对象获取请求映射
     */
    @RequestMapping("/params01")
    @ResponseBody //自动把return 后的数据转换成json格式响应给前端，注意: 使用 @ResponseBody 该方法不能跳转页面
    public Map<String,Object> params01(HttpServletRequest request) {
        //创建map集合，存放响应前端数据
        Map<String,Object> map = new HashMap<String,Object>();
        //通过request对象获取请求参数
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        //封装响应数据
        map.put("uname", uname);
        map.put("pwd", pwd);
        map.put("msg", "请求成功");
        map.put("code",200);
        return map;
    }

}
```





## 3.2、通过方法形参进行绑定

```java
    /**
     * 通过形参绑定请求参数
     */
    @RequestMapping("params02")
    @ResponseBody
    public Map<String,Object> params02(String uname,String pwd){
        //创建map集合，存放响应前端数据
        Map<String,Object> map = new HashMap<String,Object>();
        //封装响应数据
        map.put("uname", uname);
        map.put("pwd", pwd);
        map.put("msg", "请求成功");
        map.put("code",201);
        return map;
    }
```





## 3.3、通过@Requestparam注解绑定

```java
    /**
     * 通过@RequstParam注解绑定请求参数
     * 默认请求下添加@RequstParam的参数表示前端必须传参
     */
    @RequestMapping("params03")
    @ResponseBody
    public Map<String,Object> params03(@RequestParam("username") String uname, @RequestParam(required = true,defaultValue = "007") String pwd){
        //创建map集合，存放响应前端数据
        Map<String,Object> map = new HashMap<String,Object>();
        //封装响应数据
        map.put("uname", uname);
        map.put("pwd", pwd);
        map.put("msg", "请求成功");
        map.put("code",201);
        return map;
    }
```





## 3.4、通过实体类进行绑定

User类:

```java
/**
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer uid;
    private String uname;
    private String pwd;
    private String sex;
}
```



ParamController类:

```java
/**
 * 演示请求参数绑定
 */
@Controller
@RequestMapping("param") //表示访问当前controller类中请求映射时，必须以当前类上RequestMapping值作为前缀,比如: /param/selectAll
public class ParamController {

    /**
     * 通过实体类接受请求参数
     * @param user  表示用户对象
     */
    @RequestMapping("params04")
    @ResponseBody
    public Map<String,Object> params04(User user){
        //创建map集合，存放响应前端数据
        Map<String,Object> map = new HashMap<String,Object>();
        //封装响应数据
        map.put("msg", "请求成功");
        map.put("code",201);
        map.put("data", user);
        return map;
    }
}
```



## 3.5、通过@PathVarible获取请求路径中参数

@PathVarible该注解获取url中参数进行映射

```java
    /**
     * 使用@pathVarible注解获取请求url参数映射到方法形参
     * 请求方式： http://localhost:8080/param/params05/lyf/1122
     */
    @RequestMapping("params05/{uname}/{pwd}")
    @ResponseBody
    public Map<String,Object> params05(@PathVariable String uname,@PathVariable String pwd){
        //创建map集合，存放响应前端数据
        Map<String,Object> map = new HashMap<String,Object>();
        //封装响应数据
        map.put("msg", "请求成功");
        map.put("code",201);
        map.put("uname", uname);
        map.put("pwd", pwd);
        return map;
    }
```



## 3.6、通过@RequestBody注解绑定

@RequestBody 接收前端发送json格式参数，

1、前端必须是post请求

2、设置context-type，值为application/json

3、后端接口一定支持post请求

4、方法形参是一个实体类，在实体类前面使用@RequestBody



login.html页面

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <script src="./js/jquery-3.6.4.min.js"></script>
</head>
<body>
        <form>
            <input type="text" placeholder="请输入用户名" id="uname"/> <br/>
            <input type="pasword" placeholder="请输入密码" id="pwd"/>
            <input type="button" value="登  录" id="loginBtn"/>
        </form>
    <script>
        //获取按钮对象，绑定click事件
        $("#loginBtn").click(function(){
            //1.获取请求参数，封装成json对象
            var params = {"uname":$("#uname").val(),"pwd":$("#pwd").val()};
            //2.发送异步请求
            $.ajax({
                url:"/param/params06",
                data:JSON.stringify(params),
                dataType:"json",
                type:"post",
                contentType:"application/json",
                success:function(res){
                    console.log(res) //打印后端响应的json数据
                }
            })
        });
    </script>
</body>
</html>
```



后端接收json数据方法:

```java
    /**
     * 使用@RequestBody注解接收前端请求体中参数
     */
    @PostMapping("params06")  //PostMapping只能接受前端发送post请求方式
    @ResponseBody
    public Map<String,Object> params06(@RequestBody User user){
        //创建map集合，存放响应前端数据
        Map<String,Object> map = new HashMap<String,Object>();
        //封装响应数据
        map.put("msg", "请求成功");
        map.put("code",202);
        map.put("data", user);
        return map;
    }
```





# 四、封装响应数据

1、创建ResultObj工具类

```java
package com.wn.webday09boot01.util;

/**
 * 封装响应结果实体对象
 */
public class ResultObj {

    private Integer code;
    private String msg;
    public boolean success;
    private Object data;

    /**
     * 设置响应数据
     */
    public ResultObj data(Object result){
        this.data = result;
        return this;
    }
    /**
     * 设置响应码
     */
    public ResultObj code(Integer code){
        this.code = code;
        return this;
    }

    public ResultObj msg(String msg){
        this.msg = msg;
        return this;
    }

    public ResultObj success(boolean success){
        this.success = success;
        return this;
    }
    /**
     * 定义静态方法封装请求成功信息
     */
    public static ResultObj ok() {
        ResultObj result = new ResultObj();
        result.code = 200;
        result.msg = "请求成功";
        result.success = true;
        return result;
    }

    public static ResultObj ok(Object data) {
        ResultObj result = new ResultObj();
        result.code = 200;
        result.msg = "请求成功";
        result.success = true;
        result.data = data;
        return result;
    }
    /**
     * 封装请求失败的方法
     */
    public static ResultObj error() {
        ResultObj result = new ResultObj();
        result.code = 500;
        result.msg = "请求失败";
        result.success = false;
        return result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

```



2、创建controller类封装响应数据



用map集合 和 ResultObj实体类 完成响应数据的封装

```java
package com.wn.webday09boot01.controller;

import com.wn.webday09boot01.bean.User;
import com.wn.webday09boot01.util.ResultObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 对响应数据进行封装
 */
@Controller
@RequestMapping("res")
public class ResultController {

    /**
     * 使用ResultObj实体类封装响应数据
     */
    @RequestMapping("resultObj")
    @ResponseBody
    public ResultObj resultObj(){
        //1.创建用户对象
        User user = new User(100, "root", "112233", "男");
        //2.封装数据
        return ResultObj.ok(user);
    }

    /**
     * 使用map集合封装响应数据
     */
    @RequestMapping("rsultMap")
    @ResponseBody
    public Map<String,Object> rsultMap(){
        //1.创建用户对象
        User user = new User(100, "root", "112233", "男");
        //创建map集合对象
        Map<String,Object> map = new HashMap<>();
        //封装响应数据
        map.put("data",user);
        map.put("msg","请求成功");
        map.put("success",true);
        map.put("code",200);
        return map;
    }
}

```







#五、全局异常处理



##5.1、全局异常处理

1、创建全局异常的工具类，在类上使用RestControllerAdvice

```java
/**
 * 全局异常处理类
 */
@RestControllerAdvice
//@ResponseBody
//@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理全局异常方法
     */
    @ExceptionHandler(Exception.class)
    public ResultObj handlerException(Exception e) {
        e.printStackTrace(); //打印堆栈信息
        return ResultObj.error();
    }
}
```



2、创建controller层类进行测试

```java
/**
 * 演示全局异常处理
 */
@RestController //等价于  @Controller + @ResponseBody
@RequestMapping("ex")
public class ExceptionHandlerController {

    /**
     * 查询指定用户信息
     */
    @RequestMapping("getById")
    public ResultObj getById(){
        try{
            //1。调用service层方法
            User user = new User(100, "root", "112233", "男");
            //处理异常方式  try...catch()
            if(true) throw new RuntimeException("不好意思，我要报错!!!");
            //2.响应数据
            return ResultObj.ok(user);
        }catch (Exception e){
            //处理异常
            e.printStackTrace();
        }
        return ResultObj.error();
    }

    /**
     * 测试全局异常处理
     */
    @RequestMapping("globalExceptionHandlerTest")
    public ResultObj globalExceptionHandlerTest(){
        //1。调用service层方法
        User user = new User(100, "admin", "112233", "男");
        int i = 10 / 0;
        return ResultObj.ok(user);
    }
}
```



## 5.2、针对指定异常类型进行处理



1、自定义异常类

```java
/**
 * 自定义异常类,该异常类表示用户名不存在
 */
public class UserNameNotFoundException extends RuntimeException {

    public UserNameNotFoundException() {
        super();
    }

    public UserNameNotFoundException(String message) {
        super(message);
    }

}
```



2、在全局异常类中新增处理指定异常方法

```java
    /**
     * 针对 用户名 不存在异常 进行单独处理
     */
    @ExceptionHandler(UserNameNotFoundException.class)
    public ResultObj handlerUserNameNotFoundException(UserNameNotFoundException e){
        e.printStackTrace();
        return ResultObj.error().msg(e.getMessage());
    }
```



3、在controller中新增方法进行测试

```java
    /**
     * 测试  通过全局异常类中指定方法捕获自定义异常类型
     */
    @RequestMapping("/checkUserNameAvilable")
    public ResultObj checkUserNameAvilable(String username){
        //判断
        if(username == null  || username.trim().isEmpty()){
            throw new UserNameNotFoundException("请求中未携带 username 参数");
        }
        return ResultObj.ok(username);
    }
```





# 六、日期转换

1、定义Student类

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String sname;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
```



2、编写接口

```java
/**
 * 演示后端日期转换处理
 */
@RestController
@RequestMapping("date")
public class DateChangeController {

    /**
     * 接收前端传递字符串格式日期
     * 如果前端日期是字符串类型，后端是Date类型，则可以使用@DateTimeFormat(pattern = "yyyy-MM-dd")
     */
    @RequestMapping("/changeDate")
    public ResultObj changeDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
        return ResultObj.ok(birthday);
    }

    /**
     * 通过实体类接受日期类型
     */@RequestMapping("student")
    public ResultObj student(Student s){
        return ResultObj.ok(s);
    }
}
```



#七、文件上传

1、前端

​	使用表单进行提交

​	表单中使用input type=file，同时name属性名称必须与后端接口参数名一致

​	提交方式 必须是 post请求

​	设置enctype="multipart/form-data"

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>
    <!--    定义表单-->
    <form action="/file/uploadFile" method="post" enctype="multipart/form-data">
        <input type="file" name="imgFile"/>
        <input type="submit" value="文件上传" />
    </form>
</body>
</html>
```



2、后端

​	接口参数名称与 前端输入项name名称一致

​	使用MultipartFile类型接收上传文件

```java
/**
 * 演示文件上传
 */
@Controller
@RequestMapping("file")
public class UploadFileController {

    /**
     * 实现文件上传接口
     */
    @RequestMapping("uploadFile")
    public void uploadFile(MultipartFile imgFile) throws IOException {
//        System.out.println(imgFile);

        String originalFilename = imgFile.getOriginalFilename();//获取上传文件原文件名称
        System.out.println(originalFilename);
        long size = imgFile.getSize();//表示上传文件大小
        System.out.println(size);
        String contentType = imgFile.getContentType(); //上传文件类型
        System.out.println(contentType);
        String name = imgFile.getName(); //获取表单中输入项 name属性值
        System.out.println(name);
        InputStream is = imgFile.getInputStream(); //获取上传文件输入流对象
        System.out.println(is);
        //https://img2.baidu.com/it/u=552882499,1044214449&fm=253&fmt=auto&app=120&f=JPEG?w=500&h=889
    }
}
```















