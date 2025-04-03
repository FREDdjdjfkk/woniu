# Java基础语法



## 标识符

```properties
是某种标记,表示某种特殊的含义
if else public   number a ....
```

1，系统定义的标识符

​    关键字  public class static  while do if ....

2,  用户自定义  

 变量名  类名  常量名  方法名..



## 变量

```properties
变量：是内存中一个存储区域  用于保存数据
```

变量必须先声明，后使用

变量的声明:

```properties
数据类型  变量名;
```

```java
byte number;
byte number2;

byte num1,num2;
```



变量中三要素：

```properties
数据类型  变量名  变量值
```



变量的初始化:

```java
//声明变量的同时初始化
byte number = 0;

 byte num1=2,num2=10;

//先声明 后初始化
byte num;

num = 10;
```

值必须和数据类型匹配



## 数据类型

```properties
java中数据类型分为两大类:
1,基本数据类型
   八大基本数据类型
   整数，小数，字符，布尔
   
   字节： byte 
   整型： int
   短整型： short 
   长整型:  long
   
   	byte：8位，取值范围为 -128 到 127。 

	short：16位，取值范围为 -32768 到 32767。

	int：32位，取值范围为 -2,147,483,648 到 2,147,483,647。

	long：64位，取值范围为 -9,223,372,036,854,775,808 到 9,223,372,036,854,775,80
   
   浮点型
   单精度浮点型：float
   双精度浮点型: double
   
   字符: char
   布尔型:boolean true false
   
   
   
2,引用数据类型
String class 数组 接口 Object  List ...
```

![img](https://i-blog.csdnimg.cn/direct/b412a6da3aed407a9d67781fc3cd11b8.png)

![img](https://i-blog.csdnimg.cn/direct/d9cf4134bfeb44b98e74e0a4bc39c2f1.png)

![img](https://i-blog.csdnimg.cn/direct/29e671adfcb34395aaf6533415df497c.png)

![img](https://i-blog.csdnimg.cn/direct/b593f38c0b2543409b90e8d208075080.png)

```java
        byte by = 126;

        short sh = 129;

        int in = 23640823;

        long l = 32645;

//        float  f = 0.25F;

        double d = 20.35;

        //65-90是A-Z  97-122是a-z
        char ch = '中';

        System.out.println((int)ch);

        boolean  bo = false;
```

## 字符串

String是引用数据类型

```java
        //String是引用数据类型
        String str = "afjsgf248!!~~~";

        System.out.println(str);


//        System.out.println("请输入数字:");
//        //输入
        Scanner in = new Scanner(System.in);//
////        int num = in.nextInt();
////
////        System.out.println(num);



        System.out.println("请输入字符串:");

        String inStr =  in.nextLine();

        System.out.println(inStr);
```



## 运算符

| 运算符         | 符号                                       | 案例                                                         |
| -------------- | ------------------------------------------ | ------------------------------------------------------------ |
| 算术运算符     | +，-，*，/,%                               | int a = 10,b=20; int c = a+b;                                |
| 自增，自减     | ++,--  对自己+1或者-1                      | int a = 10;  a++  或 ++a                                     |
| 赋值运算符     | += -= *= /= %=                             | int a = 10; a+=5；                                           |
| 比较运算符     | > < >= <= == !=                            | boolean flag = a>b;                                          |
| 逻辑运算符     | & \| && \|\|  ！  两个&&，\|\|具备短路运算 |                                                              |
| 位运算符(了解) | <<   >>                                    | a>>1  相当于a/2                                              |
| 三目运算符     | 条件表达式 ? 值1：值2                      | String result = age >= 18 ?( age<=40 ?"中年":"老年") :"未成年"; |

注意:字符串可以用+ 或者+= 做拼接功能

注意:==在java中比较的是值和内存地址

```java
//算术运算符  + - * / %

        int a = 10,b = 20;

        int c = a+b;

        System.out.println(c);

        //++  -- 自增  自减

        //赋值运算符  = += -= *= /= %=

        a += 5;// a = a + 5;

        //比较运算符  >  < >= <= == !=
        //== 比较的是值和内存地址
        boolean flag = a > b;

        String str1 = "a";
        String str2 = new String("a");
        System.out.println(str1.equals(str2));

        //逻辑运算符  && || !  &  |
        if (a > b &&  a++ > 10){
            System.out.println("条件成立");
        }


        a = 15;
        b = 20;
        System.out.println(a|b);

//          15    00011
//          20    10100
//
//                11111

        //位移运算符  <<  >>  扩展
        a = a << 1;

        System.out.println(a);
```



## 数据类型的转换

```properties
范围较小的数据类型可以自动转换为范围较大的数据类型

大范围的值放入小的类型中  强制转换  ---(数据类型)

byte和short在运算过程中  类型会自动提升为整型

```



```java
        short a=10,b=5;

        //byte和short在运算过程中  类型会自动提升为整型
        int c = a+b;

        byte  d =6;
        //范围较小的数据类型可以自动转换为范围较大的数据类型
        int e = d;

        int k = 10;
        //大范围的值放入小的类型中  强制转换  ---(数据类型)
        byte l = (byte)k;

        //char 型  赋值可以是整型
        char ch = 97;

        ch -= 32;

        System.out.println(ch);

//        int ch1 = 'A';
//
//        System.out.println(ch1);
//
//        int a1=15,a2=10;
//
//        double d1 = a1/a2;
//
//        System.out.println(d1);
```



明天内容:

1,条件结构 if else  switch

2,循环结构



作业:

1，使用三目运算符判断一个数是不是水仙花数

输入一个三位数 

  水仙花数  个位十位百位的立方和等于这个数本身

```properties
153 
1*1*1+5*5*5+3*3*3 == 153?"是"...
```

2,![image-20250226175635690](https://woniumd.oss-cn-hangzhou.aliyuncs.com/web/dingling/20250226175635.png)

```properties
声明四个变量 a,b,c,d

9:50     17:30
```

