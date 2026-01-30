package dsa.java.code.playground.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dsa.java.code.playground.config.Flags;
import jakarta.annotation.PostConstruct;

@Component
public class ThreadRunner {

    private final Threads threads;

    @Autowired
    private Flags flags;

    public ThreadRunner(Threads threads){
        this.threads = threads;
    }

    @PostConstruct
    public void startThread() throws InterruptedException{
        if(flags.isThreads()){
            Thread thread = new Thread(threads);
            thread.start();
            thread.join();
        }
    }
}
