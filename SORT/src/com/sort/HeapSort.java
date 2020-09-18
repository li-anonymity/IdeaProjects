package com.sort;

public class HeapSort {
    public static int[] heapSort(int[] arr){
        String heapType = "max";
        buildHeap(arr,arr.length,heapType);
        for(int length = arr.length;length>1;length--){
            int temp = arr[0];
            arr[0] = arr[length-1];
            arr[length-1] = temp;
            downAdjust(arr,0,length-1,heapType);
        }
        return arr;
    }

    public static int[] upAdjust(int[] arr,String heapType){
        int child = arr.length - 1;
        int parent = (child -1)/2;
        int temp = arr[child];
        while(child > 0){
            if (heapType.equals("mix") && temp < arr[parent]){
                arr[child] = arr[parent];
                child = parent;
                parent = (child-1)/2;
            }else if(heapType.equals("max") && temp > arr[parent]){
                arr[child] = arr[parent];
                child = parent;
                parent = (child-1)/2;
            }
        }
        arr[child] = temp;
        return arr;
    }

    public static int[] downAdjust(int[] arr,int parent,int length,String heapType){
        int temp = arr[parent];
        int child = 2*parent + 1;
        while(child < length) {
            if (child + 1 < length) {
                if (heapType.equals("mix")){
                    if (arr[child] > arr[child + 1]) {
                        child++;
                    }
                }else{
                    if (arr[child] < arr[child + 1]) {
                        child++;
                    }
                }

            }
            if (heapType.equals("mix")){
                if (arr[child] >= temp){
                    break;
                }
            }else{
                if (arr[child] <= temp){
                    break;
                }
            }
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
        return arr;
    }

    public static int[] buildHeap(int[] arr,int length,String heapType){
        for(int parent = (length - 2)/2;parent>=0;parent--){
            downAdjust(arr,parent,length,heapType);
        }
        return arr;
    }
}
