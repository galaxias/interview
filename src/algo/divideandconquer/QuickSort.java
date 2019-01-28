package algo.divideandconquer;

public class QuickSort {

    protected static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void QuickSort(int[] a, int s, int e)
    {
        if( s >= e)
            return;
        int k = a[s];
        int i = s, j = e;
        while( i != j ) {
            while( j > i && a[j] >= k )
                --j;
            swap(a, i, j);
            while( i < j && a[i] <= k )
                ++i;
            swap(a, i, j);
        } //处理完后，a[i] = k
        QuickSort(a,s,i-1);
        QuickSort(a,i+1,e);
    }

    static int[] a = new int[]{ 93,27,30,2,8,12,2,8,30,89};
    public static void main(String[] args)
    {
        QuickSort(a,0,a.length-1);
        for(int i = 0;i < a.length; ++i)
            System.out.print(a[i] + ",");
    }
}
