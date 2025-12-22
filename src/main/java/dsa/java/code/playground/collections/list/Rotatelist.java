package dsa.java.code.playground.collections.list;


import dsa.java.code.playground.collections.Print;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Rotatelist {

    @Autowired
    private Print print;

    public void initialMethod(){
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        print.printArrayList(list, "Initial Print");
        rotateList(list);
        print.printArrayList(list, "Rotate List");
        reverseRotateList(list);
        print.printArrayList(list);
    }

    private void rotateList(List<Integer> list){
        Collections.rotate(list, 4);
    }

    private void reverseRotateList(List<Integer> list){
        Collections.rotate(list, -4);
    }
}
