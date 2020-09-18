package com.sort;

public class ShellSort {
    public static int[] shellSort(int[] arr) {
        for(int i=2;i<arr.length-1;i *= 2){
            int gap = arr.length/i;
            for (int j=0;j<gap;j++){
                insertSort(arr,j,gap);
            }
        }
        return arr;
    }

    public static int[] insertSort(int[] arr,int startIndex,int gap){
        for (int i = startIndex; i < arr.length; i += gap){
            for(int j = i+gap; j > 0 && j < arr.length; j -= gap){
                if (arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }
}
