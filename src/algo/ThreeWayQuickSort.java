package algo;

import java.util.Arrays;

public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    @Override
    protected void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }

    public static void main(String[] args){

        Integer[] nums = new Integer[]{5, 11, 11, 11, 11, 3, 12,
                8, 6, 1, 4, 10};
        ThreeWayQuickSort testThreeWayQuick = new ThreeWayQuickSort();
        testThreeWayQuick.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
