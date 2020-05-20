package wx.leetcode;

public class Leetcode5 {

    /**
     * 5. Longest Palindromic Substring
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     */
    class Solution {

        /**
         DP
         dp[j][i] means whether the substring from index j to i is a palindromic substring
         **/

        public String longestPalindrome(String s) {
            if(s==null||s.length()==0)return "";

            int maxLen=1;       //  used to get the substring
            int start_index=0; //

            int[][] dp=new int[s.length()][s.length()];




            for(int i=0;i<s.length();i++){
                dp[i][i]=1;   //  ! we need to set single character  true first!  eg: a,b

                for(int j=0;j<i;j++){     // j to i   (from)===>    j+1,i-1
                    /**
                     !!!!  we need to consider if i-j<2
                     eg: str: aa
                     this time: j+1>i-1 !
                     **/
                    if(s.charAt(i)==s.charAt(j)&&(dp[j+1][i-1]==1||i-j<2)) {
                        dp[j][i]=1;
                        if(maxLen<(i-j+1)){
                            start_index=j;
                            maxLen=i-j+1;
                        }

                    }else
                        dp[i][j]=0;



                }
            }

            return s.substring(start_index,start_index+maxLen);

        }
    }
}
