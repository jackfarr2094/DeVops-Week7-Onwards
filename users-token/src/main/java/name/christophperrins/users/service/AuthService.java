package name.christophperrins.users.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.christophperrins.users.general.exceptions.NotFoundException;
import name.christophperrins.users.general.exceptions.UnauthorisedException;
import name.christophperrins.users.persistence.domain.AuthToken;
import name.christophperrins.users.persistence.repository.AuthRepository;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;

	public AuthToken assignToken(String username) {
		AuthToken authToken = createAuthToken();
		authToken.setUsername(username);
		authToken.setExpireDate(getDateNextMonth());
		return authRepository.saveAndFlush(authToken);
	}
	
	private Date getDateNextMonth() {
		Date date = new Date();
		Long currentTime = date.getTime();
		date.setTime(currentTime + 2628000000L);
		return date;
	}
	
	private AuthToken createAuthToken() {
		AuthToken authToken = new AuthToken();
		authToken.setBearerToken(createBearerToken());
		return authToken;
	}
	
	private String createBearerToken() {
		return RandomStringUtils.randomAlphanumeric(50);
	}
	
	public AuthToken getByBearerToken(String bearerToken) throws UnauthorisedException, NotFoundException {
		AuthToken authToken = authRepository.findByBearerToken(bearerToken).orElseThrow(() -> new NotFoundException(AuthToken.class, "Bearer Token Not found"));
		
		return removeIfOutdated(authToken);
	}
	
	private AuthToken removeIfOutdated(AuthToken authToken) throws UnauthorisedException{
		if(authToken.getExpireDate().before(new Date())) {
			authRepository.delete(authToken);
			throw new UnauthorisedException("Bearer Token Expired", "Bearer Token Expired, It has been deleted");
		}
		return authToken;
	}
	
	public List<AuthToken> getAllAuthTokens(String bearerToken){
		AuthToken authCredentials = getByBearerToken(bearerToken);
		List<AuthToken> tokenList = authRepository.findByUsername(authCredentials.getUsername());
	
		List<AuthToken> cleanedList = new ArrayList<AuthToken>();
		for(AuthToken authToken : tokenList) {
			try {
				cleanedList.add(removeIfOutdated(authToken));
			} catch (UnauthorisedException ex) {
				ex.printStackTrace();
			}
		}
		return cleanedList;
	}
	
	public AuthToken resetBearerToken(String bearerToken) {
		AuthToken authToken = getByBearerToken(bearerToken);
		authToken.setBearerToken(createBearerToken());
		authToken.setExpireDate(getDateNextMonth());
		authRepository.flush();
		return authToken;
	}
	
	public void removeAllAuthTokens(String bearerToken) {
		AuthToken authToken = authRepository.findByBearerToken(bearerToken).orElseThrow(() -> new UnauthorisedException("Bearer Token not found", "Unauthorised Bearer Token"));
		List<AuthToken> allTokens = authRepository.findByUsername(authToken.getUsername());
		allTokens.stream().forEach(token -> authRepository.delete(token));
	}
	
	public void removeAuthToken(String bearerToken) {
		authRepository.delete(getByBearerToken(bearerToken));
	}
	
	public void removeAuthToken(AuthToken authToken) {
		authRepository.delete(authToken);
	}
}
