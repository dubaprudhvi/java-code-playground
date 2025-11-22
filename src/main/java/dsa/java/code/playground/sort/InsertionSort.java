package dsa.java.code.playground.sort;

import java.util.Arrays;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import dsa.java.code.playground.config.Sort;
import jakarta.annotation.PostConstruct;

@Slf4j
@Component
class InsertionSort {

    private final Sort sort;

    public InsertionSort(Sort sort) {
        this.sort = sort;
    }

    @PostConstruct
    private void init() {
        initialFun();
    }

    private void initialFun() {
        log.info("Insertion Sort: {}", sort.isConfig());
        if (sort.isConfig()) {
            int[] arr = new int[] { 10, 22, 12, 44, 66, 22, 11, 33, 53, 2, 46, 14 };
            printList(arr);
            int[] arr2 = insertionSort(arr);
            printList(arr2);
        }
    }

    private int[] insertionSort(int[] arr) {
        for(int i=0; i<arr.length; i++){
            int j =i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }

    private void printList(int[] arr) {
        log.info("Insertion Sort: {}", Arrays.toString(arr));
    }
}