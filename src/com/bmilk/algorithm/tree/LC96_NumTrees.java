package com.bmilk.algorithm.tree;

/**
 * @link https://leetcode.cn/problems/unique-binary-search-trees/
 * <p>
 * f(n) 代表以节点n为根节点有多少种子树
 * g(n) 代表n个节点可以组成多少个不同的二叉搜索树
 * 循环遍历每一个值，把这个值当成树的根节点
 * 则对于第i个值的子树个数  f(i) = g(i-1) * g(n-i-1)
 * g(n)=f(1)+f(2)+...+f(n-1)
 */
public class LC96_NumTrees {

    public static void main(String[] args) {
        int n = 3;
        LC96_NumTrees numTrees = new LC96_NumTrees();
        int result = numTrees.numTrees(4);
        System.out.println(result);
    }


    public int numTrees(int n) {
        if (0 == n || 1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        int[] numTreesList = new int[n + 1];
        numTreesList[0] = 1;
        numTreesList[1] = 1;
        numTreesList[2] = 2;

        for (int i = 3; i <= n; i++) {
            numTreesList[i] = 0;

            for (int j = 0; j < i; j++) {
                numTreesList[i] += (numTreesList[j] * numTreesList[i - 1 - j]);
            }
        }
        return numTreesList[n];

    }
}
