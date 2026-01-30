package dsa.java.code.playground.collections.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsa.java.code.playground.collections.Print;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RemoveDuplicates {

    @Autowired
    private Print print;

    public void initialMethod(){
        List<Integer> list = new ArrayList<>(List.of(1,4,2,1,4,2,2,5,3,2,4));
        print.printArrayList(list, "Initial Array List");
        removeDuplicates(list);
        print.printArrayList(list, "Removed Duplicate values");

        List<Integer> listone = new ArrayList<>(List.of(1,4,3,5,1,9,0,7,5,7,8,6,2,1,4,2,2,5,3,2,4));
        print.printArrayList(listone, "Initial Array List");
        removeDuplicatesWithOutAnotherList(listone);
        print.printArrayList(listone, "Removed Duplicate values");
    }

    private void removeDuplicatesWithOutAnotherList(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> ll = list.iterator();
        while(ll.hasNext()){
            int value = ll.next();
            if(set.contains(value)){
                ll.remove();
            } else {
                set.add(value);
            }
        }
    }

    private void removeDuplicates(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
    }
}
