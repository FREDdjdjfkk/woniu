package ATM;

import java.util.Scanner;


public class UserUI {
    private Integer index=0;
    private DataUtils data;

    public UserUI(DataUtils data) {
        this.data = data;
    }

    Scanner scanner=new Scanner(System.in);
    Userserverceimpl userserverceimpl=new Userserverceimpl(data);
    public boolean userlogin(DataUtils data) {
        String username=scanner.next();
        String pwd=scanner.next();

         index=data.getindex(username);
        while (true) {

            index = data.getindex(username);
            if(index<0){
                System.out.println("该用户不存在");
                return false;
            }else if (!data.users.get(index).getPassword().equals(pwd)) {
                System.out.println("密码错误，请重新输入密码");
                pwd=scanner.next();
            } else if (data.users.get(index).getState() == 0) {
                System.out.println("账户类型错误");
                break;
            } else {
                System.out.println("登录成功！");
                return true;
            }
        }
            return false;
    }
    public void selectservice(DataUtils dataUtils){

        while (true) {
            System.out.println("-----用户界面------");
            System.out.println("1-查看当前登录用户余额  2-存款 3-取款 4-转账 5-返回登陆页面");
            int i=scanner.nextInt();
            switch (i){
                case 1:
                    userserverceimpl.Select(index);
                    break;
                case 2:
                    System.out.println("请输入存款金额");
                    int money=scanner.nextInt();
                    System.out.println(userserverceimpl.savemoney(index,money));
                    break;
                case 3:
                    System.out.println("请输入存款金额");
                     money=scanner.nextInt();
                    System.out.println(userserverceimpl.takemoney( index, money) );
                    break;
                case 4:
                    System.out.println("请输入转账对象");
                    String name=scanner.next();
                    int dctindex= dataUtils.getindex(name);
                    System.out.println("请输入转账金额");
                    money=scanner.nextInt();
                    System.out.println(userserverceimpl.movemoney(index,dctindex,money));
                    break;
                case 5:
                    return;
                default:
                    System.out.println("错误输入，请重新输入");
            }
        }
    }



}
