package wx.leetcode;

public class Leetcode647 {
    class Solution {
        /**
         647. Palindromic Substrings
         Given a string, your task is to count how many palindromic substrings in this string.

         The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

         Example 1:

         Input: "abc"
         Output: 3
         Explanation: Three palindromic strings: "a", "b", "c".
         **/


        /**
         和 5. Longest Palindromic Substring 一模一样 经典的dp
         注意边界
         **/
        public int countSubstrings(String s) {
            if(s==null||s.length()==0)
                return 0;
            int res=0;


            int[][] dp=new int[s.length()][s.length()];//dp[j][i] means whether the substring [j,i] is palinadromic

            for(int i=0;i<s.length();i++){
                dp[i][i]=1;

                for(int j=0;j<i;j++){
                    if(s.charAt(i)==s.charAt(j)&&(dp[j+1][i-1]==1||i-j<2)){
                        dp[j][i]=1;
                        res=res+1;
                    }else
                        dp[j][i]=0;

                }

            }

            return res+s.length();


        }
    }
}
