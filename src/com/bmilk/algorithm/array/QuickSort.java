package com.bmilk.algorithm.array;

public class QuickSort {
    public static void main(String[] args) {

        QuickSort service = new QuickSort();
        int[] arr = {1,6,9, 10,2,4, 7,1, 3,9,4, 7,3};
        service.quickSort(arr);
        System.out.println(arr);
    }

    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    public void quickSort(int[] arr, int left, int  right){
        if(left >= right ){
            return;
        }
        int l = left;
        int r = right;
       int x = arr[l];
        while (l<r){
            while (l<r && x<= arr[r]){
                r--;
            }
            while (l<r && x>arr[l]){
                l++;
            }
            swap(arr, l, r);
        }
        quickSort(arr, left, l);
        quickSort(arr, r+1, right);
    }

    public void swap(int[] arr, int left, int right){
        int x = arr[left];
        arr[left] = arr[right];
        arr[right] = x;
    }
}
