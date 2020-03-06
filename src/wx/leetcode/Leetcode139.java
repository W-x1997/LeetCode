package wx.leetcode;

import java.util.List;


public class Leetcode139 {

    /***
     *
     *
     *
     * 139. Word Break
     * Medium
     *
     * 3472
     *
     * 189
     *
     * Add to List
     *
     * Share
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note:
     *
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     *
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     *
     *
     *
     *
     */
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean dp[]=new boolean[s.length()+1];
            dp[0]=true;

            for(int i=1;i<=s.length();i++){  // dp[i]表示 从1到i的字符串是否能被分割
                for(int j=0;j<i;j++){
                    if(dp[j]==true&&wordDict.contains(s.substring(j,i))){
                        dp[i]=true;
                        break;
                    }



                }

            }
            return dp[s.length()];



        }
    }
}
