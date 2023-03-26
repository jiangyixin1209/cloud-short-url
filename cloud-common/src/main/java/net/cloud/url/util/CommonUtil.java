package net.cloud.url.util;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.security.MessageDigest;

/***
 * @title: CommonUtil
 * @description: 通用工具类
 * @auth: jiangyixin
 * @version: 1.0.0
 * @create: 2023/3/26 10:53
 **/
@Slf4j
public class CommonUtil {

    /**
     * MD5加密
     * @param data 待加密的字符出
     * @return md5字符串
     */
    public static String MD5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
            log.error("生成MD5异常:{0}", exception);
        }
        return null;

    }

    /**
     * 获取验证码随机数
     * @param length 验证码长度
     * @return 指定长度的验证码
     */
    public static String getRandomCode(int length) {

        String sources = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            sb.append(sources.charAt(random.nextInt(9)));
        }
        return sb.toString();
    }

    /**
     * 生成uuid
     * @return uuid 字符出
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

    private static final String ALL_CHAR_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 获取随机长度的串
     * @param length 随机船长度
     * @return 指定长度的随机字符串
     */
    public static String getStringNumRandom(int length) {
        //生成随机数字和字母,
        Random random = new Random();
        StringBuilder saltString = new StringBuilder(length);
        for (int i = 1; i <= length; ++i) {
            saltString.append(ALL_CHAR_NUM.charAt(random.nextInt(ALL_CHAR_NUM.length())));
        }
        return saltString.toString();
    }

}
