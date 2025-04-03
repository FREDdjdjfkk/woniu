package Demo;

import java.util.Arrays;
import java.util.Scanner;

public class Two_d_array {
    public static void main(String[] args) {
        String[] user1={"admin","123456"};
        String[] user2={"test","239611"};
        String[] user3={"user001","123123"};

        String[][] user={user1,user2,user3};


        for (String[] i:user
             ) {
            for (String j:i
            ){
                System.out.println(j);
            }
        }
        System.out.println("---------------------------------------------------");
        Scanner scanner=new Scanner(System.in);
        String username=scanner.nextLine();
        String userpwd=scanner.nextLine();
        String[] user4 ={username,userpwd};

//        String[][] Newuser=new String[user.length+1][];
//        for (int i = 0; i <user.length; i++) {
//            Newuser[i]=user[i];
//        }
        String[][] Newuser= Arrays.copyOf(user,4);
        Newuser[3]=user4;

        for (String[] i:Newuser
        ) {
            for (String j:i
            ){
                System.out.println(j);
            }
        }
        System.arraycopy(user,0,Newuser,0,3);
    }
}
