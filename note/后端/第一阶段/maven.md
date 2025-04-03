# Maven

```properties
Maven是一个项目管理工具
```

## Maven能解决什么问题

​		可以用更通俗的方式来说明。我们知道，项目开发不仅仅是写写代码而已，期间会伴随着各种必不可少的事情要做，下面列举几个感受一下：

​	1、我们需要引用各种jar包，尤其是比较大的工程，引用的jar包往往有几十个乃至上百个， 每用到一种jar包，	都需要手动引入工程目录，而且经常遇到各种让人抓狂的**jar包冲突**，版本冲突。

​	2、我们辛辛苦苦写好了Java文件，可是只懂0和1的白痴电脑却完全读不懂，需要将它编译成二进制字节码。好	歹现在这项工作可以由各种集成开发工具帮我们完成，Eclipse、IDEA等都可以将代码即时编译。当然，如果你	嫌生命漫长，何不铺张，也可以用记事本来敲代码，然后用javac命令一个个地去编译，逗电脑玩。Maven可以  	实现**快速编译**

​	3、世界上没有不存在bug的代码，计算机喜欢bug就和人们总是喜欢美女帅哥一样。为了追求美为了减少bug，	因此写完了代码，我们还要写一些单元测试，然后一个个的运行来检验代码质量。Maven可以生命周期命令进	行单元测试

​	4、再优雅的代码也是要出来卖的。我们后面还需要把代码与各种配置文件、资源整合到一起，定型打包，如果	是web项目，还需要将之发布到服务器，供人蹂躏。Maven**快速打包**

试想，如果现在有一种工具，可以把你从上面的繁琐工作中解放出来，能帮你构建工程，管理jar包，编译代码，还能帮你自动运行单元测试，打包，生成报表，甚至能帮你部署项目，生成Web站点，你会心动吗？Maven就可以解决上面所提到的这些问题。

## 两点经典功能

### 1,依赖管理

```properties
Maven的一个核心特性就是依赖管理
```

![image-20250319142852298](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250319142852.png)

有了maven的依赖之后，只需要我们告诉maven需要什么jar文件

### 2,项目构建

```properties
指的是项目从编译、测试、运行、打包、安装 ，部署整个过程都交给maven进行管理，这个过程称为构建。
```

只需要通过maven的命令下达指令就行



## Maven的使用

```properties
具备maven的环境
```

maven的版本选择，根据你的idea的版本来

目前最高版本3.9.9 

配置Maven的环境变量:

![image-20250319143947142](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250319143947.png)



![image-20250319144132740](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250319144132.png)

测试maven环境

![image-20250319144318560](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250319144318.png)



创建本地仓库文件夹

1,在settings.xml中修改本地仓库路径

```xml
  <localRepository>D:/apache-maven-3.9.9/rep</localRepository>
```

2,修改仓库镜像

```xml
  <mirrors>

    <mirror>
        <id>aliyun-maven</id>
        <mirrorOf>central</mirrorOf>
        <url>https://maven.aliyun.com/repository/public</url>
        <blocked>false</blocked>
    </mirror>

  </mirrors>

```

