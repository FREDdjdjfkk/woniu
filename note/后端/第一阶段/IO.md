



# IO流

```properties
IO流是用于处理输入和输出操作的机制，通过流的方式实现数据的传输。
```

按照流的方向分类:

## 输入流  read

```properties
从外部将数据流入程序内部  读取数据
```

## 输出流 write

```properties
将程序内部数据输出到外部  写数据
```

按照数据传输的单位分类:

## 字节流

```properties
数据在传输过程中是按照字节处理
```

抽象类:

```properties
InputStream  这个抽象类是表示输入字节流的所有类的超类
OutputStream  这个抽象类是表示字节输出流的所有类的超类
```

所有的数据都可以看成字节:  如文件，图片，音乐 

### FileInputStream

```properties
new FileInputStream(String filePathName); 文件在磁盘中的路径
new FileInputStream(File file) 文件
```

read()  每一次只读一个字节  返回字节数据对应的int值

```java
    File file = new File("D:\\test\\a.txt");
        InputStream inputStream = null;
        try {
            inputStream  = new FileInputStream(file);
            
            int b = -1;

            while(( b = inputStream.read() ) > -1){

                System.out.println((char)b);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
```

```
read(byte[] bytes)

需要自定义byte数组  大写由文件大小决定


read(byte[] bytes,数组中的起始下标值,一次读取的长度)
```

```java
 File file = new File("D:\\test\\a.txt");
        InputStream inputStream = null;
        try {
            inputStream  = new FileInputStream(file);

            int len = 10;

            while(len > 0){

                 byte[] bytes = new byte[10];
                //inputStream.read读取
//                 len = inputStream.read(bytes,0,bytes.length); //将读取的数据放入bytes数组中，返回读到的长度

                  len =inputStream.read(bytes);

//                len = inputStream.read(bytes,0,bytes.length);

               if(len>0){
                   String str = new String(bytes,0,len); //通过byte数组构建字符串
                   System.out.println(str);
               }

            }

//            System.out.println(len);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
```

### FileOutputStream

```properties
new FileOutputStream()
```

```java
 File file = new File("D:\\test\\a.txt");

        OutputStream outputStream = null;
        try {
            //写了之后文件如果存在，则覆盖原来的文件，如果文件不存在，则新建  只能新建文件，不能新建文件夹
            outputStream = new FileOutputStream("D:\\test\\newFile.txt",true);

//            outputStream.write(97);
//
//            byte[] bytes = new byte[]{97,98,99};
            String str = " test";
            byte[] bytes = str.getBytes();

//            outputStream.write(bytes);
            outputStream.write(bytes,0,bytes.length);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

```

## 文件的拷贝

```properties
边读边写的过程
```

```java
       File file = new File("D:\\test\\image.png");

        File newFile  = new File("E:\\test\\image.png");

        InputStream in = null;
        OutputStream out = null;
        //读图片
        try {
            in = new FileInputStream(file);

            out = new FileOutputStream(newFile);

            int b = 0;

            while((b = in.read()) != -1){
                out.write(b);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
```



## 字符流

```properties
数据在传输过程中是按照字符处理
```

抽象类:

```properties
Reader 用于读取字符流的抽象类
Writer 用于写入字符流的抽象类
```

处理的数据只能是文本 

如果使用字节流处理中文，可能会出现乱码,一个中文至少占两个字节,英文和数字占一个字节

```properties
常见的编码格式:  latin  数字和英文  ISO-8859-1 数字和英文 GBK 处理中文 GB2312 UTF-8
```

```java
        //使用字符流解决中文乱码问题
        Reader r = new FileReader("D:\\test\\a.txt");

        int b = 0;

        while((b = r.read()) != -1){

            System.out.print((char) b);
        }
        r.close();
```

## 数据流

```properties
DataInputStream 
DataOutputStream
```

```java
    public static void main(String[] args) throws Exception{
//        write();

        InputStream in = new FileInputStream("D:\\test\\b.txt");

        DataInputStream dataInputStream = new DataInputStream(in);

        int num = dataInputStream.readInt();

        System.out.println(num);

        dataInputStream.close();
        in.close();


    }

    public static void write() throws Exception{

        OutputStream out = new FileOutputStream("D:\\test\\b.txt");
        DataOutputStream outputStream = new DataOutputStream(out);
        outputStream.writeInt(125);

        outputStream.close();
        out.close();
    }
```

## 缓冲流

目的：将数据放入缓存区中，不立即写入文件中

```properties
BufferedInputStream
....

flush()  清空缓存，立即写入
```

## 对象流

```properties
数据的传输是对象

ObjectInputStream
ObjectOutputStream
```

### 序列化和反序列化

```properties
一个对象想要进行数据存储到文件中或者进行网络数据传输,这个过程就需要序列化

序列化 (Serialization)是将对象的状态信息转换为可以存储或传输的形式的过程
反序列化   Java反序列化就是指把存储数据读出来或者接收数据并恢复为Java对象的过程。
```

```java
 	  String pathName = "D:\\test\\user.txt";

        OutputStream out = new FileOutputStream(pathName);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        User user = new User(1,"admin","123");
        //将一个对象写入文件中,对象的类需要实现序列化接口
        objectOutputStream.writeObject(user);

        objectOutputStream.close();

        out.close();
```

需要类实现序列化接口

```java
public class User implements Serializable {
}
```

反序列化：

根据版本号进行对象读取



![image-20250314155128708](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/renxiaohua20250314155128.png)

```
serialVersionUID  序列化时的版本号 当类的结构发生改变时，版本号也会改变
```

```
transient  不允许被序列化
```



## Properties

```properties
是一个继承至Hashtable的集合

通常使用时：key  value都是字符串

```

```java
      Properties properties = new Properties();

        properties.setProperty("en","english");

        properties.setProperty("zh","chinese");

        properties.setProperty("en","engxxxxlish");


        String value = properties.getProperty("en");

        System.out.println(value);
```



 对Excel表格的操作  poi包

