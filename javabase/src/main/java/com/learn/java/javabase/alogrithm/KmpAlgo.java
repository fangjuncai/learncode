package com.learn.java.javabase.alogrithm;

/**
 * @description
 * @author: fangjc
 * 没有优化
 * https://blog.51cto.com/acevi/2104820
 * https://blog.csdn.net/yuangan1529/article/details/80310702
 * @create: 2021-02-28 21:41
 **/

public class KmpAlgo {
    //寻找待匹配串的部分匹配值，放在next数组中
    static void getNext(String pattern,int[] next){
        int j = 0;
        int k = -1;
        next[0] = -1;
        int len = pattern.length();
        while(j < len-1){
            //if(k == -1 || pattern.charAt(j) == pattern.charAt(j)){ 写法应该不对
            if(k == -1 || pattern.charAt(j) == pattern.charAt(k)){
                j++;
                k++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }

    }

    /*
     *  返回模式串pattern改进的next数组
     */
    private static int[] getNext(String pattern) {
        int j = 0, k = -1, next[] = new int[pattern.length()];
        next[0] = -1;
        while (j < pattern.length() - 1)
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                j++;
                k++;
                if (pattern.charAt(j) != pattern.charAt(k)) // 改进之处
                    next[j] = k;
                else
                    next[j] = next[k];
            } else
                k = next[k];
        return next;
    }

        static int kmp(String s,String pattern){
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();
        int[] next = new int[plen];
        getNext(pattern,next);
            //next=getNext(pattern);
        for(int m=0;m<next.length;m++)
        {
            System.out.print("--"+next[m]);
            System.out.println("");
        }
        while(i < slen && j < plen){
            if(s.charAt(i) == pattern.charAt(j)){
                i++;
                j++;

            }else if(next[j] == -1){
                i++;
                j = 0;
            }else{
                j = next[j];
            }
            if(j == plen){
                return i-j;
            }
        }
        return -1;

    }
    /**
     *@param
     */
    public static void main(String[] args){
        //String str = "203.107.1.66/191607/resolve?host=upos-sz-mirrorcosb.bilivideo.com&query=4%2C6";
//        String str = "203.107.1.66/191607/resolve?host=upos-sz-mirrorcosb.bilivideo.com";
//        String pat = "?host";
        String str = "bbcabcdababcdabcdabde";
        String pat = "abcdabd";
        //KmpAlgo.kmp(str, pat);
        int index =KmpAlgo.kmp(str, pat);
        if(index!=-1)
        {
            System.out.println(index);
            String hostStr = str.substring(index);
            System.out.println(hostStr);
            int  endIndex =hostStr.indexOf("&");
            System.out.println(endIndex);
            if (endIndex != -1) {
                System.out.println(hostStr.substring(0,endIndex));
            }else{
                endIndex=hostStr.length();
                System.out.println(hostStr.substring(0,endIndex));
            }


        }

    }

}
