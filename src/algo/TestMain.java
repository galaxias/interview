package algo;

import java.util.Arrays;

public class TestMain {

    public  static void main(String[] args){
        Integer[] nums = new Integer[]{5, 11, 7, 9, 2, 3, 12,
                8, 6, 1, 4, 10};
        QuickSort testQuick = new QuickSort();
        testQuick.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);

    }
}
