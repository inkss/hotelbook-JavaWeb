package com.inks.hb.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5Test {
    private MD5 md5 = new MD5();

    @Test
    public void checkMD5() {
        String a = md5.getMD5("toor");
        System.out.println(a);
        System.out.println(md5.checkMD5("toor",a));
    }
}