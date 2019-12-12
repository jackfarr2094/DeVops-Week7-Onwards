package name.christophperrins.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import name.christophperrins.users.general.exceptions.ForbiddenException;
import name.christophperrins.users.general.exceptions.NotFoundException;
import name.christophperrins.users.general.exceptions.UnauthorisedException;
import name.christophperrins.users.persistence.domain.Account;
import name.christophperrins.users.persistence.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository userRepository;
	
	public Account addUser(Account user) {
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			throw new ForbiddenException(user.getUsername() + " already exists in database", "Username already exists");
		} else {
			return userRepository.save(user);			
		}
	}
	
	private Account getUser(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(Account.class, "User id not found"));
	}
	
	private boolean checkAvailable(String username) {
		return !(userRepository.findByUsername(username).isPresent());
	}
	
	public Account updateUser(String currentUsername, Account newInfo) {
		Account foundUser = getUser(currentUsername);
		if(checkAvailable(newInfo.getUsername())) {
			foundUser.setUsername(newInfo.getUsername());
		} else {	
			throw new ForbiddenException(currentUsername + " tried updating name to "+newInfo.getUsername(), "Username in use");
		}
		foundUser.setPassword(newInfo.getPassword());
		userRepository.flush();
		return foundUser;
	}
	
	public Account deleteUser(String username) {
		Account foundUser = getUser(username);
		userRepository.delete(foundUser);
		return foundUser;
	}

	public Account authenticate(Account user) {
		Account foundUser = getUser(user.getUsername());
		System.out.println(foundUser);
		if (user.getPassword().equals(foundUser.getPassword())) {
			return user;
		} else {
			throw new UnauthorisedException("Unauthorised password for "+user.getUsername(), "Passwords do not match");
		}
	}
}
