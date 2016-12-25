package ru.kamagames.authService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kamagames.api.ApiCaller;

import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Timofey on 25.12.2016.
 */
@Service
public class AuthServiceManager {

    private static final String HEADER_SESSION_ID = "sessionID";
    private static final String ADMIN_ROLE = "admin";
    @Autowired
    private ApiCaller apiCaller;
    @Autowired
    private URL authServiceUrl;

    public void checkValidate(String sessionId) {
        ValidateResponse validateResponse;
        try {
            Map<String, String> header = Collections.singletonMap(HEADER_SESSION_ID, sessionId);
            validateResponse = apiCaller.sendGet(authServiceUrl, header, ValidateResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("ыфвавыыва", e); // TODO
        }
        if(validateResponse == null || !validateResponse.isSuccess() ||
                Stream.of(validateResponse.getRoles()).noneMatch(ADMIN_ROLE::equals)) {
            throw new RuntimeException("Пользователь не прошёл валидацию. Ответ сервера: " + validateResponse + ". "); // TODO
        }
    }

}
