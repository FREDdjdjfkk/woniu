package Demo;

import java.util.Scanner;
public class ForDemo {
    public static void main(String[] args){
//        int[] a= new int[5];
//        for (int i=0;i<5;i++){
//            Scanner scanner=new Scanner(System.in);
//            a[i]=scanner.nextInt();
//        }
//        int max=a[0];
//        for(int i=0;i<5;i++){
//            if (a[i]>max){
//                max=a[i];
//            }
//        }
//        System.out.println("最大数字是："+max);
        Scanner scanner = new Scanner(System.in);
        int a=0;
        boolean flag= true;
        a=scanner.nextInt();
        for (int i=2;i<a/2;i++){
            if(a%i==0){
                flag=false;
                break;
            }
        }
        if (flag){
            System.out.println(a+"是质数");
        }else{
            System.out.println(a+"不是质数");
        }
    }
}
