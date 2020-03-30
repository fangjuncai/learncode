package com.learn.java.javabase.io.csvipconvert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ipv4ConvertOpePro {
    private static List<String> dataList = new ArrayList<>();

    public static void main(String[] args) {
        saveIps();
    }

    //输出为txt
    public static void saveIps() {
        List<IpProOpeInfo> ipProOpeInfoList = getIpProOpeInfoList();
        List<String> dataList = new ArrayList<>();
        Collections.sort(ipProOpeInfoList, new Comparator<IpProOpeInfo>() {
            @Override
            public int compare(IpProOpeInfo o1, IpProOpeInfo o2) {
                return Long.valueOf(o1.getStartIp()).compareTo(Long.valueOf(o2.getStartIp()));
                //下面的比较没有达到排序的目的，没有保持一致性升序或者降序，不够健壮
//                if(o1.getStartIp()-o2.getStartIp()>0){
//                    return 0;
//                }
//                else {
//                    return 1;
//                }
            }
        });
        for (IpProOpeInfo ipProOpeInfo : ipProOpeInfoList) {
            String ipinfo = ipProOpeInfo.getStartIp() + "|" + ipProOpeInfo.getEndIp() + "|" + ipProOpeInfo.getProvence() + "|" + ipProOpeInfo.getOperator();
            dataList.add(ipinfo);
        }
        //输出转换后的operator_prov_opt_info
        exportFile(new File("C:\\Users\\juncai\\Desktop\\init_operator_prov_opt_info.txt"), dataList);
    }

    //将ip信息排序
    public static void sortIpranges(List<IpProOpeInfo> lsit) {
        Collections.sort(lsit, new Comparator<IpProOpeInfo>() {
            @Override
            public int compare(IpProOpeInfo o1, IpProOpeInfo o2) {
                if (o1.getStartIp() - o2.getStartIp() > 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

    //转为起始ip对象列表
    public static List<IpProOpeInfo> getIpProOpeInfoList() {
        List<IpProOpeInfo> ipProOpeInfoList = new ArrayList<>();
        List<IpCsvInfo> ipList = datasConvertIpInfo();
        for (IpCsvInfo ipCsvInfo : ipList) {
            IpProOpeInfo ipProOpeInfo = new IpProOpeInfo();
            //System.out.println(ipInfo.toString());
            String segment = ipCsvInfo.getIprange() + "/" + ipCsvInfo.getMaskNum();
            String startIp = getStartIp(segment);
            String endIp = getEndIp(segment);

            long segmentIpL = ip2Shiftlong(ipCsvInfo.getIprange());
            long startIpL = ip2Shiftlong(startIp);
            long endIpL = ip2Shiftlong(endIp);
            if (segmentIpL > startIpL) {
                System.out.println("!-------!");
                System.out.println(ipCsvInfo.getIprange()+"/"+ ipCsvInfo.getMaskNum()+ " segment err");
            }
            else{
                ipProOpeInfo.setStartIp(startIpL);
                ipProOpeInfo.setEndIp(endIpL);

                ipProOpeInfo.setProvence("21");
                ipProOpeInfo.setOperator("1");
                ipProOpeInfoList.add(ipProOpeInfo);
            }

        }
        return ipProOpeInfoList;
    }

    //读取csv文件中的二进制,转为对象
    public static List<IpCsvInfo> datasConvertIpInfo() {
        List<IpCsvInfo> infoList = new ArrayList<>();
        dataList = importCsv(new File("C:\\Users\\juncai\\Desktop\\initipv4.csv"));
        for (String data : dataList) {
            if (!data.contains(":")) {
                String[] dataArrs = data.split(",");
                IpCsvInfo ipCsvInfo = new IpCsvInfo();
                ipCsvInfo.setIprange(dataArrs[0]);
                ipCsvInfo.setMaskNum(dataArrs[1]);
                infoList.add(ipCsvInfo);

            }

        }
        return infoList;
    }


    //暴力的long按照ip段计算
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
     * 导入
     *
     * @param file csv文件(路径+文件)
     * @return
     */
    public static List<String> importCsv(File file) {
        List<String> dataList = new ArrayList<String>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        } catch (Exception e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }

    /**
     * 导出
     *
     * @param file     File文件(路径+文件名)，File文件不存在会自动创建
     * @param dataList 数据
     * @return
     */
    public static boolean exportFile(File file, List<String> dataList) {
        boolean isSucess = false;

        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out);
            bw = new BufferedWriter(osw);
            if (dataList != null && !dataList.isEmpty()) {
                for (String data : dataList) {
                    bw.append(data).append("\r");
                }
            }
            isSucess = true;
        } catch (Exception e) {
            isSucess = false;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                    bw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                    osw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                    out = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

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
     * 一个网段0一般为网络地址,255一般为广播地址.当前为了更广的兼容，0 255也是有效地址
     * 起始IP计算:网段与掩码相与之后加一的IP地址
     *
     * @param segment 网段
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
                if (i == 3) {
                    //startIp.append(ipArray[i]+1);
                    startIp.append(ipArray[i]);
                } else {
                    startIp.append(ipArray[i] + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return startIp.toString();
    }

    /**
     * 根据网段计算结束IP
     *
     * @param segment
     * @return 结束IP
     */
    public static String getEndIp(String segment) {
        StringBuffer endIp = new StringBuffer();
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
            hostNumber = 1 << 32 - (Integer.parseInt(maskIndex));
            for (int i = 0; i < 4; i++) {
                startIpArray[i] = Integer.parseInt(startIp.split("\\.")[i]);
                if (i == 3) {
                    //算类似与N100000000开始了，上文因为+1，所以又减1
                    //startIpArray[i] = startIpArray[i] - 1;
                    //最地位也算有效地址
                    startIpArray[i] = startIpArray[i];
                    break;
                }
            }
            //等同于起始ip与掩码的补位取与运算，也就是相加
            //不算最高位，也就是类似1 0000 0000地址是不考虑的，每段是1111 1111
            startIpArray[3] = startIpArray[3] + (hostNumber - 1);
            //startIpArray[3] = startIpArray[3] + hostNumber;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        if (startIpArray[3] > 255) {
            int k = startIpArray[3] / 256;
            startIpArray[3] = startIpArray[3] % 256;
            startIpArray[2] = startIpArray[2] + k;
        }
        if (startIpArray[2] > 255) {
            int j = startIpArray[2] / 256;
            startIpArray[2] = startIpArray[2] % 256;
            startIpArray[1] = startIpArray[1] + j;
            if (startIpArray[1] > 255) {
                int k = startIpArray[1] / 256;
                startIpArray[1] = startIpArray[1] % 256;
                startIpArray[0] = startIpArray[0] + k;
            }
        }
        for (int i = 0; i < 4; i++) {
            /*if(i == 3){
                startIpArray[i] = startIpArray[i] - 1;
            }*/
            if ("" == endIp.toString() || endIp.length() == 0) {
                endIp.append(startIpArray[i]);
            } else {
                endIp.append("." + startIpArray[i]);
            }
        }
        return endIp.toString();
    }
}
