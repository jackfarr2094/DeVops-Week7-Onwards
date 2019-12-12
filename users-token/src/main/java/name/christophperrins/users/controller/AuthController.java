package name.christophperrins.users.controller;

import java.util.List;

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

import name.christophperrins.users.general.dto.token.AuthTokenDto;
import name.christophperrins.users.general.mapping.Mapping;
import name.christophperrins.users.service.AuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class AuthController {

	@Autowired
	private Mapping mapping;
	
	@Autowired
	private AuthService service;
	
	@PostMapping("/{username}")
	public AuthTokenDto createAuthToken(@PathVariable String username) {
		return mapping.map(service.assignToken(username), AuthTokenDto.class);
	}
	
	@GetMapping("/{bearerToken}")
	public AuthTokenDto authenticate(@PathVariable String bearerToken) {
		return mapping.map(service.getByBearerToken(bearerToken), AuthTokenDto.class);
	}
	
	@GetMapping("/all/{bearerToken}")
	public List<AuthTokenDto> getAll(@PathVariable String bearerToken) {
		return mapping.map(service.getAllAuthTokens(bearerToken), AuthTokenDto.class);
	}

	@PutMapping("/{bearerToken}")
	public AuthTokenDto resetAuthToken(@PathVariable String bearerToken) {
		return mapping.map(service.resetBearerToken(bearerToken), AuthTokenDto.class);
	}
	
	@DeleteMapping("/{bearerToken}")
	public String deleteAuthToken(@PathVariable String bearerToken) {
		service.removeAuthToken(bearerToken);
		return "Authentication Token Deleted";
	}
	
	@DeleteMapping("/all/{bearerToken}")
	public String deleteAllAuthToken(@PathVariable String bearerToken) {
		service.removeAllAuthTokens(bearerToken);
		return "All Authentication Tokens have been removed";
	}
}
