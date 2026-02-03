package dsa.java.code.playground.threads.threadsPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dsa.java.code.playground.config.Flags;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ThreadPool {

    @Autowired
    private Flags flags;
    
    @PostConstruct
    private void initialMethod(){
        if(flags.isThreads()){
            executorService();
        }
    }

    private void executorService(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        
        for (int i =0; i < 5; i++){
            executorService.execute(new Processor(i));
        }
        executorService.shutdown();
        log.info("All tasks submitted");
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("All tasks completed");
    }

}
