package algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    protected void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    protected int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    public static void main(String[] args){

        Integer[] nums = new Integer[]{5, 11, 7, 9, 2, 3, 12,
                8, 6, 1, 4, 10};
        QuickSort testQuick = new QuickSort();
        testQuick.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
