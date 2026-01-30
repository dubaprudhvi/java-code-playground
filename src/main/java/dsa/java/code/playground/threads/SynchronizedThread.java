package dsa.java.code.playground.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dsa.java.code.playground.config.Flags;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SynchronizedThread{

    private int counter = 0;

    @Autowired
    private Flags flags;

    @PostConstruct
    public void initialMethod(){
        if(flags.isThreads()){
            threadImplementation();
        }
    }

    public void threadImplementation(){
        /**
        Thread t1 = new Thread(new Runnable() {
            public void run(){
                for(int i =0; i<1000; i++){
                    counter();
                } 
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run(){
                for(int i =0; i<1000; i++){
                    counter();
                } 
            }
        });
        */
        
        Thread t1 = new Thread(() -> {
            for(int i =0; i<1000; i++){
                counter();
            } 
        });

        Thread t2 = new Thread(() -> {
            for(int i =0; i<1000; i++){
                counter();
            }
        });

        t1.start();

        log.info("Counter: {}",counter);

        try {
            t1.join();
            log.info("Counter: {}",counter);
        } catch (InterruptedException e) {
            log.error("Join interrupted", e);
            Thread.currentThread().interrupt();
        }
        t2.start();
        log.info("Counter: {}",counter);

        try {
            t2.join();
            log.info("Counter: {}",counter);
        } catch (InterruptedException e) {
            log.error("Join interrupted", e);
            Thread.currentThread().interrupt();
        }
        log.info("Counter: {}",counter);
        log.info("Time {}",System.currentTimeMillis());
    }

    public synchronized void counter(){
        counter++;
    }
    
}
