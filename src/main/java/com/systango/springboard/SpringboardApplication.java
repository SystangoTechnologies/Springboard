package com.systango.springboard;

import com.systango.springboard.domain.repository.ApplicationUserRepository;
import com.systango.springboard.domain.repository.FaqRepository;
import com.systango.springboard.domain.repository.WalletRepository;
import com.systango.springboard.service.admin.AdminService;
import com.systango.springboard.service.admin.AdminServiceImpl;
import com.systango.springboard.service.payment.PaymentService;
import com.systango.springboard.service.payment.PaymentServiceImpl;
import com.systango.springboard.service.user.UserService;
import com.systango.springboard.service.user.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Bean
    public UserService userService(ApplicationUserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public PaymentService paymentService(ApplicationUserRepository applicationUserRepository, WalletRepository walletRepository) {
        return new PaymentServiceImpl(applicationUserRepository, walletRepository);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
