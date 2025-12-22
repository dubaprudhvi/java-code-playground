package dsa.java.code.playground.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import dsa.java.code.playground.collections.Print;

@Slf4j
@Service
public class Arraylist {

    @Autowired
    private Print print;

    public void initialFun(){
        List<Integer> list = new ArrayList<>(List.of(1,23,12,2,14,2,1,18,2,1,56,34,1,64,2,64,242,2,1,742,2,75,73,1,58,95,2));
        print.printArrayList(list, "Initial print");
        addTwoIntegers(list);
        print.printArrayList(list, "Added two integers");
        sortArray(list);
        print.printArrayList(list, "Sorted list");
        removeIndex(list);
        print.printArrayList(list, "Remove list");
        reverseOrder(list);
        print.printArrayList(list, "Reverse List");
        removeNumbers(list);
        print.printArrayList(list, "Remove number 1");
        sortArray(list);
        print.printArrayList(list, "Remove index 1 if no is 2");
        removeNumberAndIndex(list);
        print.printArrayList(list, "Remove index 1 if no is 2");
    }

    private void removeNumberAndIndex(List<Integer> list) {
        if(list.size() > 1 && list.get(1) ==2){
            list.remove(1);
        }
    }

    private void removeNumbers(List<Integer> list) {
        list.removeIf(n -> n==1);
    }

    private void removeIndex(List<Integer> list) {
        list.remove(0);
        list.remove(2);
    }

    private void sortArray(List<Integer> list) {
        Collections.sort(list);
    }
    
    private void reverseOrder(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    private void addTwoIntegers(List<Integer> list){
        list.add(24);
        list.add(24);
    }
    
}
