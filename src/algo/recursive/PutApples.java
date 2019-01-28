package algo.recursive;

public class PutApples {

    static int f(int m,int n) {
        if( n > m )
            return f(m,m);
        if( m == 0)
            return 1;
        if( n <= 0 )
            return 0;
        return f(m,n-1) + f(m-n,n);
    }
    public static void main(String[] args) {
        int m = 10,n = 5;
        System.out.println(f(m,n));
    }
}
