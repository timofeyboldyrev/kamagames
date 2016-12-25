package ru.kamagames.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.kamagames.request.FindUserInfoRequest;

/**
 * Created by Timofey on 25.12.2016.
 */
@Service
public class ProcessFactory {

    @Autowired
    private ApplicationContext context;

    public FindUserInfoProcess findUserInfoProcess(FindUserInfoRequest request) {
        try {
            return context.getBean(FindUserInfoProcess.class, request);
        } catch (Exception e) {
            throw new RuntimeException("", e); // TODO
        }
    }
}
