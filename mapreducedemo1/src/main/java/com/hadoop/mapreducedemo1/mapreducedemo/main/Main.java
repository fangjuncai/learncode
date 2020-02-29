package com.hadoop.mapreducedemo1.mapreducedemo.main;



import com.hadoop.mapreducedemo1.mapreducedemo.mapper.MyMapperTask;
import com.hadoop.mapreducedemo1.mapreducedemo.reduce.MyReducerTask;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Main {

    public static void main(String[] args) throws Exception {
        // 创建配置文件对象
        //Configuration conf = new Configuration(true);
        Configuration conf = new Configuration();
        // 获取Job对象
        Job job = Job.getInstance(conf);
        // 设置相关类
        job.setJarByClass(Main.class);
        //job.setJar("/root/user/mapreducedemo-0.0.1-SNAPSHOT.jar");

        // 指定 Map阶段和Reduce阶段的处理类
        job.setMapperClass(MyMapperTask.class);
        job.setReducerClass(MyReducerTask.class);

        // 指定Map阶段的输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 指定job的hdfs原始文件的输入输出路径 通过参数传入
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        //hdfs输出文件
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        // 提交任务，并等待响应
        job.waitForCompletion(true);
    }
}



