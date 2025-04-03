package Homework;

import java.util.Scanner;
public class Homework_2 {

    public static void main(String[] args) {

//        Scanner scanner=new Scanner(System.in);
//        String string=scanner.nextLine();
//        char[] a= new char[string.length()];
//        for(int i=0;i<string.length();i++){
//            a[i]=string.charAt(i);
//            if((string.charAt(i)>='a')&&(string.charAt(i)<='z') ){
//                a[i]= (char)(string.charAt(i)-32);
//            }
//        }
//        for(int i=0;i<string.length();i++){
//            string=new String(a);
//        }
//        System.out.print(string);

        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner1.nextInt();
        int min = a>b?b:a;
        boolean flag=true;
//        if(a>b){
//            min=b;
//        }
        while(flag){
            if ((a%min==0)&(b%min==0)){
                flag=false;
                break;
            }
            min--;
        }
        System.out.println("最大公约数："+min);
        //每天没吃前的桃子;a1 a2=a1/2-1 a1=
//        int[] a = new int[10];
//        a[9] = 1;
//        int i = 9;
//        while (i > 0) {
//            a[i-1] = 2 * a[i] + 2;
//            i--;
//        }
//        System.out.println("第一天有"+a[0]+"个桃子");

    }


}
