package club.apibank.moedelo.controllers;



import club.apibank.moedelo.services.RestTool;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.ir.RuntimeNode;
import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static org.springframework.http.HttpHeaders.USER_AGENT;


@RestController
@RequestMapping("/rest")
public class SerialCheck {


	@GetMapping("/test")
	public String newRequest() throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		RestTool restTool = new RestTool(restTemplate);
		JsonObject token = restTool.getToken();


		// HTTP POST request
		//private void sendPost() throws Exception {


/*
		String url = "http://localhost:1081/rest/stateful/corp/login";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();*/

		//add reuqest header

//		con.setRequestMethod("POST");
//		con.setRequestProperty("Accept", "*/*");
//		con.setRequestProperty("Cache-Control", "no-cache");
//		con.setRequestProperty("Connection", "keep-alive");
//		con.setRequestProperty("accept-encoding", "gzip, deflate");
//		con.setRequestProperty("content-length", "");
//		con.setRequestProperty("cookie", "JSESSIONID=0dxjzl6XEhUbfQU5MW-b1Y6L.undefined");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//		con.setRequestProperty("Host", "bank.test.apibank.club");
//		con.setRequestProperty("Authorization", "Basic dHNhcmV2OnRzYXJldg==");

		//String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
//		con.setDoOutput(true);
//		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//		//wr.writeBytes(urlParameters);
//		wr.flush();
//		wr.close();

//		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		//System.out.println("Post parameters : " + urlParameters);
//		System.out.println("Response Code : " + responseCode);
//
//		BufferedReader in = new BufferedReader(
//				new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in.close();
//
//		//print result
//		System.out.println(response.toString());


		//OkHttpClient client = new OkHttpClient();

		//RequestBody formBody = new FormBody.Builder()
				//.add("username", "test")
				//.add("password", "test")
	//			.build();

//		Request request = new Request.Builder()
//				.url("http://localhost:1081/rest/stateful/corp/login")
//				.post(formBody)
//				.addHeader("Host", "bank.test.apibank.club")
//				.addHeader("Authorization", "Basic dHNhcmV2OnRzYXJldg==")
//				.addHeader("User-Agent", "PostmanRuntime/7.13.0")
//			//	.addHeader("Accept", "*/*")
			//	.addHeader("Cache-Control", "no-cache")
			//	.addHeader("Postman-Token", "9d819a08-2899-4b54-8a73-66ddbc2e271f,f8d5bb60-21df-4fc7-ac48-bd89e6f03bcc")
			//	.addHeader("cookie", "JSESSIONID=0dxjzl6XEhUbfQU5MW-b1Y6L.undefined")
			//	.addHeader("accept-encoding", "gzip, deflate")
			//	.addHeader("content-length", "")
			//	.addHeader("Connection", "keep-alive")
			//	.addHeader("cache-control", "no-cache")
//				.build();

//		Response response1 = client.newCall(request).execute();


		return "OK";


	}
}
