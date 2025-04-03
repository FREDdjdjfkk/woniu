package Demo;
import java.util.Scanner;
public class DemoIf {
    public static void main (String[] args) {
/*        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入你的分数");
        int score = scanner.nextInt();
        if (score>=0&&score<=100){
            if (score>=90){
                System.out.println("优秀");
            }else if (score>=70){
                System.out.println("良");
            } else if (score>=60) {
                System.out.println("及格");
            }else {
                System.out.println("不及格");
            }
        }else {
            System.out.println("非法输入");
        }*/

        Scanner scanner =new Scanner(System.in);
        System.out.println("输入年份：");
        int year= scanner.nextInt();
        if (year%4==0&&year%100!=0||year%400==0){
            System.out.println(year+"是闰年");
        }else {
            System.out.println(year+"不是闰年");
        }
    }
}
