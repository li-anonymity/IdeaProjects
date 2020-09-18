package com.sort;

import java.util.ArrayList;

public class RadioSort {
    public static int[] radioSort(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for(int i=1; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
            if (max < arr[i]){
                max = arr[i];
            }
        }
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(10);//构造函数指定容量，可以避免不断扩容导致性能损失，但如果不指定容量，初默认容量也为10
        System.out.println(bucketList.size());
        for (int i=0; i < arr.length; i++){
            bucketList.add(new ArrayList<Integer>());
        }

        int radio = 1;
        while(max/radio != 0){
            for (int i=0; i < arr.length; i++){
                bucketList.get((arr[i]/radio)%10).add(arr[i]);
            }
            radio *= 10;
            int k = 0;
            for (int i = 0; i < 10; i++){
                for(int j=0;j<bucketList.get(i).size();j++){
                    arr[k++] = bucketList.get(i).get(j);
                }
                bucketList.get(i).clear();
            }
        }
        return arr;
    }
}
