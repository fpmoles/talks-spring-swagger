package com.frankmoley.talks.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

	@Bean
    public Docket docket(){

	    return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.frankmoley.talks.swagger.webservice"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){
        String title = "Personal Task Services";
        String description = " A set of services to show people and their tasks";
        String version = "1.0.0";
        String termsOfServiceUrl= null;
        Contact contact = new Contact("Frank Moley", "github.com/fpmoles", "frankmoley@gmail.com");
        String license = "MIT";
        String licenseUrl = "https://github.com/fpmoles/talks-spring-swagger/blob/master/LICENSE";
        Collection<VendorExtension> vendorExtensions = Collections.emptyList();
        return new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions);
    }
}
