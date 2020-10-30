package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.example")
public class SpringBootHibernateApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootHibernateApplication.class, args);
    }
}