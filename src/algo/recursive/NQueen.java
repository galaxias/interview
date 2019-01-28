package algo.recursive;

public class NQueen {

    private static int N =4;
    private static int[] queenPos = new int[100];
    private static void NQueen(int k) {
        //在0~k-1行皇后已经摆好的情况下，摆第k行及其后的皇后
        int i;
        if( k == N ) { // N 个皇后已经摆好
            for( i = 0; i < N;i ++ )
                System.out.print(queenPos[i] + 1  + " ");
            System.out.println();
            return ;
        }
        for( i = 0; i < N; i ++ ) { //逐尝试第k个皇后的位置
            int j;
            for( j = 0; j < k; j ++ ) {
                //和已经摆好的 k 个皇后的位置比较，看是否冲突
                if( queenPos[j] == i ||
                        Math.abs(queenPos[j] - i) == Math.abs(k-j)) {
                    break; //冲突，则试下一个位置
                }
            }
            if( j == k ) { //当前选的位置 i 不冲突
                queenPos[k] = i; //将第k个皇后摆放在位置 i
                NQueen(k+1);
            }
        } //for( i = 0;i < N;i ++ )
    }

    public static void main(String[] args){

        NQueen(0);
    }
}
