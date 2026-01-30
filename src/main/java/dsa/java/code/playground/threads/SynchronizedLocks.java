package dsa.java.code.playground.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import dsa.java.code.playground.config.Flags;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SynchronizedLocks {

    private Random random = new Random();
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    @Autowired
    private Flags flags;

    @PostConstruct
    public void threadImplementation(){
        if(flags.isThreads()){
            initialMethod();
        }
    }

    private List<Integer> list1 =  new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void stageOne(){
        synchronized(obj1){
            try{
                Thread.sleep(1);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo(){
        synchronized(obj2){
            try{
                Thread.sleep(1);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }
    
    public void initialMethod(){
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for(int i =0; i<1000; i++){
                stageOne();
                stageTwo();
            }
        });
        t1.start();
        
        Thread t2 = new Thread(() -> {
            for(int i =0; i<1000; i++){
                stageOne();
                stageTwo();
            }
        });
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("List one : {}, List two : {}", list1.size(), list2.size());
        log.info("Time in milliseconds {}",end-start);
        
    }
    
}
