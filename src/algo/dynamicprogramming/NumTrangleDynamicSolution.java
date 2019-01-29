package algo.dynamicprogramming;
import static java.lang.Integer.max;

public class NumTrangleDynamicSolution {

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

    //数字三角形的记忆递归型动归程序
    static int MaxSum(int i, int j){
        if( maxSum[i][j] != -1 )
            return maxSum[i][j];
        if(i==n)
            maxSum[i][j] = D[i][j];
        else {
            int x = MaxSum(i+1,j);
            int y = MaxSum(i+1,j+1);
            maxSum[i][j] = max(x,y)+
                    D[i][j];
        }
        return maxSum[i][j];
    }

    public static void main(String[] args){
        System.out.println(MaxSum(1,1));

    }

}
