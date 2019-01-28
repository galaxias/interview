package algo.divideandconquer;

public class ArrangeRight {


    protected static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    //把数组（或数组的一部分）前k大的都弄到最右边
    static void arrangeRight(int[] a, int s, int e, int k)
    {
        if(s >= e)
            return;
        if(k == e-s+1)
            return;
        int i = s;
        int j = e;
        int key = a[s];

        while(i != j)
        {
            while(i < j && a[j] >= key)
                --j;
            swap(a, i, j);
            while(i < j && a[i] <= key)
                ++i;
            swap(a, i, j);
        }
        //如果右边的数刚好为e-i+1为k个
        if(k == e - i + 1)
            return;
            //右边的数大于k个
        else if(k < e - i + 1)
        {
            arrangeRight(a,i+1,e,k);
        }
        //右边的数小于k个，需要左边取出k - (e-i+1)个
        else
        {
            arrangeRight(a,s,i-1,k-e+i-1);
        }
    }

    static int[] a = new int[]{ 93,27,30,2,8,12,2,8,30,89};
    public static void main(String[] args)
    {

        //O(N)时间内先把m大的都弄到数组最右边
        arrangeRight(a,0,a.length-1,4);
        //对这m个数排序
        for(int i = 0;i < a.length; ++i)
            System.out.print(a[i] + ",");
        System.out.println();
        QuickSort.QuickSort(a,a.length-1-4,a.length-1);
        //QuickSort.QuickSort(a,0,a.length-1);
        for(int i = 0;i < a.length; ++i)
            System.out.print(a[i] + ",");
    }
}
