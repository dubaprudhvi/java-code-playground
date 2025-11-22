package dsa.java.code.playground.sort;

import java.util.Arrays;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import dsa.java.code.playground.config.Sort;

@Slf4j
@Component
class BubbleSort {

    private final Sort sort;

    public BubbleSort(Sort sort) {
        this.sort = sort;
    }

    @PostConstruct
    private void init() {
        initialFun();
    }

    private void initialFun() {
        log.info("Bubble Sort: {}", sort.isConfig());
        if (sort.isConfig()) {
            int[] arr = new int[] { 1, 3, 4, 6, 10, 33, 44, 12, 55, 99 };
            printList(arr);
            int[] arr2 = bubbleSort(arr);
            printList(arr2);
        }
    }

    private int[] bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = arr.length - 1; i >= 0; i--) {
            swapped = false;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    private void printList(int[] arr) {
        String toStringArray = Arrays.toString(arr);
        log.info("Bubble sort: {}", toStringArray);
    }
}
