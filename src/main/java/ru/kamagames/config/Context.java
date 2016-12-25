package ru.kamagames.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * Created by Timofey on 25.12.2016.
 */
@Configuration
public class Context {

    public static final String URL_AUTH_SERVICE_VALIDATE = "url.auth-service.validate";
    @Bean @Qualifier(URL_AUTH_SERVICE_VALIDATE)
    public URL urlAuthServiceValidate(@Value("${auth-service.address}") String authServiceAddress,
                                      @Value("${auth-service.validate}") String validateMethod) throws MalformedURLException {
        Objects.requireNonNull(authServiceAddress);
        Objects.requireNonNull(validateMethod);
        return new URL(authServiceAddress + validateMethod);
    }

}
