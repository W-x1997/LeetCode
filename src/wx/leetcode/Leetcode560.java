package wx.leetcode;

import java.util.HashMap;

public class Leetcode560 {
    /**
     *
     * Solution 1
     *  本题求在一个数组中，连续子序列和为k的子序列（子序列长度为1-n均可，其中n为数组的大小）的个数。
     * 解题的思路是用一个sum记录前i个数的和，若sum[i]-sum2[j]=k，则说明下标从j到i-1的数的和为k，
     * 用两层for循环的思路易求得本题的答案。时间复杂度为o(n^2)。
     *
     * 但是！ 有更好的答案！有o(n)的思路！用hashmap！ 如下
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return 0;
        }

        int res=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k)
                    res++;
            }
        }

        return res;

    }


    /**
     *  Solution2
     *  o（n）
     *
     *
     * 假设我们令P[i] = A[0] + A[1] + ... + A[i-1]和P[j] = A[0] + A[1] + ... + A[j-1]，那么P[j] - P[i] = A[i] + A[i+1] + ... + A[j-1]。
     * 如果P[j] - P[i] == S的话，那么[i,j]就是我们需要的区间。所以我们对于每个j，我们只要计算有多少个i使得P[j] - P[i] == S，
     * 这样我们就得到了以P[j]作为右区间并且和为S的区间数。对于A中的每个元素都做同样的处理，最有将所有的结果相加即可。
     *
     * 具体实现上，我们通过hash_map记录P[j]。初始化的时候要注意一个细节，对于 map.put(0,1)。为什么？因为当P[j]==S时，P[i]=0并且此时我们的res=1。

     */

    public int subarraySum2(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return 0;
        }


        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);  /**  ！！！！Point！
         **/

        int res=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(map.containsKey(sum-k))
                res=res+map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return res;

    }
}


