package com.test.rpitest;
/**
 * @author Vitaliy Minayev
 *
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
 
@Path("/rpitemp")
/**
 * @author Vitaliy Minayev
 *
 */
public class RPiService {
	static final String SYSINFO_PATH="/sys/class/thermal/thermal_zone0/temp";
	
	@GET
	@Produces("application/json")
	public Response extractRaspberryProcessorTemperature() throws JSONException, FileNotFoundException, IOException {
 
		JSONObject jsonObject = new JSONObject();
		Double rpiCpuTemp = 36.8;
		String tempStr = new String("");

		try
	    	{
	    	BufferedReader in = new BufferedReader (new FileReader(SYSINFO_PATH));
	    	try {
	    		tempStr = in.readLine();
	    		while (tempStr != null) {
	    			int i= tempStr.indexOf("temp=");
	    			if (i != -1)
	    				{  				
	    				rpiCpuTemp = Double.parseDouble(tempStr.substring(i+5,i+10));
	    				}
	    		}
	    	}
	    	finally {in.close();}
	    } catch (FileNotFoundException e){System.out.println(e.toString());
	    } catch (IOException e) {System.out.println(e.toString());}
        
		jsonObject.put("RPI CPU temp", rpiCpuTemp); 

		String result = "@Produces(\"application/json\") Output: \n\nCurrent CPU temperature: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	   
		
		
	}
 
		
	
}
