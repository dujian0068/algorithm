package com.bmilk.algorithm.array;

public class LC852_PeakIndexInMountainArray {

    public static void main(String[] args) {
        LC852_PeakIndexInMountainArray service = new LC852_PeakIndexInMountainArray();

        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        //int i = service.peakIndexInMountainArray(arr);
        int i = service.peakIndexInMountainArray2(arr);
        System.out.println(i);
    }

    public int peakIndexInMountainArray(int[] arr){
        if (arr.length < 2) return arr[0];

        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                res = i;
            }
        }
        return res;
    }

    public int peakIndexInMountainArray2(int[] arr){
        if (arr.length < 2) return arr[0];
        

        int left = 0;
        int right = arr.length-1;
        int mid = left + (right-left)/2;
        while (left<right){
            if(arr[mid-1] < arr[mid] && arr[mid]<arr[mid+1]){
                left = mid;
            } else if(arr[mid-1] > arr[mid] && arr[mid]>arr[mid+1]){
                right = mid;
            }else if(arr[mid-1] < arr[mid] && arr[mid]>arr[mid+1]){
                return mid;
            }
            mid = left + (right-left)/2;
        }
        return 0;
    }
}
