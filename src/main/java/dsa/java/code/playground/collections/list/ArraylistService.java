package dsa.java.code.playground.collections.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dsa.java.code.playground.config.Flags;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArraylistService {

    @Autowired
    private Flags flags;

    @Autowired
    private Arraylist arraylist;

    @Autowired
    private RemoveDuplicates removeDuplicates;

    @Autowired
    private SecondLargest secondLargest;

    @Autowired
    private Rotatelist rotatelist;

    @PostConstruct
    private void init(){
        if(flags.isCollection()){
            arraylist.initialFun();
            removeDuplicates.initialMethod();
            secondLargest.initialMethod();
            rotatelist.initialMethod();
        }
    }
    
}
