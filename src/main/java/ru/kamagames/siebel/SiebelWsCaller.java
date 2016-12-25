package ru.kamagames.siebel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

/**
 * Created by Timofey on 25.12.2016.
 */
@Service
public class SiebelWsCaller {

    private static final Logger log = LoggerFactory.getLogger(SiebelWsCaller.class);
    @Autowired
    private URL siebelUrl;

    public void call() {




    }

}
