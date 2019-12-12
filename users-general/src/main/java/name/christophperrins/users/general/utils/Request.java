package name.christophperrins.users.general.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import name.christophperrins.users.general.exceptions.ForbiddenException;
import name.christophperrins.users.general.exceptions.FormattingException;
import name.christophperrins.users.general.exceptions.OtherException;
import name.christophperrins.users.general.exceptions.UnauthorisedException;
import name.christophperrins.users.general.mapping.ObjectJsonMapping;

public class Request {

	@Autowired
	private ObjectJsonMapping objectJsonMapping;

	public <S> HttpUriRequest makeRequest(HttpEntityEnclosingRequestBase request, S body) {
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		String jsonString = null;
		try {
			jsonString = objectJsonMapping.convertObjectToJSON(body);
			request.setEntity(new StringEntity(jsonString));
		} catch (UnsupportedEncodingException e) {
			throw new FormattingException("UnsupportedEncodingException thrown for " + jsonString,
					"Error understading string encoding");
		}
		return request;
	}
	
	public <S> HttpUriRequest makeRequest(HttpUriRequest request) {
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		return request;
	}
	
	public HttpUriRequest makeRequest(HttpEntityEnclosingRequestBase request, String body) {
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		try {
			request.setEntity(new StringEntity(body));
		} catch (UnsupportedEncodingException e) {
			throw new FormattingException("UnsupportedEncodingException thrown for " + body,
					"Error understading string encoding");
		}
		return request;
	}

	public String sendRequest(HttpUriRequest request) {
		try (CloseableHttpClient client = HttpClients.createDefault();
				CloseableHttpResponse response = client.execute(request)) {
			InputStream inputStream = response.getEntity().getContent();
			char[] bufferedInfo = new char[1024];
			StringBuilder responseBody = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(inputStream);
			int readCharacters;
			while ((readCharacters = reader.read(bufferedInfo, 0, bufferedInfo.length)) > 0) {
				responseBody.append(bufferedInfo, 0, readCharacters);
			}
			if(response.getStatusLine().getStatusCode() == HttpStatus.UNAUTHORIZED.value()) {
				throw new UnauthorisedException("Unauthorized Request", responseBody.toString());
			} else if(response.getStatusLine().getStatusCode() == HttpStatus.FORBIDDEN.value()) {
				throw new ForbiddenException("Forbidden Request", responseBody.toString());
			}
			return responseBody.toString();
		} catch (IOException ex) {
			throw new OtherException("IO exception occured", ex);

		}
	}
}
