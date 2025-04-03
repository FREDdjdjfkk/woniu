## ATM系统

主界面:

​	选择你的身份: 1,管理员  2，普通用户  3,退出系统

## 1,管理员界面

功能如下:

1.1 添加用户

​       自动回到管理员界面

1.2 删除用户

1.3 冻结用户

1.4 查看用户列表

1.5 回到主界面

## 2,普通用户界面

登录成功后获取当前用户信息

功能如下:

2.1 查看当前登录用户余额

   回到用户界面

2.2 存钱

2.3 取钱

2.4 转账

2.5 回到主界面



## 设计思路:

1，所有操作是围绕用户的

有两种用户   管理员   普通用户

User  :  用户名   密码   角色 (0 管理员  1普通用户)  余额  状态(0 冻结 1 正常)



2，围绕管理员设计业务接口  ManagerService

boolean addUser(User user);  

void deleteUser(String userName);

void dongjieUser(String userName);

void showUser();



3,编写管理员设计业务实现类  ManagerServiceImpl

boolean addUser(User user){

​		将对象在集合中做业务判断 , 用户如果已存在，返回错误信息

​		如果添加成功，返回提示信息

}

void deleteUser(String userName);

void dongjieUser(String userName);

void showUser();



4,管理员的表示层 ,控制台的输出信息以及数据的接收处理  ManagerShow

​	输出提示，接收输入的数据封装在对象中

String userName = in.nextLine();

String pwd = in.nextLine();

.....

User user = new User();

user.setUserName(userName);

//调用业务逻辑处理

service.add(user);





....普通用户的业务接口UserService，业务实现类UserServiceImpl，普通用户的展示类UserShow

  

设计共享集合数据  (DataUtils工具类  static List<User> users )



希望main方法只有一行代码

启动类ATMRun  run = new ATMRun();

run.start();  





一开始可以内置一个管理员和普通用户





























