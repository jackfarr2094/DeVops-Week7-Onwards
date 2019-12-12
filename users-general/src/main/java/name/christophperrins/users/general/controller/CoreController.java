package name.christophperrins.users.general.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/core")
public class CoreController {

	@RequestMapping(method = RequestMethod.GET)
	public String greeting() {
		return "Running";
	}
	
}
