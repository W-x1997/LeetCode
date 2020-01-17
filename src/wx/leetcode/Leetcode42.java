package wx.leetcode;

/**
 *
 * Leetcode 42
 * trapping-rain-water[盛水量]
 *
 *思路
 * 求盛下水的总和。
 * 求出序列中最高的值和对应下标，然后分两部分。
 * 左边用lMax表示当前最大值，只要低于此值的都可以存水，存水量为lMax-A[i]；当大于lMax时更新其值。右边同理。
 */
import java.util.*;
public class Leetcode42 {

    public class Solution {
        public int trap(int[] A) {
            if(A == null || A.length <= 2)
                return 0;

            int index = 0;
            int maxV = A[0];
            for(int i=1; i<A.length; i++){
                if(maxV < A[i]){
                    maxV = A[i];
                    index = i;
                }
            }

            int sum = 0;
            int lMax = A[0];
            for(int i=1; i<index; i++){
                if(lMax < A[i]){
                    lMax = A[i];
                }else{
                    sum += (lMax - A[i]);
                }
            }

            int rMax = A[A.length-1];
            for(int i=A.length-2; i>index; i--){
                if(rMax < A[i]){
                    rMax = A[i];
                }else{
                    sum += (rMax - A[i]);
                }
            }

            return sum;
        }
    }
}
