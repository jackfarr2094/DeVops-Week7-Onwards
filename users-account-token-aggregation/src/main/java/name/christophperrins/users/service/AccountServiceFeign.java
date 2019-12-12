package name.christophperrins.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.christophperrins.users.controller.AccountControllerInterface;
import name.christophperrins.users.controller.TokenControllerInterface;
import name.christophperrins.users.general.dto.account.RequestAccountDto;
import name.christophperrins.users.general.dto.account.ResponseAccountDto;
import name.christophperrins.users.general.dto.token.AuthTokenDto;

@Service
public class AccountServiceFeign {

	@Autowired
	private AccountControllerInterface accountController;
	
	@Autowired
	private TokenControllerInterface tokenController;
	
	public AuthTokenDto createAccount(RequestAccountDto account) {
		ResponseAccountDto responseAccount = accountController.addUser(account);
		return tokenController.createAuthToken(responseAccount.getUsername());
	}
	
	public AuthTokenDto login(RequestAccountDto account) {
		ResponseAccountDto responseAccount = accountController.authenticateUser(account);
		return tokenController.createAuthToken(responseAccount.getUsername());
	}
	
	public AuthTokenDto changeCredentials(String bearerToken, RequestAccountDto account) {
		AuthTokenDto authToken = tokenController.authenticate(bearerToken);
		tokenController.deleteAllAuthToken(bearerToken);
		accountController.updateUser(authToken.getUsername(), account);
		return tokenController.createAuthToken(account.getUsername());
	}
	
	public AuthTokenDto authenticate(String bearerToken) {
		return tokenController.authenticate(bearerToken);
	}
	
	public String deleteAccount(String bearerToken) {
		AuthTokenDto authToken = tokenController.authenticate(bearerToken);
		tokenController.deleteAllAuthToken(bearerToken);
		accountController.deleteUser(authToken.getUsername());
		return "Account deleted";
	}
}
