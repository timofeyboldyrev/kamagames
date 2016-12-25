package ru.kamagames.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.kamagames.authService.AuthServiceManager;
import ru.kamagames.exception.BusinessException;
import ru.kamagames.request.FindUserInfoRequest;
import ru.kamagames.siebel.SiebelManager;
import ru.kamagames.siebel.ws.SiebelResponse;

import java.util.Objects;

/**
 * Created by Timofey on 25.12.2016.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindUserInfoProcess implements Process<SiebelResponse> {

    private static final Logger log = LoggerFactory.getLogger(FindUserInfoProcess.class);
    private FindUserInfoRequest request;

    @Autowired
    private AuthServiceManager authServiceManager;
    @Autowired
    private SiebelManager siebelManager;

    public FindUserInfoProcess(FindUserInfoRequest request) {
        this.request = request;
    }

    public SiebelResponse run() {
        try {
            checkInput();
            authServiceManager.checkValidate(request.getSessionId());
            return siebelManager.findUserBySiebelId(request.getUserSiebelId());
        } catch (Exception e) {
            log.error("dsfsdfsd", e); // TODO
            throw new BusinessException("Ошибка работы сервера. Обратитесь в службу технической поддержки");
        }
    }

    private void checkInput() {
        Objects.requireNonNull(request);
        Objects.requireNonNull(request.getSessionId());
        Objects.requireNonNull(request.getUserSiebelId());
    }
}
