## Java入门

```pro
程序: 是计算机为了完成某种特定功能而编写的指令的集合

写的代码称之为编程

编程语言:
  机器语言：二进制
  
  十进制   0-9
  二进制  0  1 
  +  100010111
  
  汇编语言：
   助记符 add   mov 高级编程语言:
 
  高级编程语言:
   +   int   a = b+ c 
   Java JavaScript C++  C  C#...
```



## Java简介

Java诞生于  1995年 

jdk1.1 版本 

JDK: Java Develepment Kit java开发工具包

jdk1.8 和 17  21

JDK安装下载:

https://www.oracle.com/java/technologies/downloads/archive/

环境变量配置:

![image-20250226103506219](https://woniumd.oss-cn-hangzhou.aliyuncs.com/web/dingling/20250226103513.png)



![image-20250226103603647](https://woniumd.oss-cn-hangzhou.aliyuncs.com/web/dingling/20250226103603.png)

Java开发完成后  xxx.java 源文件  由程序员编写的

编译成class文件  javac 命令负责编译 

一次编译到处使用  支持跨平台

JRE: Java  runtime envelement  java的运行环境

虚拟机:  JVM   



## JAVA的第一个程序

```java
public class HelloWold{
    public static void main(String[] args){
        System.out.println("hello world");
    }
}
```

![image-20250226112448482](https://woniumd.oss-cn-hangzhou.aliyuncs.com/web/dingling/20250226112448.png)



目前将代码写在main的括号中



## 输出

```java
System.out.println("xxx");//换行输出
System.out.print("xxx");//不换行输出
```

##  输入

```java
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();

        System.out.println(number);
```



## 注释

```properties
作用：增强代码的可读性  
注释是不会被执行的  用我们最熟悉的语言对代码进行描述
建议10行代码三行注释

```

分为三种:

- 单行注释  //注释 

  

- 多行注释 /*注释*/

  ```java
          /*
          System.out.println("请输入:");
  
          //下面是输入一个数字
          Scanner in = new Scanner(System.in);  //
  
          int number = in.nextInt();
  
          System.out.println(number);
          
           */
  ```

  

- 文档注释

  ```java
  /**
  * 有关参数  返回值  作者....
  */
  ```

  数据类型  变量   运算符

