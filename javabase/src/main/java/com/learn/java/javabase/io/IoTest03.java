package com.learn.java.javabase.io;

/**
 * 测试文件读写
 * 测试ipv4转换成long
 */
public class IoTest03 {
    public static void main(String[] args) {

        test();
    }

    public static void test() {

        String ip = "39.135.2.131";
        String mask = "24";
        String netMask = getNetmask(mask);
        String lowerIp = getLowAddr(ip, netMask);
        String higherIp = getHighAddr(ip, netMask);
        System.out.println("--------------");
        System.out.println(1<<32-24);

        System.out.println("--------------");
        System.out.println(netMask);
        System.out.println(lowerIp);
        System.out.println(higherIp);
        System.out.println(ip2Shiftlong(lowerIp));
        System.out.println(ip2Shiftlong(higherIp));
        System.out.println("--------------");
        System.out.println(getStartIp("117.131.0.0/24"));
        System.out.println(getEndIp("117.131.0.0/24"));
        System.out.println("--------------");
        System.out.println(getStartIp("114.66.64.0/22"));
        System.out.println(getEndIp("114.66.64.0/22"));
        System.out.println("--------------");
        System.out.println(getStartIp("61.232.76.0/24"));
        System.out.println(getEndIp("61.232.76.0/24"));
        System.out.println("--------------");
        System.out.println(getStartIp("221.181.118.0/24"));
        System.out.println(getEndIp("221.181.118.0/24"));
    }

    /**
     * 根据掩码位数获取掩码
     */
    public static String getNetmask(String mask) {
        int inetMask = Integer.parseInt(mask);
        if (inetMask > 32) {
            return null;
        }
        //子网掩码为1占了几个字节
        int num1 = inetMask / 8;
        //子网掩码的补位位数
        int num2 = inetMask % 8;
        int array[] = new int[4];
        for (int i = 0; i < num1; i++) {
            array[i] = 255;
        }
        for (int i = num1; i < 4; i++) {
            array[i] = 0;
        }
        for (int i = 0; i < num2; num2--) {
            array[num1] += Math.pow(2, 8 - num2);
        }
        String netMask = array[0] + "." + array[1] + "." + array[2] + "." + array[3];
        return netMask;
    }

    public static String getLowAddr(String ipinfo, String netMask) {
        String lowAddr = "";
        int ipArray[] = new int[4];
        int netMaskArray[] = new int[4];
        if (4 != ipinfo.split("\\.").length || "" == netMask) {
            return null;
        }
        for (int i = 0; i < 4; i++) {
            try {
                ipArray[i] = Integer.parseInt(ipinfo.split("\\.")[i]);
            } catch (NumberFormatException e) {
                String ip = ipinfo.replaceAll("\n", "");
                ipArray[i] = Integer.parseInt(ip.split("\\.")[i]);
            }
            netMaskArray[i] = Integer.parseInt(netMask.split("\\.")[i]);
            if (ipArray[i] > 255 || ipArray[i] < 0 || netMaskArray[i] > 255 || netMaskArray[i] < 0) {
                return null;
            }
            ipArray[i] = ipArray[i] & netMaskArray[i];
        }
        //构造最小地址
        for (int i = 0; i < 4; i++) {
//            if(i == 3){
//                ipArray[i] = ipArray[i] + 1;
//            }
            if ("" == lowAddr) {
                lowAddr += ipArray[i];
            } else {
                lowAddr += "." + ipArray[i];
            }
        }
        return lowAddr;
    }

    public static String getHighAddr(String ipinfo, String netMask) {
        String lowAddr = getLowAddr(ipinfo, netMask);
        int hostNumber = getHostNumber(netMask);
        if ("" == lowAddr || hostNumber == 0) {
            return null;
        }
        int lowAddrArray[] = new int[4];
        for (int i = 0; i < 4; i++) {
            lowAddrArray[i] = Integer.parseInt(lowAddr.split("\\.")[i]);
//            if(i == 3){
//                lowAddrArray[i] = lowAddrArray[i] - 1;
//            }
        }
        //hostNumber是1024 256这种，因此需要减1达到补位与运算的效果
        lowAddrArray[3] = lowAddrArray[3] + (hostNumber - 1);
        if (lowAddrArray[3] > 255) {
            int k = lowAddrArray[3] / 256;
            lowAddrArray[3] = lowAddrArray[3] % 256;
            lowAddrArray[2] = lowAddrArray[2] + k;
        }
        if (lowAddrArray[2] > 255) {
            int j = lowAddrArray[2] / 256;
            lowAddrArray[2] = lowAddrArray[2] % 256;
            lowAddrArray[1] = lowAddrArray[1] + j;
            if (lowAddrArray[1] > 255) {
                int k = lowAddrArray[1] / 256;
                lowAddrArray[1] = lowAddrArray[1] % 256;
                lowAddrArray[0] = lowAddrArray[0] + k;
            }
        }
        String highAddr = "";
        for (int i = 0; i < 4; i++) {
//            if(i == 3){
//                lowAddrArray[i] = lowAddrArray[i] - 1;
//            }
            if ("" == highAddr) {
                highAddr = lowAddrArray[i] + "";
            } else {
                highAddr += "." + lowAddrArray[i];
            }
        }
        return highAddr;
    }

    public static long ip2long(String ip) {
        String[] ips = ip.split("[.]");
        long num = 16777216L * Long.parseLong(ips[0]) + 65536L
                * Long.parseLong(ips[1]) + 256 * Long.parseLong(ips[2])
                + Long.parseLong(ips[3]);
        return num;
    }

    //位移运算实现转换
    public static Long ip2Shiftlong(String ip) {
        Long ipLong = 0L;
        String[] ipNumbers = ip.split("\\.");
        for (String ipNumber : ipNumbers) {
            ipLong = ipLong << 8 | Integer.parseInt(ipNumber);
        }
        return ipLong;
    }

    public static int getHostNumber(String netMask) {
        int hostNumber = 0;
        int netMaskArray[] = new int[4];
        for (int i = 0; i < 4; i++) {
            netMaskArray[i] = Integer.parseInt(netMask.split("\\.")[i]);
            if (netMaskArray[i] < 255) {
                hostNumber = (int) (Math.pow(256, 3 - i) * (256 - netMaskArray[i]));
                break;
            }
        }
        return hostNumber;
    }

    public static int getHostNumber2(String netMask) {
        int hostNumber = 0;
        int netMaskArray[] = new int[4];
        for (int i = 0; i < 4; i++) {
            netMaskArray[i] = Integer.parseInt(netMask.split("\\.")[i]);
            //System.out.println("netMaskArray " + i + ""+netMaskArray[i]);
            if (netMaskArray[i] < 255) {
                hostNumber = (int) (Math.pow(256, 3 - i) * (256 - netMaskArray[i]));
                break;
            }
        }
        return hostNumber;
    }

    /**
     * 根据掩码位数计算掩码
     * @param maskIndex 掩码位
     * @return 子网掩码
     */
    public static String getNetMask(String maskIndex) {
        StringBuilder mask = new StringBuilder();
        Integer inetMask = 0;
        try {
            inetMask = Integer.parseInt(maskIndex);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }
        if (inetMask > 32) {
            return null;
        }
        // 子网掩码为1占了几个字节
        int num1 = inetMask / 8;
        // 子网掩码的补位位数
        int num2 = inetMask % 8;
        int array[] = new int[4];
        for (int i = 0; i < num1; i++) {
            array[i] = 255;
        }
        for (int i = num1; i < 4; i++) {
            array[i] = 0;
        }
        for (int i = 0; i < num2; num2--) {
            array[num1] += 1 << 8 - num2;
        }
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                mask.append(array[i]);
            } else {
                mask.append(array[i] + ".");
            }
        }
        return mask.toString();
    }

    /**
     * 根据网段计算起始IP 网段格式:x.x.x.x/x
     * 一个网段0一般为网络地址,255一般为广播地址.//在此为了更广的兼容0也是有效地址
     * 起始IP计算:网段与掩码相与之后加一的IP地址
     * @param segment  网段
     * @return 起始IP
     */
    public static String getStartIp(String segment) {
        StringBuffer startIp = new StringBuffer();
        if (segment == null) {
            return null;
        }
        String arr[] = segment.split("/");
        String ip = arr[0];
        String maskIndex = arr[1];
        String mask = getNetMask(maskIndex);
        if (4 != ip.split("\\.").length || mask == null) {
            return null;
        }
        int ipArray[] = new int[4];
        int netMaskArray[] = new int[4];
        for (int i = 0; i < 4; i++) {
            try {
                ipArray[i] = Integer.parseInt(ip.split("\\.")[i]);
                netMaskArray[i] = Integer.parseInt(mask.split("\\.")[i]);
                if (ipArray[i] > 255 || ipArray[i] < 0 || netMaskArray[i] > 255 || netMaskArray[i] < 0) {
                    return null;
                }
                //每段掩码与每段ip与运算
                ipArray[i] = ipArray[i] & netMaskArray[i];
                if(i==3){
                    //startIp.append(ipArray[i]+1);
                    startIp.append(ipArray[i]);
                }else{
                    startIp.append(ipArray[i]+".");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return startIp.toString();
    }

    /**
     * 根据网段计算结束IP
     * @param segment
     * @return 结束IP
     */
    public static String getEndIp(String segment) {
        StringBuffer endIp=new StringBuffer();
        String startIp = getStartIp(segment);
        if (segment == null) {
            return null;
        }
        String arr[] = segment.split("/");
        String maskIndex = arr[1];
        //实际需要的IP个数
        int hostNumber = 0;
        int startIpArray[] = new int[4];
        try {
            //值1024  256这样的值

            hostNumber=1<<32-(Integer.parseInt(maskIndex));
            System.out.println("hostNumber="+hostNumber);
            for (int i = 0; i <4; i++) {
                startIpArray[i] = Integer.parseInt(startIp.split("\\.")[i]);
                if(i == 3){
                    //算类似与N100000000开始了，上文因为+1，所以又减1
                    //startIpArray[i] = startIpArray[i] - 1;
                    //最地位也算有效地址
                    startIpArray[i] = startIpArray[i];
                    break;
                }
            }
            //等同于起始ip与掩码的补位取与运算，也就是相加
            //不算最高位，也就是类似111111111地址是不考虑的
            startIpArray[3] = startIpArray[3] + (hostNumber - 1);
            //startIpArray[3] = startIpArray[3] + hostNumber;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        if(startIpArray[3] >255){
            int k = startIpArray[3] / 256;
            startIpArray[3] = startIpArray[3] % 256;
            startIpArray[2] = startIpArray[2] + k;
        }
        if(startIpArray[2] > 255){
            int  j = startIpArray[2] / 256;
            startIpArray[2] = startIpArray[2] % 256;
            startIpArray[1] = startIpArray[1] + j;
            if(startIpArray[1] > 255){
                int  k = startIpArray[1] / 256;
                startIpArray[1] = startIpArray[1] % 256;
                startIpArray[0] = startIpArray[0] + k;
            }
        }
        for(int i = 0; i < 4; i++){
            /*if(i == 3){
                startIpArray[i] = startIpArray[i] - 1;
            }*/
            if("" == endIp.toString()||endIp.length()==0){
                endIp.append(startIpArray[i]);
            }else{
                endIp.append("." + startIpArray[i]);
            }
        }
        return endIp.toString();
    }

}
