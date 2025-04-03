package Homework;

import java.util.Arrays;

public  class Homework_3 {
    public static int[]  getAvg(int[] a){
        int sum=0;
        int[] result=new int[2];
        for (int i:a
             ) {
            sum+=i;
        }
        result[0]=sum/a.length;
        for (int i:a
             ) {
            if (result[0]<i){
                result[1]++;
            }
        }
        return result;
    }

    public static boolean equals(int[] a,int[] b){
        boolean flag=true;

        while (flag) {
            if (a.length==b.length) {
                for (int i = 0; i <a.length ; i++) {
                   if (a[i]!=b[i]){
                       flag=false;
                   }
                }
                return flag;
            } else {
                System.out.println("两个数组不相等");
                flag=false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] a={95, 92, 75, 56, 98, 71, 80, 58, 91, 91};
//        int[] result=getAvg(a);
//        System.out.println("高于平均分："+result[0]+"的个数有"+result[1]+"个");

        int[] a={1,2,3,4,3,2,1};
        int[] b={1,2,3,4,3,2,1};

        boolean flag=equals(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println("是否一致："+flag);
    }
}
