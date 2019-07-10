package im.zxh;

import im.zxh.mapper.WordMapper;
import im.zxh.reduce.WordReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if(otherArgs.length != 2){
            System.out.println("Usage WordCount <in><out>");
            System.exit(2);
        }

        //删除输出目录
        Path outPutPath = new Path(otherArgs[1]);
        if(outPutPath.getFileSystem(conf).exists(outPutPath)){
            outPutPath.getFileSystem(conf).delete(outPutPath,true);
        }

        Job job = Job.getInstance(conf,"word count");//设置环境参数
        //指定本程序的jar包所在的本地路径  把jar包提交到yarna
        job.setJarByClass(App.class);
        //指定本业务job要用的mapper/和reduce业务类
        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReduce.class);

        job.setOutputKeyClass(Text.class);//输出key类型
        job.setOutputValueClass(IntWritable.class);//出书value类型

        FileInputFormat.addInputPath(job,new Path(otherArgs[0]));//设置输入文件
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));//输出文件

        //交给yarn运行
        System.exit(job.waitForCompletion(true)?0:1);

    }


}
