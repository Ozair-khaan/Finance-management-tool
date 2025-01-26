package com.finance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FinanceManagementToolApplication implements CommandLineRunner {

    private final ApplicationContext context;

    public FinanceManagementToolApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(FinanceManagementToolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String port = context.getEnvironment().getProperty("local.server.port");
        System.out.println("Tomcat started on port : " + port);
    }
}
