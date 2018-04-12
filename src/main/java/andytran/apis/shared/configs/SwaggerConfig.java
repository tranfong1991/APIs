package andytran.apis.shared.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig { 
	
    @Bean
    public Docket api() {    	
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .select() 
          .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
          .build();
    }
    
    private ApiInfo apiInfo() {
    	return new ApiInfo("Andy's RESTful APIs", 
    			"Provides APIs for string and number", 
    			"1.0", 
    			"Terms of service", 
    			new Contact("Andy Tran", "http://tranandy.com", "andytran@aggienetwork.com"), 
    			null, null);
    }
    
}
