package com.mis.kill.utils;


import org.apache.commons.codec.digest.DigestUtils;

import static java.lang.System.out;

/**
 * @Author Li HuiKun
 * @Date 2022/7/21 15:06
 **/
public class MD5Util {

    public  static  String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1abc2asd";


    public static String inputPassToFromPass(String inputPass){
        String str = salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(4);
        return md5(str);
    }
    public static String formPassToDBPass(String formPass){
        String str = salt.charAt(1)+salt.charAt(3)+formPass+salt.charAt(5);
        return md5(str);
    }
    public static String inputPassToDBPass(String inputPass){
        String formPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(formPass);

        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println();

    }



}
