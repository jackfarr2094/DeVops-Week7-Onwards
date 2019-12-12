package name.christophperrins.users.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import name.christophperrins.users.general.dto.account.RequestAccountDto;
import name.christophperrins.users.general.dto.account.ResponseAccountDto;

@FeignClient("account")
public interface AccountControllerInterface {

	@RequestMapping(path = "/account", method = RequestMethod.POST)
	public ResponseAccountDto addUser(@RequestBody RequestAccountDto userDto);
	
	@RequestMapping(path = "/account", method = RequestMethod.PUT)
	public ResponseAccountDto authenticateUser(@RequestBody RequestAccountDto userDto);
	
	@RequestMapping(path = "/account/{username}", method = RequestMethod.PUT)
	public ResponseAccountDto updateUser(@PathVariable String username, @RequestBody RequestAccountDto userDto);
	
	@RequestMapping(path = "/account/{username}", method = RequestMethod.DELETE)
	public ResponseAccountDto deleteUser(@PathVariable String username);

}
