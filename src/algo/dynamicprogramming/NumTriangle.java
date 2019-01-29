package algo.dynamicprogramming;

import sun.reflect.generics.tree.VoidDescriptor;

import static java.lang.Integer.max;

public class NumTriangle {

    static int D[][] = {
            {-1},
            {-1,7},
            {-1,3,8},
            {-1,8,1,0},
            {-1,2,7,4,4},
            {-1,4,5,2,6,5}};
    static int n = 5;
    //如果采用递规的方法，深度遍历每条路径，
    // 存在大量重复计算。则时间复杂度为 2n,对于 n = 100 行，肯定超时。
    //如果每算出一个MaxSum(r,j)就保存起来，下次用到其值的时候直接取用，
    // 则可免去重复计算。那么可以用O(n2)时间完成计算。因为三角形的数字总数是 n(n+1)/2
    static int MaxSum(int i, int j){
        if(i==n)
            return D[i][j];
        int x = MaxSum(i+1,j);
        int y = MaxSum(i+1,j+1);
        return max(x,y)+D[i][j];
    }

    public static void main(String[] args){
        System.out.println(MaxSum(1,1));

    }
}
