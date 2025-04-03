package Demo;
import java.util.Scanner;
public class Arrylist {
    public static void main(String[] args){
//        String[] str=new String[5];
//        Scanner scanner=new Scanner(System.in);
//        for (int i=0;i< str.length;i++){
//
//            str[i]=scanner.nextLine();
//        }
//        for (int i=0;i<5;i++){
//            System.out.println(str[i]);
//        }

        for (int i=2;i<101;i++){
            boolean flag=true;
            for (int j=2;j<i/2;j++){
                if (i%j==0){
                    flag=false;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }
}
