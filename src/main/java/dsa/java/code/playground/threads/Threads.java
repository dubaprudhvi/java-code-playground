package dsa.java.code.playground.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Threads implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger("Threads"); 

    @Override
    public void run(){
        logger.info("--------------------------------------Hello world---------------------");
    }

    
}
