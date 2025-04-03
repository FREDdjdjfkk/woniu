package Demo;

import java.util.Scanner;

public class UserRegister {
    public static void main(String[] args) {
        String username=new String();
        Scanner scanner=new Scanner(System.in);
        username=scanner.next();
        String regex="^[A-Za-z0-9]{6,9}$";
        System.out.println(username.matches(regex));
        String pwd=new String(scanner.next());
        String regex1="^[A-Z]*";
        System.out.println(pwd.matches(regex1));
        String email=new String(scanner.next());
        regex="^[A-Za-z0-9]*@.+\\.com";
        System.out.println(email.matches(regex));
    }
}
