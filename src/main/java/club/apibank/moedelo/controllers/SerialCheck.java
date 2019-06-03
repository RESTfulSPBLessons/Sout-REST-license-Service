package club.apibank.moedelo.controllers;

import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/rest")
public class SerialCheck {

	@GetMapping("/test")
	public String newRequest() throws IOException {

//		OkHttpClient client = new OkHttpClient();
//
//		RequestBody formBody = new FormBody.Builder()
//				//.add("username", "test")
//				//.add("password", "test")
//				.build();
//
//		Request request = new Request.Builder()
//				.url("http://localhost:1081/rest/stateful/corp/login")
//				.post(formBody)
//				.addHeader("Host", "bank.test.apibank.club")
//				.addHeader("Authorization", "Basic dHNhcmV2OnRzYXJldg==")
//				.addHeader("User-Agent", "PostmanRuntime/7.13.0")
//				.addHeader("Accept", "*/*")
//				.addHeader("Cache-Control", "no-cache")
//				.addHeader("Postman-Token", "9d819a08-2899-4b54-8a73-66ddbc2e271f,f8d5bb60-21df-4fc7-ac48-bd89e6f03bcc")
//				//.addHeader("cookie", "JSESSIONID=0dxjzl6XEhUbfQU5MW-b1Y6L.undefined")
//				.addHeader("accept-encoding", "gzip, deflate")
//				.addHeader("content-length", "")
//				.addHeader("Connection", "keep-alive")
//				.addHeader("cache-control", "no-cache")
//				.build();
//
//		Response response1 = client.newCall(request).execute();


		try {
			HttpClient httpClient = HttpClient.newHttpClient();

			HttpRequest httpRequest = HttpRequest.
					newBuilder().uri(new URI("http://www.codenuclear.com")).GET().build();

			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			System.out.println(httpResponse.statusCode());

		} catch (Exception e) {
			System.out.println("message " + e);
		}





		return "OK";
	}
}
