package ru.kamagames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kamagames.process.ProcessExecutor;
import ru.kamagames.process.ProcessFactory;
import ru.kamagames.request.FindUserInfoRequest;
import ru.kamagames.siebel.ws.SiebelResponse;

/**
 * Created by Timofey on 25.12.2016.
 */
@RestController
@RequestMapping("siebel")
public class SiebelController {

    private static final String METHOD_FIND_USER_INFO = "/findUserInfo";
    @Autowired
    private ProcessFactory processFactory;
    @Autowired
    private ProcessExecutor processExecutor;

    @RequestMapping(METHOD_FIND_USER_INFO)
    public SiebelResponse findUserInfo(FindUserInfoRequest request) {
        return processExecutor.execute(METHOD_FIND_USER_INFO, processFactory::findUserInfoProcess, request);
    }
}
