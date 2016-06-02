import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import java.io.*;

public class RequestBinTutorial 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Get Method:"+getMethod("http://httpbin.org/get"));
		//System.out.println("Post Method:"+getMethod("http://httpbin.org/post"));
		//System.out.println("Header Method:"+getMethod("http://httpbin.org/headers"));
	}
	
	public static  String getMethod(String url)
	{
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		try
		{
			int statusCode = client.executeMethod(method);
			byte[] responseBody = method.getResponseBody();
			System.out.println("byte:"+responseBody);
			return new String(responseBody);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		finally
		{
			method.releaseConnection();
		}
	}

}
