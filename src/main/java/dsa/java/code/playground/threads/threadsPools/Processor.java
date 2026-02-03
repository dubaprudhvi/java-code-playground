package dsa.java.code.playground.threads.threadsPools;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Processor implements Runnable{
    private int id;
    public Processor(int id){
        this.id = id;
    }

    public void run(){
        log.info("Thread started : {}",id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Thread completed : {}",id);
    }
    
}
