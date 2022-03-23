package com.inks.hb.common;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MD5 {

    public String getMD5(String str) {
        String Salt = "mH8yhBL-n*j-2gmC" + str;
        return Base64.getEncoder().encodeToString(Salt.getBytes(StandardCharsets.UTF_8));
    }

    public boolean checkMD5(String newStr, String oldStr) {
        return getMD5(newStr).equals(oldStr);
    }

    public static void main(String[] args) {
        MD5 md5 = new MD5();
        System.out.println(md5.getMD5("toor"));
    }
}

