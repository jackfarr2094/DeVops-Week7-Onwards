package name.christophperrins.users.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import name.christophperrins.users.general.dto.account.RequestAccountDto;
import name.christophperrins.users.service.AccountTokenService;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class AccountTokenController {

	@Autowired
	private AccountTokenService service;
	
	@PostMapping
	public void service(@RequestBody RequestAccountDto accountDto) throws ClientProtocolException, IOException {
		service.createAccount(accountDto);
	}
}
