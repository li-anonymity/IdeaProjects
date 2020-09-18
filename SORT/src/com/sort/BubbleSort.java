package com.sort;

public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        for (int i = arr.length; i > 0; i--){
            for(int j = 0; j+1 < i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public static int[] improvedBubbleSort(int[] arr){
        for (int i = arr.length; i > 0; i--){
            boolean isSorted = true;
            for(int j = 0; j+1 < i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
        return arr;
    }
}
