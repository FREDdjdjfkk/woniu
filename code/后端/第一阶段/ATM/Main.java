package ATM;


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void UI() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("d:\\user.txt"));


        DataUtils data =(DataUtils)objectInputStream.readObject();
//        DataUtils data=new DataUtils();
//        User user1=new User("user1","123",2000,1,1);
//        User admin=new User("admin","admin123",0,0,0);
//            data.users.add(user1);
//            data.users.add(admin);


        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("主界面:");
            System.out.println("选择你的身份: 1,管理员  2，普通用户  3,退出系统");
            int a=scanner.nextInt();
            switch (a) {
                case 1:
                    System.out.println("-------管理员登录------");
                    AdminUI adminUI=new AdminUI(data);
                    if (adminUI.adminlogin(data)) {
                        adminUI.selectservice();
                    }

                    break;
                case 2:
                    System.out.println("-------用户登录------");
                    UserUI userUI=new UserUI(data);
                    if (userUI.userlogin(data)){
                        userUI.selectservice(data);
                    }
                    break;
                case 3:
                    ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("d:\\user.txt"));
                    outputStream.writeObject(data);

                    outputStream.close();
                    objectInputStream.close();
                    System.exit(0);
                default:

                    System.out.println("错误输入，请重新输入");
            }
        }
    };
    public static void main(String[] args) throws IOException, ClassNotFoundException {
            UI();
    }
}
