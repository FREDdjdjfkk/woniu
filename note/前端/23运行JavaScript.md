## 关于JavaScript

### 前端三剑客

1. html：负责页面的内容，比如文字，图片等
2. css：负责页面的样式，比如文字的样式，按钮的颜色
3. JavaScript：负责页面的逻辑，例如根据不同的账号，显示不同的内容

### JavaScript

JavaScript是一种轻量级的编程语言

## 运行JavaScript

### js代码的分类

JS根据编写位置的不同，可以分为3类

1. 内联JS，直接写在html标签上的js代码
2. 内部JS，在当前的html页面的`<script></script>`标签中编写js代码
3. 外部JS，在外部创建一个后缀名为`.js`的文件，在该文件中编写js代码，在html页面中引入该js文件

### 1.内联JS

```js
	<button onclick="">按钮</button>
```

### 2.内部JS

```js
<body>
    <script>
    // js代码
    console.log(11);

</script></body>
```

### 3.外部JS

1. 先创建一个`.js`文件

2. 在html中，通过以下方式引入js文件

   ```css
   <body>
   	 <script src="./js/05-运行js.js"></script>
   </body>
   ```

   

注意：在一个HTML文件中，可以使用多组`<script></script>`标签，因此内部的JS和外部的JS可以同时使用

```js
<body>
    <!-- 内部js -->
    <script>
    // js代码
    console.log(11);

</script>
<!-- 外部js -->
<script src="./js/05-运行js.js"></script>
</body>
```

### 4.运行js

在浏览器中，进入开发工具，选择console，就能看到代码运行的结果

![image-20250224141823192](https://woniumd.oss-cn-hangzhou.aliyuncs.com/web/dingling/20250224141823.png)