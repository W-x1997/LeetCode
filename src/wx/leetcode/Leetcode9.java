package wx.leetcode;

public class Leetcode9 {
    class Solution {
        /**
         9. Palindrome Number

         Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
         **/

        public boolean isPalindrome(int x) {
            String str=String.valueOf(x);
            int left=0;
            int right=str.length()-1;


            while(left<right){
                if(str.charAt(left)!=str.charAt(right))
                    return false;

                left++;
                right--;
            }

            return true;
        }
    }
}
