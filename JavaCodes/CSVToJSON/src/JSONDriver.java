import org.apache.hadoop.io.* ;
import org.apache.hadoop.mapreduce.* ;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.fs.* ;
public class JSONDriver
{
	public static void main(String[] args) throws Exception
	{
		Job job = new Job() ;
		job.setJarByClass(JSONDriver.class) ;
		job.setMapperClass(JSONMapper.class);
		job.setReducerClass(JSONReducer.class) ;
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class) ;
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true) ;
	}
}