package club.apibank.moedelo.services;

import com.google.gson.JsonObject;
import okhttp3.FormBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.InetSocketAddress;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Сервисный класс, содержащий основной функционал: обработку респонсов, отправку запросов, пушей, работу с токенами.
 */
public class RestTool {
	private static Logger logger = LoggerFactory.getLogger(RestTool.class);
//	private static Logger consoleLogger = LoggerFactory.getLogger("console_logger");



	public enum SCAN_TYPE {PASSPORT_SCAN, SNILS_SCAN, INN_SCAN}

	@Autowired
	private Environment env;

	/**
	 * username токена
	 */
	@Value("${userNameForToken}")
	private String userNameForToken;

	/**
	 * password токена
	 */
	@Value("${passwordForToken}")
	private String passwordForToken;

	/**
	 * url на получение токена
	 */
	@Value("${urlForToken}")
	private String urlForToken;

	@Value("${operatorTalkBankUser}")
	private String operatorTalkBankUser;

	@Value("${operatorTalkBankpassword}")
	private String operatorTalkBankpassword;

	@Value("${grant_type}")
	private String grant_type;

	/**
	 * url на отправку скана пасспорта
	 */
	@Value("${urlForScan}")
	private String urlForScan;

	/**
	 * url запроса на проверку инн
	 */
	@Value("${urlForInn}")
	private String urlForInn;

	/**
	 * url запроса на прохождение УПРИД
	 */
	@Value("${urlForUPRID}")
	private String urlForUPRID;


	/**
	 * url запроса на регистрацию анонимного клиента
	 */
	@Value("${url4Anonymous}")
	private String url4Anonymous;



	/**
	 * url запроса на выпуск ВПК
	 */
	@Value("${urlForVPK}")
	private String urlForVPK;


	@Value("${urlForPush}")
	private String urlForPush;

	@Value("${urlClientInfo}")
	private String url4ClientInfo;

	/**
	 * Отладочная фенечка для рандомной генерации телефона/пасспорта
	 */
	@Value("${randomTelephonPassport}")
	private boolean randomTelephonPassport;

	RestTemplate restTemplate;

	public RestTool(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Возвращает Jsonobject делая запрос на инн.
	 * @param surname
	 * @param name
	 * @param patronymic
	 * @param birthdate
	 * @param series
	 * @param number
	 * @return - Jsonobject с данными ИНН
	 */
	/*public JsonObject getINN(String surname, String name, String patronymic, LocalDate birthdate, String series, String number) {
		return getResponse(
				urlForInn,
				HttpMethod.GET,
				createHeaderWithToken(MediaType.APPLICATION_JSON),
				JSONTemplate.create()
						.add("surname",surname)
						.add("name",name)
						.add("patronymic",patronymic)
						.add("birthdate",birthdate.format(DateTimeFormatter.ISO_LOCAL_DATE))
						.add("identity_doc_type",21)
						.add("identity_doc_number",series+number)
						.toString());
	}*/

	/**
	 * Отправка запроса.
	 *
	 * @param url - куда шлем
	 * @param method - тип метода (Гет/пост)
	 * @param headers - заголовки
	 * @param requestBody
	 * @return
	 */

	public  JsonObject getResponse(String url, HttpMethod method, HttpHeaders headers, Object requestBody) {

		HttpEntity httpEntity = new HttpEntity("{}", headers);

		ResponseEntity<String> responseEntity = null;
		try {
			//responseEntity = restTemplate.postForEntity(url, method, httpEntity, String.class); // отправляем запрос, ждем ответ.

			// Send request with POST method.
			String e = restTemplate.postForObject(url, httpEntity, String.class);
		//	restTemplate.postForEntity()

		} catch (HttpClientErrorException ex) {
			responseEntity = new ResponseEntity<>(ex.getResponseBodyAsString(), ex.getStatusCode());
		}

		JsonObject responseJson = null;
		if (responseEntity != null && responseEntity.getBody() != null)
			responseJson = JSONTemplate.fromString(responseEntity.getBody());

		if (responseEntity.getStatusCode() != HttpStatus.OK)
			throw new RifHttpClientErrorException(responseEntity.getBody(), responseEntity.getStatusCode());

		return responseJson;
	}

	static class RifHttpClientErrorException extends HttpClientErrorException {
		private String customMessage;
		public RifHttpClientErrorException(String customMessage, HttpStatus statusCode) {
			super(statusCode);
			this.customMessage = customMessage;
		}

		public String getCustomMessage() {
			return customMessage;
		}
	}





	/**
	 * Выпуск виртуальной карты.
	 *
	 * @param clientID
	 * @return
	 */
	/*public JsonObject getVPK(String clientID) {
		return getResponse((urlForVPK + clientID + "/virtual-cards"), HttpMethod.POST,
				createHeaderWithToken(MediaType.APPLICATION_JSON), null);
	}*/

	/**
	 * Создаем заголовки без токена.
	 *
	 * @param type
	 * @return
	 */
	public HttpHeaders createHeaderWithoutToken(MediaType type) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
		headers.setCacheControl("no-cache");
		return headers;
	}

	/**
	 * Создаем заголовки с токеном.
	 *
	 * @param type
	 * @return
	 */
	public HttpHeaders createHeaderWithToken(MediaType type) {
		JsonObject token = getToken();
		HttpHeaders headers = createHeaderWithoutToken(type);
		headers.setBearerAuth(token.get("access_token").getAsString());
		return headers;
	}


	/**
	 * Получение токена.
	 * @return
	 */
	public  JsonObject getToken() {
		HttpHeaders headers = new HttpHeaders();

		//headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setCacheControl("no-cache");
		headers.setConnection("keep-alive");
		headers.set("accept-encoding", "gzip, deflate");
		//headers.set("cookie", "JSESSIONID=0dxjzl6XEhUbfQU5MW-b1Y6L.undefined");
		headers.setContentLength(0L);

		//headers.set("Host", "bank.test.apibank.club");
		//headers.set("Authorization", "Basic dHNhcmV2OnRzYXJldg==");
		//InetSocketAddress byAddress1 = new InetSocketAddress("bank.test.apibank.club", 80);
		//headers.setHost(byAddress1);
		//headers.setBasicAuth("tsarev", "tsarev");


		return getResponse("http://localhost:1081/rest/stateful/corp/login", HttpMethod.POST, headers,"");
		//return getResponse("http://84.47.161.121:8080/RCCT-2.0-SNAPSHOT/rest/users/status", HttpMethod.GET, headers,"");
	}
}
