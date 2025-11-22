package dsa.java.code.playground.threads;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class ThreadRunner {

    private final Threads threads;

    public ThreadRunner(Threads threads){
        this.threads = threads;
    }

    // @PostConstruct
    public void startThread() throws InterruptedException{
        Thread thread = new Thread(threads);
        thread.start();
        thread.join();
    }
}
