package dsa.java.code.playground.threads;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Threads implements Runnable{

    @Override
    public void run(){
        log.info("--------------------------------------Hello world---------------------");
    }
    
}
