package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LC3072_ResultArray {

    public int[] resultArray(int[] nums) {
        int[] cn = nums.clone();
        Arrays.sort(cn);

        int n = cn.length;
        BinaryIndexedTree tree1 = new BinaryIndexedTree(n);
        BinaryIndexedTree tree2 = new BinaryIndexedTree(n);

        tree1.update(Arrays.binarySearch(cn, nums[0])+1, 1);
        tree2.update(Arrays.binarySearch(cn, nums[1])+1, 1);

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int i=1;
        int j =1;
        arr1[0] = nums[0];
        arr2[0] = nums[1];

        for (int k = 2; k<n; ++k){
            int x = Arrays.binarySearch(cn, nums[k])+1;
            int a = i- tree1.query(x);
            int b = j-tree2.query(x);
            if(a>b){
                arr1[i++] = nums[k];
                tree1.update(x, 1);
            }else if(a<b){
                arr2[j++] = nums[k];
                tree2.update(x, 1);
            }else if(i <=j){
                arr1[i++] = nums[k];
                tree1.update(x, 1);
            }else {
                arr2[j++] = nums[k];
                tree2.update(x, 1);
            }
        }

        for (int k = 0; k<j; ++k){
            arr1[i++] = arr2[k];
        }
        return arr1;

    }
}

class BinaryIndexedTree {
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n){
        this.n = n;
        c = new int[n+1];
    }
    public void update(int x, int val){
        for (; x<=n; x += x & -x){
            c[x] += val;
        }
    }
    public int query(int x){
        int sum = 0;
        for (; x>0; x-= x&-x){
            sum += c[x];
        }
        return sum;
    }
}
