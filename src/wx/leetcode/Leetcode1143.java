package wx.leetcode;

public class Leetcode1143 {
    class Solution {
        /**
         1143. Longest Common Subsequence
         Given two strings text1 and text2, return the length of their longest common subsequence.

         A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.



         If there is no common subsequence, return 0.
         **/
        public int longestCommonSubsequence(String text1, String text2) {
            if(text1==null||text2==null)
                return 0;


            /**
             dp[i][j] stands for length of LCS between text1 up to i and text2 up to j.

             If text1.charAt(i) == text2.charAt(j), dp[i][j] = dp[i-1][j-1] + 1.

             Otherwise, dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]).
             **/
            int len1=text1.length();
            int len2=text2.length();

            int[][] dp=new int[len1+1][len2+1];

            for(int i=0;i<len1;i++){
                for(int j=0;j<len2;j++){
                    if(text1.charAt(i)==text2.charAt(j)){
                        dp[i+1][j+1]=dp[i][j]+1;
                    }else{
                        dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                    }

                }
            }
            return dp[len1][len2];


        }

    }
}
