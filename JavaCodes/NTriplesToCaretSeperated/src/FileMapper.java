import java.util.regex.* ;
import java.io.* ;
import org.apache.hadoop.io.* ;
import org.apache.hadoop.mapreduce.* ;

public class FileMapper extends Mapper<LongWritable, Text, Text, Text>
{	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{   
		String st = value.toString() ;
		String[] word = st.split(" ") ;
		String city = word[0] ;
		if(!city.equals("#")) 
		{
			String prefix = "(<http://dbpedia.org/resource/)((.)*)>" ;
			String ans = new FileMapper().Extract(city, prefix)	;
			prefix = "(\")((-)?(.)+)(\")" ;
			String val = new FileMapper().Extract(word[2], prefix) ;
			prefix = "(#)((.)*)>" ;		
			String check = new FileMapper().Extract(word[1], prefix) ;
			if(check.equals("lat") || check.equals("long"))
			{
				context.write(new Text(ans), new Text(check+"|"+val)) ;
			}
		}
	}

	public String Extract(String data, String prefix)
	{
		String ans = "" ;
		Pattern pattern = Pattern.compile(prefix) ;
		Matcher matcher = pattern.matcher(data) ;
		if (matcher.find())
		{
		    ans = matcher.group(2) ;
		}
		return ans ;
	}
}