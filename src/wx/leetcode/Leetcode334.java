package wx.leetcode;

public class Leetcode334 {

    /**
     * 334. Increasing Triplet Subsequence
     * Medium
     *
     * 1414
     *
     * 124
     *
     * Add to List
     *
     * Share
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        /**
         用两个变量 r1, r2 分别记录第一小和第二小的数。然后遍历 nums。只要碰到比 r1 小的数我们就替换掉 r1，碰到比 r1 大但比 r2 小的数就替换 r2。
         只要碰到比 r2 大的数就已经满足题意了。

         **/

        int p1=Integer.MAX_VALUE;
        int p2=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<=p1){
                p1=nums[i];
            }else if(nums[i]<=p2){
                p2=nums[i];
            }else
                return true;

        }
        return false;

    }




    public boolean increasingTriplet2(int[] nums) {

        /**
         * dp 定义状态。dp[i]表述当前元素的最长递增序列长度。
         * 状态转移方程。遍历当前元素前的所有元素，如果nums[j]<nums[i]，则dp[i] = max(dp[i], dp[j]+1)即要么保持不变，要么就是下标为j的元素的最长递增序列的长度加一。
         * 初始状态。所有元素的初始值长度都是1。
         *
         */
        int[] dp=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            dp[i]=1;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }

                if(dp[i]>=3)
                    return true;

            }
        }
        return false;

    }
}
