import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import java.math.*;
import org.json.JSONObject;
public class File 
{ 
	public static void main(String[] args)
	{
		JSONObject obj=new JSONObject();
		JSONObject obj1=new JSONObject();
		String a;
		int i=0;
		double max=0;
		double sum=0;
		double b=0;
		int flag=0;
		int n=10000;
		double array1[]=new double[n];
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("Memory.txt"));
			while((a=br.readLine())!=null)
			{
				if(i%2!=0)
				{
				//System.out.println(a);
					flag++;
					StringTokenizer st=new StringTokenizer(a,": ");
					ArrayList<String> token=new ArrayList<>();	
					while(st.hasMoreTokens())
					{
						token.add(st.nextToken());
					}
					b=Double.parseDouble(token.get(1));
					//System.out.println(b);
					b=b/1024;
					String str;
					for(int j=0;j<flag;j++)
					{
						str=String.format("%d",j);
						obj1.put(j+"s:",b);
					}
					if(max<b)
					{
						max=b;
					}
					array1[i]=b;
					sum+=b;
			    }
				i++;
			}
			double avg=sum/flag;
			
			DecimalFormat d=new DecimalFormat("#.##");
			d.setRoundingMode(RoundingMode.CEILING);
			System.out.println("AverageMemory(MB):"+d.format(avg));
			System.out.println("MaximumMemory(MB):"+d.format(max));
			obj.put("values:", obj1);
			System.out.println(obj);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
