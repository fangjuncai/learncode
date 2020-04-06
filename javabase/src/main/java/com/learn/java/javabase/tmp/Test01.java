package com.learn.java.javabase.tmp;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test01 {
    public static void main(String[] args)
    {
        testArray01();
    }

    public static void testArray01(){
        Integer[] int1 = null;
        if(int1 !=null){
            System.out.println("len "+int1.length);
        }


        List<Integer> integers = Arrays.asList(10,6,0,1,2,3);
        integers.sort((o1, o2) -> o1-o2);
        int1 = (Integer[]) integers.toArray();
        System.out.println("len "+int1.length);
        for(int i = 0;i<int1.length;i++){
            System.out.println(int1[i]);
        }
    }


    private static void testSubstring(){
        String s ="012345";
        System.out.println(s.substring(1,4));
    }
    private static void test01(){
        System.out.println(1<<16);
        long startIpSegNum =142606336L>>16;

        //根据前两段ip 作为key
        long endIpSegNum=146800639L>>16;
        System.out.println(startIpSegNum);
        System.out.println(endIpSegNum);

        System.out.println(142606336L);

        System.out.println( (startIpSegNum+1 << 16) - 1);
        long tmpEndIp = ((startIpSegNum + 1) << 16) - 1;
        System.out.println(tmpEndIp);
        System.out.println(tmpEndIp>>16);
        System.out.println(tmpEndIp+1>>16);
    }

    public static void testBigInter(){
        System.out.println(Long.MAX_VALUE);
        BigInteger long1 =new BigInteger("19223372036854775807");
        BigInteger long2 =new BigInteger("29223372036854775807");
        System.out.println(long1);
        System.out.println(long1.toString());
        System.out.println(long1.compareTo(long2));
        System.out.println(long2.compareTo(long1));
    }

    public static void testCompare(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        arrayList.add(100);
        arrayList.add(201);
        arrayList.add(99);
        arrayList.add(10);
        arrayList.add(1000);

        Arrays.sort(a ,new MyComparator());
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2){
                    return -1;
                }
                else if(o1>o2){
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });

        arrayList.forEach(s-> System.out.println(s));


        for(int arr:a) {
            System.out.print(arr + " ");
        }
    }
}
class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1<o2){
            return -1;
        }
        else if(o1>o2){
            return 1;
        }
        else {
            return 0;
        }
    }
}
/*

                if(o1<o2){
                    return -1;
                }
                else if(o1>o2){
                    return 1;
                }
                else {
                    return 0;
                }
 */
