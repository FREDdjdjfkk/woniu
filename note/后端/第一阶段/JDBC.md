# JDBC

## JDBC是什么

```properties
JDBC(Java DataBase Connectivity) 称为Java数据库连接

提供操作数据库的一系列类和接口，规范了数据库的操作

不仅可以连接mysql,还可以连接sqlServer,Oracle

不同的数据库对JDBC的实现细节是不一样的
```

数据库厂商提供具体的实现类,数据库驱动

![JDBC概述](https://i-blog.csdnimg.cn/blog_migrate/74b05f0a1cb768dc40fd4eed59ba96c0.png)

在开发过程中，只需要引入数据库驱动，便可实现java和数据库的连接的操作



数据库驱动: 就是对JDBC做的具体实现，由数据厂商提供，打好jar包，引入项目中便可使用

 

## JDBC操作步骤

### 1,加载驱动

```java
 Class.forName("com.mysql.cj.jdbc.Driver");
```

```
如果项目中没有引入驱动依赖  java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver
```

### 2,获取连接

```java
   public static String url ="jdbc:mysql://localhost:3306/lianxi?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    public static String user ="root";

    public static  String pwd = "root1234";

//获取连接(建立连接)
    Connection conn =  DriverManager.getConnection(url,user,pwd);
           
```

如果连接信息不正确：java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)

### 3,创建Statement

```java
     //创建Statement对象
     Statement st = conn.createStatement();
```

### 4,发送并执行sql语句

```java
  String sql = "delete from employee where id = 3";
            //发送并执行sql语句
  int row =  st.executeUpdate(sql);  //执行增删改的sql语句
```

执行sql语句时，sql如果有语法错误:

```properties
java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'where id = 3' at line 1
```



### 5,处理结果(主要针对查询)

```java
 if(row > 0 ){
                System.out.printf("删除成功");
 }
```

### 6,关闭连接

```java
finally {
            //关闭连接
            try {
               if(conn != null){
                   st.close();
                   conn.close();
               }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
}
```



## 结果集处理

```java
  while(rs.next()){ // next()  判断是否有下条记录并返回下一条记录
              int id =  rs.getInt("id");
              String name = rs.getString("name");
              String location = rs.getString("location");
              Date date =  rs.getDate("buildDate");
              System.out.println(id+" "+name+" "+location+" "+date);
              //读取数据过程中必须保证连接是打开的
            }
```

```properties
rs.getXXX(下标) 下标是列的索引，从1开始
rs.getXXX("列名")  
```

将结果集封装在集合中

```java
            List<Company> companies = new ArrayList<>();

            while(rs.next()){ // next()  判断是否有下条记录并返回下一条记录
                int id =  rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                Date date =  rs.getDate("buildDate");
//              System.out.println(id+" "+name+" "+location+" "+date);
//              //读取数据过程中必须保证连接是打开的
////                rs.getObject()

                Company company = new Company();
                company.setId(id);
                company.setName(name);
                company.setLocation(location);
                company.setBuildDate(date);

                companies.add(company);

            }
            return companies;
```



