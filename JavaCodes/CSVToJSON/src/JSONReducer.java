import java.io.* ;
import org.apache.hadoop.io.* ;
import org.apache.hadoop.mapreduce.* ;
public class JSONReducer extends Reducer<Text, Text, Text, Text>
{
	public void reduce(Text key, Iterable<Text>value, Context context) throws IOException, InterruptedException
	{
		String Nans = "", Wans = "", Sans = "", Eans = "" ;
		for(Text x : value)
		{
			String st = "" ;
			String s = x.toString() ;
			String[] arr = s.split("[*]") ;
			int l = arr.length ;
			arr[1] = "\"https://dbpedia.org/resource/" + arr[1] + "\"" ;
			for(int i = 1; i < l - 1; i++)
			{
				st += arr[i] ;
				if(i != l - 2)
					st += "," ;
			}
			if(arr[0].equals("NORTH"))
			{
				Nans += " [ " + st + " ] ," + "\r\n"  ; 
			}
			if(arr[0].equals("WEST"))
			{
				Wans += " [ " + st + " ] ," + "\r\n" ; 
			}
			if(arr[0].equals("SOUTH"))
			{
				Sans += " [ " + st + " ] ," + "\r\n" ; 
			}
			if(arr[0].equals("EAST"))
			{
				Eans += " [ " + st + " ]," + "\r\n" ; 
			}			
		}
		Nans = Nans.substring(0, Nans.length() - 3) + "\r\n" ;
		Eans = Eans.substring(0, Eans.length() - 3) + "\r\n" ;
		Sans = Sans.substring(0, Sans.length() - 3) + "\r\n" ;
		Wans = Wans.substring(0, Wans.length() - 3) + "\r\n" ;
		String k = "\"" + key.toString() + "\"" ;
		String Fans = " :{ " + "\r\n\r\t \"EAST\" : [ " + Eans + " ]  , \r\n\r\t \"NORTH\" : [ " + Nans + " ]  , \r\n\r\t \"SOUTH\" : [ " + Sans + " ]  , \r\n\r\t \"WEST\" :[ " + Wans + " ] },"  ;
		context.write(new Text(k), new Text(Fans)) ;
	}
}