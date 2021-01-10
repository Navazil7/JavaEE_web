package cn.zm.trip.web.commons;

import java.util.Random;
import java.util.UUID;

public class CodeUtil {
    //生成唯一的激活码
    public static String generateUniqueCode(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    //生成六位数验证码
    public static String generateSixCode(){
        String Captcha = String.valueOf(new Random().nextInt(899999) + 100000);
        return Captcha;
    }
}