package name.christophperrins.users.general.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

public class EurekaServices {

	@Autowired
	private EurekaClient eurekaClient;

	public String getBaseUrlOfMicroService(String applicationName) {
		InstanceInfo accountServiceInfo = eurekaClient.getApplication(applicationName).getInstances().get(0);
		String ip = accountServiceInfo.getIPAddr();
		String port = String.valueOf(accountServiceInfo.getPort());
		return "http://" + ip + ":" + port + "/";
	}

}
