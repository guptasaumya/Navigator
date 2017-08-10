import java.io.* ;
import org.apache.hadoop.io.* ;
import org.apache.hadoop.mapreduce.* ;
public class JSONMapper extends Mapper<LongWritable, Text, Text, Text>
{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String s = value.toString() ;
		String st = "" ;
		String[] arr = s.split("\t") ;
		int l = arr.length ;
		for(int i = 1; i < l; i++)
			st += arr[i] + "*" ;
		context.write(new Text(arr[0]), new Text(st)) ;
	}
}