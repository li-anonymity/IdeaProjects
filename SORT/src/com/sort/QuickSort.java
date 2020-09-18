package com.sort;

public class QuickSort {
    public static int[] quickSort(int[] arr, int startIndex, int endIndex ){
        if(startIndex >= endIndex){
            return arr;
        }
        int midIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex ; i++){
            if (arr[i] < arr[midIndex]){
                for(int j = i; j > midIndex; j--){
                    int temp = arr [j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                midIndex++;
            }
        }
        quickSort(arr, startIndex,midIndex-1);
        quickSort(arr, midIndex + 1, endIndex);
        return arr;
    }
}
