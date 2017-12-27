package com.systango.springboard;

import com.systango.springboard.domain.repository.FaqRepository;
import com.systango.springboard.service.admin.AdminService;
import com.systango.springboard.service.admin.AdminServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication(scanBasePackages = {"com.systango.springboard"})
@EnableSpringDataWebSupport
public class SpringboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboardApplication.class, args);
    }

    @Bean
    public AdminService adminService(FaqRepository faqRepository) {
        return new AdminServiceImpl(faqRepository);
    }
}
