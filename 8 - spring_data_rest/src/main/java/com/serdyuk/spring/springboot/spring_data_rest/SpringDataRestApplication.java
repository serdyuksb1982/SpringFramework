package com.serdyuk.spring.springboot.spring_data_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**+
 * Spring Boot Actuator предоставляет готовые конечные точки
 * (endpoints), с помощью которых мониторится приложнеие
 * /actuator/info - информация о приложении
 * /actuator/beans - инофрмация о всех бинахб зарегистрированных в Spring Container-e
 * /actuator/mapping - иоформация о всех Mapping-ах
 * /actuator/health - информация о статусе приложения
 */
public class SpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

}
