package com.sort;

public class CountSort {
    public static int[] countSort(int[] arr){
        //获取数组中最大和最小值max和min
        int max=arr[0];
        int min=arr[0];
        for(int i=1; i<arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
            if (min > arr[i]){
                min = arr[i];
            }
        }
        //新建一个大小为max-min+1的数组
        int[] temp = new int[max-min+1];
        //遍历arr数组将值为min+新数组下标的值进行统计累加
        for (int i=0; i<arr.length; i++){
            temp[arr[i]-min]++;
        }
        //重新将新数组中的统计值按照顺序放回去
        int j = 0;
        for(int i=0; i<temp.length; i++) {
            for (int p = 0; p < temp[i]; p++) {
                arr[j++] = i + min;
            }
        }
        return arr;
    }
}
