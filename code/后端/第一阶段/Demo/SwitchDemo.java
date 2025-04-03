package Demo;

import java.util.Scanner;
public class SwitchDemo {
    public static void main(String[] args){

        System.out.println("请输入月份");
        Scanner scanner=new Scanner(System.in);
        int month=scanner.nextInt();
        switch (month){
            case 1:
                System.out.println("有31天");
                break;

            case 2:
                System.out.println("请输入年份");
                scanner=new Scanner(System.in);
                int year=scanner.nextInt();
                if (year%4==0&&year%100!=0||year%400==0){
                    System.out.println("有29天");
                }else {
                    System.out.println("有28天");
                }
                break;
            case 3:
                System.out.println("有31天");
                break;
            case 4:
                System.out.println("有30天");
                break;
            case 5:
                System.out.println("有31天");
                break;
            case 6:
                System.out.println("有30天");
                break;
            case 7:
                System.out.println("有31天");
                break;
            case 8:
                System.out.println("有31天");
                break;
            case 9:
                System.out.println("有30天");
                break;
            case 10:
                System.out.println("有31天");
                break;
            case 11:
                System.out.println("有30天");
                break;
            case 12:
                System.out.println("有31天");
                break;

        }
    }
}
