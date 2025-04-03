package com.lpc.View;

import com.lpc.pojo.Users;
import com.lpc.controller.UserController;
import com.lpc.util.SendSMSUtil;

import java.util.Scanner;

/**
 * 系统主页面
 */
public class MainFrameView {
    private static Scanner scan = new Scanner(System.in);
    private static UserController userController = new UserController();
    /**
     * 显示系统首页信息
     */
    public static void showFrameMessage() throws Exception {
        boolean isLoop = true;
        while(isLoop){
            System.out.println("********欢迎进入XXX系统首页*************");
            System.out.println("********1.登  录*************");
            System.out.println("********2.注  册*************");
            System.out.println("********3.退  出*************");
            System.out.println("*********************");
            System.out.println("*********请选择输入:************");
            int num = scan.nextInt();
            if(num == 1){
                loginShowMseeage();
            }else if(num == 2){

            }else if(num == 3){
                isLoop = false; //结束循环
            }else {
                System.out.println("输入有误，请重新选择....");
            }
        }
    }
    /**
     * 用户登录操纵方法
     */
    public static void loginShowMseeage() throws Exception {
        System.out.println("********1.用户名登录*************");
        System.out.println("********2.短信验证*************");
        System.out.println("*********请选择输入:************");
        int num = scan.nextInt();
        switch (num){
            case 1:
                //调用对应方法实现

                break;
            case 2:
                //短信验证码登录
                codeLogin();
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }
    /**
     * 短信验证码登录方法
     */
    public static void codeLogin() throws Exception {
        System.out.println("请输入手机号码:");
        String telphone = scan.next();
//        //随机生成验证码
//        String code = SendSMSUtil.randomCode();
//        System.out.println(code);
//        //调用对应工具类方法实现发送验证码
//        SendSMSUtil.sendSMSMessage(telphone, code, "阿里云短信测试", "SMS_154950909");
//        //用户输入验证码
//        System.out.println("请输入验证码:");
//        String inputCode = scan.next();
        //根据手机号码查询 指定用户信息
        Users users = userController.selectByTelphone(telphone);

        //判断用户是否登录成功
        if(users != null/* && inputCode.equals(code)*/){
            toPageView(users);
        }else {
            System.out.println("你输入手机号码或验证码错误");
        }
    }
    /**
     * 根据用户权限跳转相应页面
     */
    public static void toPageView(Users users) throws Exception {
        //获取用户权限号
        Integer powerId = users.getPower_id();
        switch (powerId){
            case 1:
                //跳转用户页面
                NormalUserView.showUsersMessage(users);
                break;
            case 2:
                //跳转商家页面
                break;
            case 3:
                //跳转管理员页面
                break;

        }
    }
}
