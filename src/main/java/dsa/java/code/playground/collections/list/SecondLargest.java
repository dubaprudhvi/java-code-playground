package dsa.java.code.playground.collections.list;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecondLargest {
    
    public void initialMethod(){
        List<Integer> list = new ArrayList<>(List.of(1, 22,42,11,42,99,98,55,22,55,22,76,34));
        log.info("{}",secondLargest(list));
    }

    private Integer secondLargest(List<Integer> list){

        if (list == null || list.size() <2)         return null;
        if( list.size() == 2)           return Math.min(list.get(0), list.get(1));

        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        for (Integer i : list){
            if(first < i){
                second = first;
                first = i;
            }
            else if (second < i)  second = i;
        }
        return second;
    }
}
