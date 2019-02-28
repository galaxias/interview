package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumTwoPointer {

    public List<List<Integer>> count(int[] nums) {
        int N = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < N - 2; i++) {
            int l = i + 1, h = N - 1, target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (l < h) {
                int sum = nums[l] + nums[h];
                if (sum == target) {
                    List<Integer> t = new ArrayList<>();
                    t.add(new Integer(nums[i]));
                    t.add(new Integer(nums[l]));
                    t.add(new Integer(nums[h]));
                    res.add(t);
                    //cnt++;
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    while (l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                } else if (sum < target) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};

        ThreeSumTwoPointer solution4 = new ThreeSumTwoPointer();
        System.out.println(solution4.count(nums1));
    }
}
