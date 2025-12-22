package dsa.java.code.playground.collections;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Print {

    public void printArrayList(List<Integer> list){
        log.info("{}",list);
    }

    public void printArrayList(List<Integer> list, String s){
        log.info("{}: {}",s, list);
    }
}
