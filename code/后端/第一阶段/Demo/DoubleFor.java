package Demo;

import java.util.Scanner;

public class DoubleFor {
    public static void main(String[] args){
//        int c=0;
//        for(int a=0;a<=20;a++){
//            for(int b=0;b<=33;b++){
//                c=100-a-b;
//                if(15*a+9*b+c==300){
//                    System.out.println("公鸡买"+a+"只，母鸡买"+b+"只，小鸡买"+c+"只");
//                }
//            }
//        }

//        for (int i=2;i<101;i++){
//            boolean flag=true;
//            for (int j=2;j<=i/2;j++){
//                if(i%j==0){
//                    flag=false;
//                    break;
//                }
//            }
//            if (flag){
//                System.out.println(i);
//            }
//        }

//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        BigInteger sum= BigInteger.ZERO;
//
//        for (int i=1;i<=n;i++){
//            BigInteger x=BigInteger.ONE;
//            for(int j=1;j<=i;j++){
//                x=x.multiply(BigInteger.valueOf(j));
//            }
//            sum=sum.add(x);
//        }
//        System.out.println(sum);


        
        Scanner scanner=new Scanner(System.in);
        int[] a=new int[10];

        for(int i=0;i<a.length;i++){
            int temp=scanner.nextInt();
            if(temp<=200&&temp>=100){
                a[i]=temp;

            }else {
                System.out.println("请重新输入 ");
            }
        }

        int heigt=0;

        int temp=scanner.nextInt();
        if (temp<=120&&temp>=100){
            heigt=temp;
        }
        int count=0;
        //循环数组
        for (int i : a) {
            if (heigt+30>=i){
                count+=1;
            }
        }
        System.out.println(count);
        
    }
}
