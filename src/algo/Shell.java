package algo;

import java.util.Arrays;

public class Shell<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {

        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
    public static void main(String[] args){

        Integer[] nums = new Integer[]{5, 11, 7, 9, 2, 3, 12,
        8, 6, 1, 4, 10};
        Shell testShell = new Shell();
        testShell.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
