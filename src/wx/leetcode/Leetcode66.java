package wx.leetcode;

public class Leetcode66 {
    class Solution {
        /**
         66. Plus One
         Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

         The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

         You may assume the integer does not contain any leading zero, except the number 0 itself.

         Example 1:

         Input: [1,2,3]
         Output: [1,2,4]
         Explanation: The array represents the integer 123.

         **/

        public int[] plusOne(int[] digits) {

            /**
             以此往前进位即可
             **/
            if(digits==null||digits.length==0)
                return digits;

            int n=digits.length;

            for(int i=n-1;i>=0;i--){
                if(digits[i]==9){
                    digits[i]=0;
                }else{
                    digits[i]++;
                    return digits;
                }
            }
            //如果到达次处，说明一定溢出  直接digits[0]=1即可
            digits=new int[n+1];
            digits[0] = 1;
            return digits;

        }
    }
}
