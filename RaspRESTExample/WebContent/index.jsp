<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.ws.rs.core.MediaType" %>
<%@ page import="com.sun.jersey.api.client.*" %>
<%@ page import="org.json.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Raspberry Pi core temp REST service</title>
</head>

<body>
<br/><br/>
<%!
public String extractTempFromJSON() {
	
	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:8080/RaspRESTExample/rpiinfo/rpitemp");
	String resp = webResource.get(String.class);
	resp = resp.substring(resp.indexOf("{"));

 	final JSONObject jsonObj = new JSONObject(resp);
	
	if ( jsonObj != null && jsonObj.has( "RPI CPU temp" ) )
		{
	//final JSONObject coretemp = (JSONObject) jsonObj.get( "RPI CPU temp" );
			double d = jsonObj.getDouble("RPI CPU temp");
			return Double.toString(d);
		}
	else return "";

}
%>


<p>Current temperature of RPi core:
<%=extractTempFromJSON()%>
</p>

</body>
</html>