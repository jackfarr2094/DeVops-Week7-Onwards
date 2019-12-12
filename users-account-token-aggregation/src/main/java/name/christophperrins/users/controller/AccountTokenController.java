package name.christophperrins.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import name.christophperrins.users.general.dto.account.RequestAccountDto;
import name.christophperrins.users.general.dto.token.AuthTokenDto;
import name.christophperrins.users.service.AccountServiceFeign;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class AccountTokenController {
	
	@Autowired
	private AccountServiceFeign accountService;
	
	@PostMapping
	public AuthTokenDto createAccount(@RequestBody RequestAccountDto account) {
		return accountService.createAccount(account);
	}
	
	@PutMapping
	public AuthTokenDto login(@RequestBody RequestAccountDto account) {
		return accountService.login(account);
	}
	
	@GetMapping("/{bearerToken}")
	public AuthTokenDto authenticate(@PathVariable String bearerToken) {
		return accountService.authenticate(bearerToken);
	}
	
	@DeleteMapping("/{bearerToken}")
	public String deleteAccount(@PathVariable String bearerToken) {
		return accountService.deleteAccount(bearerToken);
	}

}
