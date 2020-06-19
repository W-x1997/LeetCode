package wx.leetcode;

public class Leetcode416 {
    class Solution {
        /**
         416. Partition Equal Subset Sum
         **/
        public boolean canPartition(int[] nums) {
            if(nums==null||nums.length==0)
                return  false;


            int sum=0;
            for(int n:nums){
                sum+=n;
            }

            boolean[] dp=new boolean[sum/2+1]; //注意dp数组的大小

            dp[0]=true;  //dp[i] denotes has always if we could get the subsets that their sum is i



            if(sum%2!=0)return false;

            for(int i=0;i<nums.length;i++){
                for(int j=sum/2;j>=0;j--){
                    if(j>=nums[i]){
                        dp[j]=dp[j]||dp[j-nums[i]];
                    }

                }
            }

            return dp[sum/2];

        }

    }
}
