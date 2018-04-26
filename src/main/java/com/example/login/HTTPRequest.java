package com.example.internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest{
	public String getSite(){
		try {
            String address = "http://www.duckduckgo.com";
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String response = br.readLine();
            br.close();
            return response;
        }
        catch(Exception e){
            e.printStackTrace();
            return "";
        }

	}
}
