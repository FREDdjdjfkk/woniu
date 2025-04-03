package ATM;

import java.util.Scanner;

public class AdminUI {
    private  DataUtils data;
    private Integer index = -1;

    public AdminUI(DataUtils data) {
        this.data = data;
    }

    Scanner scanner = new Scanner(System.in);

    Adminserviceimpl adminserviceimpl = new Adminserviceimpl(data);

    public boolean adminlogin(DataUtils data) {
        String username = scanner.next();
        String pwd = scanner.next();
        while (true) {

            index = data.getindex(username);
            if(index<0){
                System.out.println("该用户不存在");
                return false;
            }else if (!data.users.get(index).getPassword().equals(pwd)) {
                System.out.println("密码错误，请重新输入密码");
                pwd=scanner.next();
            } else if (data.users.get(index).getState() == 1) {
                System.out.println("没有管理员权限");
                break;
            } else {
                System.out.println("登录成功！");
                return true;
            }
        }
        return false;
    }

    public void selectservice() {
        while (true) {

            System.out.println("-----管理员界面------");
            System.out.println("1-添加用户  2-删除用户 3-冻结用户 4-查看用户列表 5-返回登陆页面");
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println("请输出新用户的用户名");
                    String name = scanner.next();
                    System.out.println("请输入新用户的密码");
                    String pwd = scanner.next();
                    User newuser = new User(name, pwd);
                    adminserviceimpl.addUser(newuser);
                    break;
                case 2:
                    System.out.println("请输入要删除的用户名");
                    name = scanner.next();
                    adminserviceimpl.deleteUser(name);
                    break;
                case 3:
                    System.out.println("请输入要冻结的用户名");
                    name = scanner.next();
                    adminserviceimpl.dongjieUser(name);
                    break;
                case 4:
                    adminserviceimpl.showUser();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("错误输入，请重新输入");
        }
        }
    }
}
