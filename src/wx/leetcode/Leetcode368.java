package wx.leetcode;
import java.util.*;
public class Leetcode368 {
    class Solution {
        /**
         368. Largest Divisible Subset
         Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

         Si % Sj = 0 or Sj % Si = 0.

         If there are multiple solutions, return any subset is fine.

         Example 1:

         Input: [1,2,3]
         Output: [1,2] (of course, [1,3] will also be ok)
         **/


        /**
         考虑o(n^2)的DP算法，思路和动态转移方程也是非常明确的。只不过本题不仅求最长解的长度，而且要把这个最长解打印出来。这样的DP问题虽不常见，但也是很容易解决的。除了用一个DP数组记录“状态”外；再用一个prev数组记录当前i元素在Largest-Divisible-Subset里之前的那个元素的位置。回溯的大致代码是：

         while (prev[k]!=k)
         {
         result.push_back(nums[k]);
         k = prev[k];
         }
         **/
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> res=new ArrayList();

            Arrays.sort(nums);
            int[]  dp=new int[nums.length];  // dp[i] 表示 包含nums[i]在内的从0带i 最长的序列长度
            Arrays.fill(dp,1);
            int[] prev=new int[nums.length];  //因为最后我们要得到具体的数组元素 所以我们要回溯
            Arrays.fill(prev,-1);


            for(int i=0;i<nums.length;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]%nums[j]==0){
                        dp[i]=Math.max(dp[j]+1,dp[i]);
                        if(dp[i]==dp[j]+1){
                            prev[i]=j;
                        }
                    }

                }
            }

            int max_len=0;
            int index=-1;
            for(int i=0;i<nums.length;i++){
                if(dp[i]>max_len){
                    max_len=dp[i];
                    index=i;
                }
            }

            while(index!=-1){
                res.add(nums[index]);
                index=prev[index];
            }


            return res;
        }
    }
}
