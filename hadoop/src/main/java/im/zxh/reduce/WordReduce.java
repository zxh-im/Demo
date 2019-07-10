package im.zxh.reduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Map处理完后，数据经过shuffle节点输入给Reuduce任务，
 * Reduce的输入形式是（key, value-list）形式。
 */
public class WordReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    private  static IntWritable result = new IntWritable(1);

    /**
     * 每一组相同的<k,v>调用一次reduce方法
     * @param key
     * @param values
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
         int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        result.set(sum);
        context.write(key,result);
    }
}
