package wx.leetcode;

public class Leetcode1013 {
    /**
     * 1013. Partition Array Into Three Parts With Equal Sum
     * Given an array A of integers, return true if and only if we can partition the array into
     * three non-empty parts with equal sums.
     *
     * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] +
     * ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
     *
     *
     */
    class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            if(A==null||A.length==0)
                return false;

            int sum=0;
            for(int i=0;i<A.length;i++){
                sum=sum+A[i];
            }

            if(sum%3!=0)
                return false;
            int part_sum=sum/3;

            int cur_sum=0;
            int total=0;
            for(int i=0;i<A.length;i++){
                cur_sum=cur_sum+A[i];
                if(cur_sum==part_sum){
                    total++;
                    cur_sum=0;
                }
            }

            if(total>=3)
                return true;
            return false;

        }
    }
}
