package dsa.java.code.playground.sort;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import dsa.java.code.playground.config.Flags;

@Slf4j
@Component
class SelectionSort {

    @Autowired
    private Flags flags;

    @PostConstruct
    public void init() {
        initialFun();
    }

    private void initialFun() {
        log.info("Selection Sort: {}", flags.isSort());
        if (flags.isSort()) {
            int[] arr = new int[] { 10, 80, 20, 33, 11, 45 };
            print(arr);
            int[] arr1 = selectionSort(arr);
            print(arr1);
            int[] arr3 = selectionSortThree(arr);
            print(arr3);
        }
    }

    private int[] selectionSortThree(int[] arr){
        for(int i =0; i< arr.length; i++){
            int min = i;
            for(int j=i; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp; 
        }
        return arr;
    }

    private static int[] selectionSort(int[] arr) {
        int temp;
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    private static void print(int[] arr) {
        String toStringArray = Arrays.toString(arr);
        log.info("Selection sort: {}", toStringArray);
    }

}
