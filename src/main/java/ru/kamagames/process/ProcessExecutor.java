package ru.kamagames.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Service;

/**
 * Created by Timofey on 25.12.2016.
 */
@Service
public class ProcessExecutor {

    private static final Logger log = LoggerFactory.getLogger(ProcessExecutor.class);

    public <T,R> R execute(String methodName, Function<T, Process<R>> processFunction, T request) {
        log.debug("POST " + methodName + " called. Request: " + request);
        R response = processFunction.apply(request).run();
        log.debug(methodName + " finished. Response: " + response);
        return response;
    }
}
