package algo.dynamicprogramming;
import java.util.Arrays;

import static java.lang.Integer.max;

public class LongestIncreasingSubsequence {

    static int MAXN =1010;

    public static void main(String[] args){
        int[] a = {-1, 3, 7, 9, 2, 5, 8, 10};
        int[] maxLen = {1, 1, 1, 1, 1, 1, 1, 1};

        for( int i = 2; i <= a.length - 1; ++i) {
            //每次求以第i个数为终点的最长上升子序列的长度
            for( int j = 1; j < i; ++j)
                //察看以第j个数为终点的最长上升子序列
                if( a[i] > a[j] )
                    maxLen[i] = max(maxLen[i],maxLen[j]+1);
        }
        int max = Arrays.stream(maxLen).max().getAsInt();
        System.out.println(max);

    }
}
