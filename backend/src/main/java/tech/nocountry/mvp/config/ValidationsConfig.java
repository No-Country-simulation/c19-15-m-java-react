package tech.nocountry.mvp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.nocountry.mvp.model.validation.UserValidation;

@Configuration
public class ValidationsConfig {

    @Bean
    public UserValidation userValidation() {
        return new UserValidation();
    }
}