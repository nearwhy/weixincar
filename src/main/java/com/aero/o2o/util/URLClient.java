package com.aero.o2o.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
 
  
public class URLClient {  
    protected HttpURLConnection connection;  
    public String getDocumentAt(String urlString) {  
        StringBuffer document = new StringBuffer();  
        try {  
            URL url = new URL(urlString);  
            URLConnection conn = url.openConnection();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
            String line = null;  
            while ((line = reader.readLine()) != null)  
                document.append(line+"\n");  
            reader.close();  
        } catch (MalformedURLException e) {  
            System.out.println("Unable to connect to URL: " + urlString);  
        } catch (IOException e) {  
            System.out.println("IOException when connecting to URL: " + urlString);  
        }  
        return document.toString();  
    }  
    public static void main(String[] args) throws UnsupportedEncodingException {  
        URLClient client = new URLClient();  
        //携程网
       String yahoo = client.getDocumentAt("http://127.0.0.1:8080/AirPortAdmin/sf.jsp");  
    
        System.out.println(yahoo);
         
        
    }  
}  
