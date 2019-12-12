package name.christophperrins.users.general.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import name.christophperrins.users.general.mapping.Mapping;
import name.christophperrins.users.general.mapping.ObjectJsonMapping;
import name.christophperrins.users.general.utils.EurekaServices;
import name.christophperrins.users.general.utils.Request;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CoreConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Mapping mapping() {
		return new Mapping();
	}
		
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	public ObjectJsonMapping objectJsonMapping() {
		return new ObjectJsonMapping();
	}
	
	@Bean
	public Request httpRequest() {
		return new Request();
	}
	
	@Bean
	public EurekaServices eurekaServices() {
		return new EurekaServices();
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
	
}
