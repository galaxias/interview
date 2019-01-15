package algo;

import java.util.Arrays;

public class Bubble<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean hasSorted = false;
        for (int i = N - 1; i > 0 && !hasSorted; i--) {
            hasSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args){
        Bubble s = new Bubble();
        Integer[] nums = new Integer[]{3, 5, 2, 4, 1};
        s.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);//System.out.println(nums);
    }
}
