package com.wn.util;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;

import java.util.Random;

/**
 * 测试发送验证码服务
 */
public class SendSMSUtil {

    /**
     * 通过 AccessKeyId和AccessKeySecret来创建Client
     */
    public static Client createClient() throws Exception {
        Config config = new Config()
                //修改为自己的AccessKeyId
                .setAccessKeyId("")
                //填写自己的AccessKeySecret
                .setAccessKeySecret("");
        //参数不变
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }

    /**
     * 随机产生6个验证码
     */
    public static String randomCode(){
        //定义数组，保存验证码随机数值
        int[] arr = {1,2,3,4,5,6,7,8,9};

        StringBuilder codesb = new StringBuilder();
        Random random = new Random();
        //通过循环控制验证码产生
        for(int i = 0;i < 6;i++){
            codesb.append( arr[random.nextInt(arr.length)]);
        }
        return codesb.toString();
    }

    /**
     * 发送验证码方法
     * @param phone  手机号码
     * @param code     验证码（6位验证码数字）
     * @param signName  签名名称
     * @param templateCode     模版Code
     */
    private static String sendSMSMessage(String phone,String code,String signName,String templateCode) throws Exception {
        Client client = SendSMSUtil.createClient();
        //获取随机验证码
        SendSmsRequest send = new SendSmsRequest()
                //绑定的测试手机号码
                .setPhoneNumbers(phone)
                //阿里云提供测试签名名称(注意:测试不能修改。如果真实开发需要修改为企业申请的签名名称)
                .setSignName(signName)  //"阿里云短信测试"
                //测试模版(注意:填写自己测试模版，实际开发也需要申请之后使用)
                .setTemplateCode(templateCode)//"SMS_154950909"
                //发送的验证码必须用户如下格式
                .setTemplateParam("{\"code\":\""+ code +"\"}");

        RuntimeOptions options = new RuntimeOptions();
        SendSmsResponse response = client.sendSmsWithOptions(send, options);
        //发送验证码
        return response.getBody().code;
    }

    public static void main(String[] args) throws Exception {

        String msg = sendSMSMessage("18868025643", randomCode(), "阿里云短信测试", "SMS_154950909");
        System.out.println(msg);


    }
}
