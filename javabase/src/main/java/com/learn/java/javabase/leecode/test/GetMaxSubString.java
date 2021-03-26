package com.learn.java.javabase.leecode.test;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-26 15:45
 **/
public class GetMaxSubString {
    public static void main(String[] args) {
        System.out.println(getMaxSubString("werasdfaswer","asdfas"));
    }
    // 如，传递的参数为 "abcdef" 和"defg"
    public static String getMaxSubString(String maxString,String minString){
        //1. 必须保证 第一个字符串的长度是长的。第二个是短的。
        if(minString.length()>maxString.length()){
            //TODO 重新调用这个方法
           // return getMaxSubString2(minString, maxString);
        }
        //2. 判断一下，是否直接包含，如果是的话，就不用进行阵列转换了。
        if(maxString.contains(minString)){
            return minString;
        }
        //3. 取出长度，转换相对应的矩阵。 通常，长的为y,短的为x.
        int maxLength=maxString.length();
        int minLength=minString.length();
        // 构建二维数组
        int [][] conver=new int[minLength][maxLength];
        int maxValue=0; //最大的值。
        int maxIndex=0;//最大的索引。
        //4. 对这个矩阵进行相应的放值。
        for (int i = 0; i <minLength; i++) {
            for(int j=0;j<maxLength;j++){
                //5.判断一下，值是否相同。 如果相同，
                if(minString.charAt(i)==maxString.charAt(j)){
                    //相同了，看是第几行，第几列。 第1行或者第1列的为1
                    if(i==0||j==0){
                        conver[i][j]=1;
                    }else{
                        conver[i][j]=conver[i-1][j-1]+1; //为左上角的值加1.
                        if(maxValue<conver[i][j]){ // 整个数组的最大值。 也可以是<= < 时表示取第一个，<=为最后一个。(如果存在多个的情况下)
                            maxValue=conver[i][j]; //取出那个最大的值。
                            maxIndex=i; //取出那个最大的列索引。
                        }
                    }

                }else{
                    conver[i][j]=0;  //如果不相同，为0.
                }
            }

        }
        //5. 根据最大的索引和最大的值，来判断截取那个最大的子字符串。
        if(maxValue!=0&&maxIndex!=0){ // 双重判断，如果有值的话。
            // maxIndex 为2  maxValue 为3.  开始处的值为0, 结束处的值为3 (不包括。)
            // 变成 值为  2-3+1=0 到3 ， 长度为 2*maxValue-maxIndex-1  =2*3-2-1=3 ,因为不包括maxValue所以不+1了。
            return minString.substring(maxIndex-maxValue+1,maxValue);
        }
        return null;
    }

}
