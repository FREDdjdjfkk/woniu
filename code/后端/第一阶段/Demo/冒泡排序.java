package Demo;

import java.util.Scanner;

public class 冒泡排序 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        char[] a=new char[str.length()];
//        for (int i=0;i<str.length();i++){
//            a[i]=str.charAt(i);
//        }
        a=str.toCharArray();
//本质流程是第二层循环从n-1循环到0,外层循环只要保证使第二层循环条件满足就行
//        for(int i=0;i<str.length()-1;i++){
//            for (int j=0;j<str.length()-i-1;j++){
//                if (a[j+1]<a[j]){
//                    char temp=a[j];
//                    a[j]=a[j+1];
//                    a[j+1]=temp;
//                }
//            }
        for(int i=str.length()-1;i>0;i--){
            for (int j=0;j<i;j++) {
                if (a[j + 1] < a[j]) {

//                    char temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
                    //使用异或交换,使用前提：使用异或交换两个位置不能相同，否则异或为0
                    a[j]= (char) (a[j]^a[j+1]);
                    a[j+1]= (char) (a[j]^a[j+1]);
                    a[j]= (char) (a[j]^a[j+1]);
                }
            }

        }
        str=new String(a);
        System.out.println(str);
    }
}
