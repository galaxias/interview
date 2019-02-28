package algo.dynamicprogramming;

import static java.lang.Integer.max;

public class LongestCommonSubsequence {
    //时间复杂度O(mn) m,n是两个字串长度
    public static void main(String[] args){

        String s1 = "abcfbc";
        String s2 = "abfcab";
        int[][] maxLen = new int[1000][1000];

        char[] sz1 = s1.toCharArray();
        char[] sz2 = s2.toCharArray();
        int length1 = s1.length();
        int length2 = s2.length();
        for(int i = 0;i <= s1.length(); i ++ )
            maxLen[i][0] = 0;
        for(int j = 0;j <= s2.length(); j ++ )
            maxLen[0][j] = 0;

        for(int i = 1;i <= length1;i ++ ) {
            for(int j = 1; j <= length2; j ++ ) {
                if( sz1[i-1] == sz2[j-1] )
                    maxLen[i][j] = maxLen[i-1][j-1] + 1;
                else
                    maxLen[i][j] = max(maxLen[i][j-1],
                            maxLen[i-1][j]);
            }
        }
        System.out.println(maxLen[length1][length2]);
    }
}
