package club.apibank.moedelo.controllers;

import okhttp3.*;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/rest")
public class SerialCheck {

	@GetMapping("/test")
	public String newRequest() throws IOException, URISyntaxException {

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


		/*try {
			HttpClient httpClient = HttpClient.newHttpClient();

			HttpRequest httpRequest = HttpRequest.
					newBuilder()
					.uri(new URI("http://localhost:1081/rest/stateful/corp/login"))
					.header("authorization", "Basic dHNhcmV2OnRzYXJldg==")
					.header("host", "bank.test.apibank.club")
					.POST(HttpRequest.BodyPublishers.noBody())
					.build();

			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			System.out.println(httpResponse.statusCode());

		} catch (Exception e) {
			System.out.println("message " + e);
		}*/


	//	RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:1081/rest/stateful/corp/login";
		URI uri = new URI(baseUrl);
		//HttpEntity<String> request = new HttpEntity<>((""));

		//Employee employee = new Employee(null, "Adam", "Gilly", "test@email.com");

		//ResponseEntity<String> result = restTemplate.postForEntity(uri, null, String.class);


		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("authorization", "Basic dHNhcmV2OnRzYXJldg==");
		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		headers.setHost(new InetSocketAddress("bank.test.apibank.club", 8080));
		//headers.set("Host", "bank.test.apibank.club");

		// HttpEntity<String>: To get result as String.
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method, and Headers.
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		String result = response.getBody();

		System.out.println(result);


		return result;
	}
}
