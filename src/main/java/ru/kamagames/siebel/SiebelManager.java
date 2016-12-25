package ru.kamagames.siebel;

import org.springframework.stereotype.Service;
import ru.kamagames.siebel.ws.SiebelResponse;

/**
 * Created by Timofey on 25.12.2016.
 */
@Service
public class SiebelManager {

    public SiebelResponse findUserBySiebelId(String siebelId) {
        return new SiebelResponse();
    }

}
