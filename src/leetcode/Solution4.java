package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution4 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++)
            for(int j = i + 1; j < len; j++)
                for(int k = j + 1; k < len; k++){
                    count++;
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                        if(nums[i] == 0 && nums[j]==0 &&nums[k] ==0){
                            System.out.println();
                        }
                        System.out.print(nums[i] + " " + nums[j] + " " + nums[k]);
                        System.out.println();
                        boolean exist = false;
                        for(List<Integer> temp : res){
                            List<Integer> temp1 = new ArrayList<>();
                            for(Integer integer : temp){
                                temp1.add(integer);
                            }
                            boolean r1 = false, r2 = false, r3 = false;
                            for(Integer in : temp1){
                                if(in.intValue() == nums[i]){
                                    r1 = true;
                                }
                            }
                            temp1.remove(new Integer(nums[i]));
                            for(Integer in : temp1){
                                if(in.intValue() == nums[j]){
                                    r2 = true;
                                }
                            }
                            temp1.remove(new Integer(nums[j]));
                            for(Integer in : temp1){
                                if(in.intValue() == nums[k]){
                                    r3 = true;
                                }
                            }
                            temp1.remove(new Integer(nums[k]));
                            exist = r1 && r2 && r3;
                            if(exist){
                                break;
                            }
                        }
                        if(!exist){
                            List<Integer> t = new ArrayList<>();
                            t.add(new Integer(nums[i]));
                            t.add(new Integer(nums[j]));
                            t.add(new Integer(nums[k]));
                            res.add(t);
                        }
                    }
                }
                System.out.println(count);
        return res;

    }


    public static void main(String[] args){
        int[] nums1 = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};

        Solution4 solution4 = new Solution4();
        System.out.println(solution4.threeSum(nums1));
    }

}
