package com.ecommerce.appconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;

@EntityScan("com.sapient.ecommerce.entity")
@EnableTransactionManagement
@EnableJpaRepositories("com.sapient.ecommerce.repository")
@SpringBootApplication(scanBasePackages = {"com.sapient.ecommerce.config"})
public class EstrellaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstrellaApplication.class, args);
    }

}
