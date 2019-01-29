package algo.dynamicprogramming;
import static java.lang.Integer.max;

public class NumTrangleDiTuiSolution {

    static int D[][] = {
            {-1},
            {-1,7},
            {-1,3,8},
            {-1,8,1,0},
            {-1,2,7,4,4},
            {-1,4,5,2,6,5}};
    static int maxSum[][] = {
            {-1},
            {-1,-1},
            {-1,-1,-1},
            {-1,-1,-1,-1},
            {-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1}};

    static int n = 5;

    public static void main(String[] args){

        for( int i = 1;i <= n; ++ i ){
            maxSum[n][i] = D[n][i];
        }
        for( int i = n-1; i>= 1; --i ){
            for( int j = 1; j <= i; ++j ){
                maxSum[i][j] =
                        max(maxSum[i+1][j], maxSum[i+1][j+1]) + D[i][j];
            }

        }
        System.out.println(maxSum[1][1]);

    }
}
