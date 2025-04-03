# static关键字

```properties
表示是静态的
```

## static使用

### 修饰成员变量

```properties
当所有对象共享一个相同的数据时，可以使用static修饰成员变量

使用static修饰的变量叫做类变量,和对象无关
```

### 访问方式

```properties
类名.静态变量名
```

### 修饰方法

```properties
在方法声明时加上static关键字

和对象无关
```

```java
    public  static void call(){
        System.out.println("xxxxx");
    }
```

### 访问方式

```properties
 HuaWeiPhone.call();
 
 类名.方法名()
```

当一个方法中不使用任何成员变量时，可以声明为静态方法



静态方法中注意事项:

- 不能使用成员变量
- 静态方法中只能使用静态变量和局部变量
- 静态方法中不能直接调用本类的非其他静态方法



### static块

```java
   static {
        //只会执行一次,类加载时自动执行
   }
```

把只会执行一次的代码放入静态块中：例如文件的读取