import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import java.math.*;
import org.json.JSONException;
import org.json.JSONObject;
public class CPU 
{ 
	public static void main(String[] args)  throws IOException
	{
		JSONObject obj=new JSONObject();
		String Line;
		int i=0;
		double max=0;
		double sum=0;
		double value=0;
		int count=0;
		int n=1000;
		double[] valueArray=new double[n];
		FileInputStream fis = new FileInputStream("CPU.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

			while((Line=br.readLine())!=null)
			{
				
					count++;
					StringTokenizer st=new StringTokenizer(Line," ");
					ArrayList<String> token=new ArrayList<>();	
					while(st.hasMoreTokens())
					{
						token.add(st.nextToken());
					}
					value=Double.parseDouble(token.get(8));
					valueArray[i]=value;
					for(int j=0;j<count;j++)
					{
						try
						{
						obj.put(j+"s:",valueArray[j]);
						}
						catch(JSONException e)
						{
							System.out.println(e);
						}
					}
		
					if(max<=value)
					{
						max=value;
					}
					sum+=value;
				i++;
			}
			double avg=sum/count;
			br.close();
			FileWriter fw = new FileWriter("CPU.json");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("Sample Transaction:");
			pw.println("values:"+obj);
			DecimalFormat d=new DecimalFormat("#.##");
			pw.format("\nMaxcpu:%s",d.format(max));
			pw.format("\nAvgcpu:%s", d.format(avg));
			pw.close();
			
			
		}
	
	}


