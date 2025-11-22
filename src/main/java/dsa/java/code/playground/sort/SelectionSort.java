package dsa.java.code.playground.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
class SelectionSort {

    private static final Logger logger = LoggerFactory.getLogger("SelectionSort"); 

    @Value("${dsa.sort:false}")
    private boolean dsaSort;

    @PostConstruct
    public void init(){
        initialFun();
    }

    private void initialFun(){
        logger.info("DSA SORT: {}",dsaSort);
        if(dsaSort){
            int[] arr = new int[]{10,80,20,33,11,45};
            print(arr);
            int[] arr1 = selectionSort(arr);
            print(arr1);
        }
    }

    private static int[] selectionSort(int[] arr){
        int temp,min,i,j;
        for(i=0; i<arr.length; i++){
            min =i;
            for(j=i; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    private static void print(int[] arr){
        String toStringArray = Arrays.toString(arr);
        logger.info("Array elements: {}", toStringArray);
    }
    
}
