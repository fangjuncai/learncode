package com.learn.java.javabase.leecode;

import com.learn.java.javabase.io.csvipconvert.Ipv4ConvertOpePro;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description
 * @author: fangjc 正则表达式
 * @create: 2021-03-14 20:16
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 **/
public class IsMatch {
    public static String regex = ".*\\?(dn=|host=|host_key=)";


    public static void main(String[] args) {
        testUriDns();

    }
    public static void testUriDns(){
        List<String> uris = Ipv4ConvertOpePro.importCsv(new File("D:\\my\\code\\github\\learncode\\javabase\\data\\dns.txt"));
        List<String> uriDnsUrls = testPattern(uris);
        System.out.println(uriDnsUrls);
        System.out.println(uriDnsUrls.size());
    }

    public static void testPattern() {

        List<String> uris = Ipv4ConvertOpePro.importCsv(new File("D:\\my\\code\\github\\learncode\\javabase\\data\\dns.txt"));
        //String regex = ".*resolve\\?.*(dn=|host=|host_key=)";
        //String regex = ".*\\?.*(dn=|host=|host_key=)";
        //String regex = ".*\\?(dn=|host=|host_key=)";
        //String regex = ".*\\?.*dn=.*";
        Long count = 0L;

        for (String uri : uris) {
            //String regex = ".*resolve\\?.*dn=.*(?=\\&*)";
            //str = "180.76.76.200/v3/resolve?XXdn=config.zybang.com&account_id=161229&t=1611556811&sign=ae87feb8f34eec84c969ab95c83f8f81";

            //String regex = ".*resolve\\?.*dn=.*";
            Pattern pattern = Pattern.compile(regex);
            //if (Pattern.matches(regex, str)) {
            String dnsUrl = null;
            Matcher matcher = pattern.matcher(uri);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                //System.out.println(start);
                //System.out.println(end);
                try {
                    String subString = uri.substring(matcher.end(), uri.length());
                    if (subString.contains(".")) {
                        if (subString.contains("&")) {
                            int index = subString.indexOf("&");
                            dnsUrl = uri.substring(matcher.end(), index + end);
                        } else if (subString.contains("%")) {
                            int index = subString.indexOf("%");
                            dnsUrl = uri.substring(matcher.end(), index + end);
                        } else {
                            dnsUrl = uri.substring(matcher.end(), uri.length());
                        }
                        System.out.println(dnsUrl);
                        count++;
                    }

                } catch (Throwable t1) {
                    System.out.println(uri);
                }
            }
        }
        System.out.println(count);
    }

    public static List<String> testPattern(List<String> list) {
        List<String> res = new ArrayList<>();
        for (String uri : list) {
            String uriDnsRes = resolveUriDns(uri);
            if (uriDnsRes != null) {
                res.add(uriDnsRes);
            }
        }
        return res;

    }

    public static String resolveUriDns(String uri) {

        Pattern pattern = Pattern.compile(regex);
        String dnsUrl = null;
        Matcher matcher = pattern.matcher(uri);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            try {
                String subString = uri.substring(matcher.end(), uri.length());
                if (subString.contains(".")) {
                    if (subString.contains("&")) {
                        int index = subString.indexOf("&");
                        dnsUrl = uri.substring(matcher.end(), index + end);
                    } else if (subString.contains("%")) {
                        int index = subString.indexOf("%");
                        dnsUrl = uri.substring(matcher.end(), index + end);
                    } else {
                        dnsUrl = uri.substring(matcher.end(), uri.length());
                    }
                }

            } catch (Throwable t1) {
                System.out.println(uri);
            }
        }
        return dnsUrl;
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
