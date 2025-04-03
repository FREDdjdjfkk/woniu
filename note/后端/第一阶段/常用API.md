

# 常用API

```properties
JDK java开发集成工具包

常用API:内置的一些工具类
```

## 包装类

```properties
对基本数据类型进行的封装

        //int  -- Integer
        //byte -- Byte
        //short -- Short
        //long -- Long
        //float -- Float
        //double -- Double
        //boolean -- Boolean
        //char -- Character

装箱：
	将基本数据类型转换为包装类型的过程
	自动完成  valueOf完成
	 Integer num1 = Integer.valueOf(num);
拆箱:
	将包装类型转换为基本数据类型的过程
	自动完成 intValue()完成
	 num1.intValue();
```

```java

        int  num = 10;

        Integer num1 = new Integer(10); //装箱    Integer num1 = Integer.valueOf(num);
//        Integer num1 = num; //装箱    Integer num1 = Integer.valueOf(num);

        Integer num2 = 128;// Integer num2 = Integer.valueOf(128);  new Integer(128)
        Integer num3 = 128;// new Integer(128)

        int num4 = num1; //  int num4 = num1.intValue(); 拆箱


        double d1 = 10.0;
        Double d = 10.0;// Double d = Double.valueOf(d1);
        Double d2= 10.0;
        System.out.println(d1 == d2);
```

## String类

```properties
字符串

字符串中的值是只读的
```

```java
   //常量池中  str = f001
        String str = "hello";
        String str1 = "he"+"llo";

        String str2 = "hello";

        String str3 = new String("hello");

        String str4 = str3;

        String str5 = new String("hello");

        System.out.println(str == str1);//true
        System.out.println(str1 == str2);//true
        System.out.println(str2 == str3);//false
        System.out.println(str3 == str4);//true
        System.out.println(str4== str5);//false

        str = "new Hello";

        str+= "test";

```

### 常用构造方法

```java
 //常用构造方法
        String str1 = new String();

        String str2 = new String("hello");

        byte[] bytes = {97,98,99};

        String str3 = new String(bytes);

        char[]  chars = {'a','v','n'};

        String str4 = new String(chars);

```

### 常用方法

![image-20250310110652742](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250310110659.png)

```properties
length()  获取字符串的长度
charAt(i)  获取指定位置上的字符 
eaquls(str)  判断两个字符串的值是否相等
```

```java

        String str = "test";

        char[] chars = str.toCharArray();//将字符串转换为char数组


        //indexOf 获取字符串首次出现的索引位置
        int index = str.indexOf("a");

        System.out.println(index);

       int i =  str.lastIndexOf("t");
        System.out.println(i);

        //concat 拼接字符串 效率较低  每一次都会产生新的字符串
        str = str.concat("hello");
        System.out.println(str);

        //contains 判断一个字符串中是否存在另一个字符串
        boolean result = str.contains("he");
        System.out.println(result);

        //subString(int begin)  截取字符串
        //subString(int begin,int end)  左闭右开  >=begin  <end

//        str = str.substring(0,3);

        System.out.println(str);

        int t = 't';

        int j = 'j';

        System.out.println("t:"+t);
        System.out.println("j:"+j);

        System.out.println( str.compareTo("testhello"));

//        str.startsWith() 以什么开头
//        str.endsWith()  以什么结尾
        String str1 = "java,python,c++,c#";
        String[] strs =str1.split(",");//split是按照某种格式分割字符串，返回字符串数组

        for(String s:strs){
            System.out.println(s);
        }

        String str2 = " sjgf askjdf ";

        System.out.println(str2.trim());//trim去掉前后空格

        str1 = str1.replace(",",":");

        System.out.println(str1);

```

### 静态方法

```java
 String str = String.join(",","java","c++","python");

        System.out.println(str);

        String str1 = String.valueOf(10);

        System.out.println(str1+1);

       int num =  Integer.parseInt("10");

//       Float.parseFloat()

//      Double.parseDouble()

        System.out.println(num+1);

```





## 正则表达式

```properties
是一门独立的表达式语言
作用：对字符串做特殊格式匹配
是由普通字符和元字符组成

元字符:具备特殊含义
```

常见的元字符:(了解)

```properties
^:以什么开头
$:以什么结尾

*: 前面元素出现0次或多次
+: 前面元素出现1次或多次
?: 前面元素出现0次或1次
{n}:前面元素出现n次
{n,m}: 前面元素出现n到m次
{n,}: 前面元素至少出现n次

[a-z]:a-z小写字母
[A-Z]:A-Z大写字母
[0-9]:数字
[a|b]:只能是a或b
[^a]:除了a以外的所有字符
[^a-z]

\d 代表[0-9]
\w
.....
```

```properties
TMT30

T2TMT 

GTMT
```



## 练习:

用户注册

用户名的要求：6-18长度

密码： 要求字母数字（大写）

手机号码：

邮箱验证:

## StringBuilder

```properties
一个可变的字符序列
```

```java
 //默认创建了一个长度16的char型数组
        StringBuilder stringBuilder = new StringBuilder("test");

        String str = "test";
//        str =  str.concat("hello");

        stringBuilder.append("hello");
        stringBuilder.append("hello");
        stringBuilder.append("hello");
        stringBuilder.append("xxx");

        System.out.println(stringBuilder.toString());
```

![image-20250310151456823](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250310151456.png)

## StringBuffer

```properties
StringBuffer和 StringBuilder用法上完全一致

唯一不同的是StringBuffer的所有方法都是同步方法(线程安全的)
```



面试题:String StringBuilder和StringBuffer有什么区别

```properties
String是不可变字符 
StringBuilder和StringBuffer是可变字符
从字符串拼接上的效率来说，StringBuilder和StringBuffer效率更高

StringBuffer是线程安全的，StringBuilder是线程不安全的
```

## Object类

![image-20250310153824713](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250310153824.png)

### 克隆(了解)

```properties
浅克隆和深克隆
```

#### 浅克隆

里面的对象的地址是一样的

![image-20250310155228554](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20250310155228554.png)

```java
public class User implements Cloneable{

    String name="zhangsan";

    int age = 20;

    IdCard idCard;


    public User(IdCard idCard){
        this.idCard = idCard;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User)super.clone();
    }
}
```





#### 深克隆

里面的对象也需要被克隆

```properties
双重浅克隆可以实现深克隆
```

![image-20250310160117229](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250310160117.png)



```java
public class User implements Cloneable{

    String name="zhangsan";

    int age = 20;

    IdCard idCard;


    public User(IdCard idCard){
        this.idCard = idCard;
    }

    @Override
    public User clone() throws CloneNotSupportedException {

        User newUser= (User)super.clone();
        //还需要克隆里面的对象
//        idCard = 新的idCard
        newUser.idCard = idCard.clone();


        return newUser;
    }
}

```

```java
public class IdCard implements Cloneable{

    String idNo="510q973r23";


    @Override
    public IdCard clone() throws CloneNotSupportedException {
        return (IdCard) super.clone();
    }
}

```

finalize方法:

```java
public class Person {

    @Override
    public void finalize() throws Throwable {

        System.out.println("对象被销毁");
        super.finalize();
    }
}

class TestPerson{

    public static void main(String[] args) {

        Person p = new Person();

        p = null;

        System.gc();//通知垃圾回收器进行对象的回收  回收未被引用

    }
}

```



final,finalize,finally有什么区别



## Comparable

```properties
如果你需要某个对象具备比较的能力，需要实现Compareable接口，并实现compareTo方法
```

```java
public class Person implements Comparable<Person> {

    String name;

    int age;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Person p) {

        if(this.age > p.age){
            return 1;
        }else if(this.age == p.age){
            return 0;
        }
        return -1;
    }
}

```



## Comparator

```java

public class PersonComparetor implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {

        if(o1.age > o2.age){
            return 1;
        }else if(o1.age == o2.age){
            return 0;
        }
        return -1;
    }
}
```

```java
        //希望person对象具备比较的能力
        Person person1 = new Person("admin",20);
        Person person2 = new Person("test",18);

//        System.out.println(person1.compareTo(person2));

        //编写一个比较器
//        Comparator comparator = new PersonComparetor();
//        System.out.println(comparator.compare(person1,person2));

//        Comparator<Person> comparator = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if(o1.age > o2.age){
//                    return 1;
//                }else if(o1.age == o2.age){
//                    return 0;
//                }
//                return -1;
//            }
//        };

//        System.out.println( comparator.compare(person1,person2));

        Comparator<Person> comparator = (o1,o2) ->{return o1.age>o2.age ?1:o1.age == o2.age?0:-1;};
        System.out.println(comparator.compare(person1,person2));

```

面试题: Comparato和Comparable 的区别

## Date类

```java
        Date beginTime = new Date();//获取系统当前的时间

//        System.out.println(date);

        //date.getTime() 从1970年1月1日0点0分到现在的毫秒数
//        System.out.println(beginTime.getTime());

//        String str = "hello world";

        StringBuilder stringBuilder = new StringBuilder("hello world");

        for(int i = 0;i<100000;i++){

//            str = str.concat("test");
            stringBuilder.append("test");
        }

        Date endTime = new Date();

//        System.out.println(date);

        //date.getTime() 从1970年1月1日0点0分到现在的毫秒数
//        System.out.println(endTime.getTime());

        long time =endTime.getTime() - beginTime.getTime() ;

        System.out.println("耗时:"+time);

```

将日期转为字符串：

```java
 //日期格式化
        Date date = new Date();
//        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        String strDate = simpleDateFormat.format(date);//把日期转换固定格式的字符串

        System.out.println(strDate);
```

将字符串转为日期:

```java
 //将字符串转为日期格式

        String str = "2025-10-02";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = simpleDateFormat.parse(str);

        System.out.println(date);
```



## 日历类

```properties
Calendar类是一个抽象类,了解
```

```java
  Calendar calendar = Calendar.getInstance();

//        System.out.println(calendar.getTimeInMillis());

        //获取指定数据  如：年  月  日
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        calendar.set(Calendar.YEAR,2010);

//        System.out.println();

//        calendar.setTime();  根据日期设置日历值 
```



## Math类

```properties
Math类包含执行基本数字运算的方法
```

```java
//        Math.random()  取随机值[0,1)
//        System.out.println(Math.abs(-10));

//        System.out.println(Math.floor(3.7));  向下取证

//        System.out.println(Math.round(3.5)); //round四舍五入

//        System.out.println(Math.ceil(3.4));//向上取整

//        Math.min()

//        System.out.println(Math.pow(10,3));
....
```

详见文档

## UUID

```java
//UUID用作一个数据的唯一标识
        UUID uuid = UUID.randomUUID();

        System.out.println(uuid);
```

## Random

```java
       Random random = new Random();
        System.out.println(random.nextInt(100));
```





