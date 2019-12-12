package name.christophperrins.users.general.mapping;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import name.christophperrins.users.general.exceptions.FormattingException;
import name.christophperrins.users.general.exceptions.OtherException;

public class ObjectJsonMapping {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public <S> String convertObjectToJSON(S source) {
		try {
			return objectMapper.writeValueAsString(source);
		} catch (JsonProcessingException e) {
			throw new FormattingException("Json Processing Exception with " + source.toString(), "Could not process data");
		}
	}
	
	public <S> S convertJsonToObject(String source, Class<S> destinationType) {
		try {
			return objectMapper.readValue(source, destinationType);
		} catch (JsonParseException e) {
			throw new FormattingException("Json Processing Exception with " + source.toString(), "Could not understand data");
		} catch (JsonMappingException e) {
			throw new FormattingException("Json Processing Exception with " + source.toString(), "Could not translate data");
		} catch (IOException e) {
			throw new OtherException("IO Exception Occured", e);
		}
	}

}
