import org.apache.hadoop.io.* ;
import org.apache.hadoop.hive.ql.exec.UDF ;
public class Direction extends UDF
{
	public Text evaluate(Text userlat, Text userlong, Text citylat, Text citylong)
	{
		double a1 = Math.toRadians(Double.parseDouble(userlat.toString())) ;
		double a2 = Math.toRadians(Double.parseDouble(userlong.toString())) ;
		double b1 = Math.toRadians(Double.parseDouble(citylat.toString())) ;
		double b2 = Math.toRadians(Double.parseDouble(citylong.toString())) ;
		double x = Math.cos(b1) * Math.sin(b2 - a2) ;
		double y = Math.cos(a1) * Math.sin(b1) - Math.sin(a1) * Math.cos(b1) * Math.cos(b2 - a2) ;
		double t = Math.toDegrees(Math.atan2(x, y)) ;
		t = (t + 360) % 360 ;
		if(t < 135 && t > 46)
		{
			return(new Text("EAST")) ;
		}
		else if(t < 225 && t > 136)
		{
			return(new Text("SOUTH")) ;
		}
		else if(t < 315 && t > 226)
		{
			return(new Text("WEST")) ;
		}	
		else
		{
			return (new Text("NORTH")) ;
		}
	}
}