package algo;

public class QuickSelect<T extends Comparable<T>> extends QuickSort<T>{

    public T select(T[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);

            if (j == k) {
                return nums[k];

            } else if (j > k) {
                h = j - 1;

            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }

    public static void main(String[] args){

        Integer[] nums = new Integer[]{5, 11, 7, 9, 2, 3, 12,
                8, 6, 1, 4, 10};
        QuickSelect testQuick = new QuickSelect();
        System.out.println(testQuick.select(nums, 3));
    }
}
