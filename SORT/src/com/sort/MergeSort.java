package com.sort;

import java.util.Arrays;

public class MergeSort {
    //递归方法
    public static int[] mergeSort(int[] arr, int startIndex, int endIndex){
        if (startIndex == endIndex){
            return arr;
        }
        int midIndex = startIndex + (endIndex-startIndex+1)/2;
        mergeSort(arr,startIndex,midIndex-1);
        mergeSort(arr,midIndex,endIndex);
//        return merge(arr,startIndex,midIndex,endIndex);
        return improvedMerge(arr,startIndex,midIndex,endIndex);
    }

    // 非递归式的归并排序
    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        // 子数组的大小分别为1，2，4，8...
        // 刚开始合并的数组大小是1，接着是2，接着4....
        int i;
        for (i = 2; i < n; i *= 2) {
            //进行数组进行划分
            int left = 0;
            int mid = left + i/2;
            int right = left + i - 1;
            //进行合并，对数组大小为 i 的数组进行两两合并
            while (right < n) {
                // 合并函数和递归式的合并函数一样
                improvedMerge(arr, left, mid, right);
                left = right + 1;
                mid = left + i/2;
                right = left + i - 1;
            }
            // 还有一些被遗漏的数组没合并，千万别忘了
            // 因为不可能每个字数组的大小都刚好为 i
            if (left < n && mid < n) {
                improvedMerge(arr, left, mid, n - 1);
            }
        }
        if(i > n){
            int left = 0;
            int mid = left + i/2;
            improvedMerge(arr, left, mid, n - 1);
        }
        return arr;
    }

    public static int[] merge(int[] arr, int startIndex, int midIndex, int endIndex){
        int temp[] = new int[endIndex - startIndex + 1];
        int leftIndexOffset = 0;
        int rightIndexOffset = 0;
        int currentIndex = 0;
        for(int i = startIndex; i<midIndex; i++){
            for(int j = midIndex + rightIndexOffset; j < endIndex + 1; j++){
                if(arr[j] < arr[i]){
                    temp[currentIndex++] = arr[j];
                    rightIndexOffset++;
                }else{
                    temp[currentIndex++] = arr[i];
                    leftIndexOffset++;
                    break;
                }
            }
        }
        if(midIndex+rightIndexOffset <= endIndex){
            for(int i = midIndex + rightIndexOffset; i <= endIndex; i++){
                temp[currentIndex++] = arr[i];
            }
        }else{
            for(int i = startIndex + leftIndexOffset; i<midIndex; i++){
                temp[currentIndex++] = arr[i];
            }
        }
        for(int i=0; i < temp.length; i++){
            arr[startIndex + i] = temp[i];
        }
        return arr;
    }

    public static int[] improvedMerge(int[] arr,int startIndex,int midIndex,int endIndex){
        int temp[] = new int[endIndex - startIndex + 1];
        int left = startIndex;
        int right = midIndex;
        int currentIndex = 0;
        while(left < midIndex && right <= endIndex){
            temp[currentIndex++]=arr[left]<arr[right]?arr[left++]:arr[right++];
        }

        while(left < midIndex){
            temp[currentIndex++]=arr[left++];
        }
        while(right <= endIndex){
            temp[currentIndex++]=arr[right++];
        }

        for(int i=0; i < temp.length; i++){
            arr[startIndex + i] = temp[i];
        }
        return arr;
    }
}
