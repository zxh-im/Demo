package im.zxh.mapper;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * map处理逻辑
 * 首先自定义一个类继承MapReduce框架的Mapper类。Map的输入类型是键值对，
 * 键是行号，值就是单词，输出也是键值对，键是一个个单词，值就是其出现的次数，
 * 这里的次数值都是1，经过Reduce处理才得到最终次数。
 */
public class WordMapper extends Mapper<Object, Text, Text, IntWritable> {

    private  static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    /**
     * map阶段的业务逻辑在自己自定义的map ，maptask会对每一行数据调用一次map
     * @param key
     * @param value
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        //key就是行号，value就是一行字符串
        //将maptask传给我们的内容先转换成String
        //StringTokenizer拆分字符串的原理是通过生成StringTokenizer对象
        //一个参数时 使用默认的分隔符 okenizer 使用默认的分隔符集 " \t\n\r\f"，即：
        // 空白字符、制表符、换行符、回车符和换页符。分隔符字符本身不作为标记。
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()){
            word.set(itr.nextToken());
            context.write(word,one);
        }
    }
}
