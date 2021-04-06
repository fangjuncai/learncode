package com.learn.java.javabase.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-01 17:15
 **/
public class Test {
    final static int a = 100;

    public static void main(String[] args) {
        testFiles();

    }

    private static void testFiles() {
        Path path = Paths.get("D:\\my\\code\\github\\learncode\\javabase\\data\\leecode.md");
        if (Files.isReadable(path)) {
            try {
                BufferedReader bufferedReader = Files.newBufferedReader(path);
                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testChar() {
        String str = "01234*5";
        for (int i = 1; i <= str.length(); i++) {
            if (str.charAt(i - 1) == '*') {
                System.out.println(str.charAt(i - 1));
            }

        }
    }

    private static void tasetUri() {
        URI uri = null;
        try {
            //uri = new URI("203.107.1.65/107025/sign_d?host=valipl.cp31.ott.cibntv.net&sdk=android_1.2.5&t=1614234404&s=994758ecd306b6bfc7007dfdffa35075&sid=KChUEMP0yWcC&net=wifi&bssid=fc%3Af2%3A9f%3A5d%3A18%3A5e");
            uri = new URI("120.92.215.64/e?dn=js2.a.yximgs.com");
            //uri = new URI("203.107.1.66/191607/resolve?host=api.bilibili.com");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        String host = uri.getHost();// 获取主机名


        System.out.println("Authority = " + uri.getAuthority());
        System.out.println("Fragment = " + uri.getFragment());
        System.out.println("Host = " + uri.getHost());
        System.out.println("Path = " + uri.getPath());
        System.out.println("Port = " + uri.getPort());
        System.out.println("Query = " + uri.getQuery());
        System.out.println("Scheme = " + uri.getScheme());
        System.out.println("Scheme-specific part = " +
                uri.getSchemeSpecificPart());
        System.out.println("User Info = " + uri.getUserInfo());
        System.out.println("URI is absolute: " + uri.isAbsolute());
        System.out.println("URI is opaque: " + uri.isOpaque());
    }
}
