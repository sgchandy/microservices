package com.rest.webservices.restfulws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

//Configuration and enable swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    public static final Contact DEFAULT_CONTACT = new Contact("Sunny Chandy", "", "sgchandy@hotmail.com");

    private static final ApiInfo DEFAULT_API_INFO  = new ApiInfo("Api Documentation for Restful Webservice", "Api Documentation",
            "1.0", "urn:tos",DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());


    //Bean - Docket
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }
        //Swagger2
            //All the paths
            //All the apis


}
