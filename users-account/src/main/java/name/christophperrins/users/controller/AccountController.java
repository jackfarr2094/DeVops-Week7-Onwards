package name.christophperrins.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import name.christophperrins.users.general.dto.account.RequestAccountDto;
import name.christophperrins.users.general.dto.account.ResponseAccountDto;
import name.christophperrins.users.general.mapping.Mapping;
import name.christophperrins.users.persistence.domain.Account;
import name.christophperrins.users.service.AccountService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/account")
public class AccountController {
	
	@Autowired
	private Mapping mapping;
	
	@Autowired
	private AccountService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseAccountDto addUser(@RequestBody RequestAccountDto userDto) {
		Account user = mapping.map(userDto, Account.class);
		return mapping.map(service.addUser(user), ResponseAccountDto.class);
	}
	
	@PutMapping
	public ResponseAccountDto authenticateUser(@RequestBody RequestAccountDto userDto) {
		Account user = mapping.map(userDto, Account.class);
		return mapping.map(service.authenticate(user), ResponseAccountDto.class);
	}
	
	@PutMapping("/{username}")
	public ResponseAccountDto updateUser(@PathVariable String username, @RequestBody RequestAccountDto userDto) {
		Account user = mapping.map(userDto, Account.class);
		return mapping.map(service.updateUser(username, user), ResponseAccountDto.class);
	}
	
	@DeleteMapping("/{username}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseAccountDto deleteUser(@PathVariable String username) {
		return mapping.map(service.deleteUser(username), ResponseAccountDto.class);
	}

}
