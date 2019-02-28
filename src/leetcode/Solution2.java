package leetcode;

class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        int[] r = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            int a = nums1[i];
            int b = nums2[j];
            if(a <= b){
                r[k++] = a;
                i++;
            }else{
                r[k++] = b;
                j++;
            }
        }
        if(i < nums1.length){
            for(;i < nums1.length; i++){
                r[k++] = nums1[i];
            }
        }
        if(j < nums2.length){
            for(; j < nums2.length; j++){
                r[k++] = nums2[j];
            }
        }
        int mid = r.length / 2;
        if(r.length % 2 == 0){
            result = (double)(r[mid] + r[mid - 1])/2;
        }else{
            result = r[mid];
        }
        return result;

    }

    public static void main(String[] args){

        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};

        Solution2 solution = new Solution2();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
