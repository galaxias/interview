package algo;

import java.util.Arrays;

public class Selection<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args){
        Selection s = new Selection();
        Integer[] nums = new Integer[]{3, 5, 2, 4, 1};
        s.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);//System.out.println(nums);
    }
}
