package com.wjw;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

@SpringBootTest
class SpringBootLayuiApplicationTests {

    @Test
    void contextLoads() throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//
//        // java自带工具包MessageDigest
//        String resultString = MD5Utils.stringToMD5("Wei@0212.com");
//        System.out.println(resultString);
//        // e10adc3949ba59abbe56e057f20f883e
//        String resultString1 = MD5Utils.stringToMD5("1234");
//        System.out.println(resultString1);
//        //81dc9bdb52d04dc20036dbd8313ed055
//
//        // spring自带工具包DigestUtils
//        System.out.println(DigestUtils.md5DigestAsHex("1234".getBytes()));
//        // 81dc9bdb52d04dc20036dbd8313ed055

        String regex = "^(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-7|9])|(?:5[0-3|5-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[1|8|9]))\\d{8}$";
        String regex2 = "^\\d{3}-\\d{8}$|^\\d{4}-\\d{7}$";
        System.out.println((Pattern.matches(regex2, "010-63699339")) || Pattern.matches(regex, "1508106443"));
    }
}