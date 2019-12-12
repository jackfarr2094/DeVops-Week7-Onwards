package name.christophperrins.users.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import name.christophperrins.users.general.dto.token.AuthTokenDto;

@FeignClient("token")
public interface TokenControllerInterface {

	@RequestMapping(value = "/token/{username}", method = RequestMethod.POST)
	public AuthTokenDto createAuthToken(@PathVariable String username);

	@RequestMapping(value = "/token/{bearerToken}", method = RequestMethod.GET)
	public AuthTokenDto authenticate(@PathVariable String bearerToken);

	@RequestMapping(value = "/token/all/{bearerToken}", method = RequestMethod.GET)
	public List<AuthTokenDto> getAll(@PathVariable String bearerToken);

	@RequestMapping(value = "/token/{bearerToken}", method = RequestMethod.PUT)
	public AuthTokenDto resetAuthToken(@PathVariable String bearerToken);

	@RequestMapping(value = "/token/{bearerToken}", method = RequestMethod.DELETE)
	public String deleteAuthToken(@PathVariable String bearerToken);

	@RequestMapping(value = "/token/all/{bearerToken}", method = RequestMethod.DELETE)
	public String deleteAllAuthToken(@PathVariable String bearerToken);
}
