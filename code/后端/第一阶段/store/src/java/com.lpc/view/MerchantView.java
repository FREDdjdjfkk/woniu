package com.lpc.View;

import java.util.Scanner;

public class MerchantView {
    private static Scanner scan = new Scanner(System.in);
    public static void shouMerchant(){


        boolean isLoop = true;
        while (isLoop) {
            System.out.println("********欢迎进入商家首页*************");
            System.out.println("********1.上架商品*************");
            System.out.println("********2.订单管理*************");//++根据商品编号查找商品
            System.out.println("********3.库存管理*************");
            System.out.println("********4.数据统计*************");
            System.out.println("********5.退   出*************");
            System.out.println("*********************");
            System.out.println("*********请选择输入:************");
            int num = scan.nextInt();



        }
    }
}
