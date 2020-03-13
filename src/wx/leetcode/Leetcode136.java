package wx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode136 {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return all possible palindrome partitioning of s.
     *
     * Example:
     *
     * Input: "aab"
     * Output:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     *
     *
     *
     *
     * //
     * 分割出 所有的回文串子
     * recursive+dfs
     *
     *
     *
     */

    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res=new ArrayList();
            List<String> list=new ArrayList();

            dfs(res,list,s,0);
            return res;

        }



        public void dfs(List<List<String>> res, List<String> list,String s,int start){
            if(start==s.length()){
                res.add(new ArrayList(list));
                return;
            }

            for(int i=start;i<s.length();i++){
                String temp=s.substring(start,i+1);
                if(!isPal(temp)){
                    continue;
                }
                list.add(temp);
                dfs(res,list,s,i+1);
                list.remove(list.size()-1);

            }

        }




        public boolean isPal(String s){
            int i=0;
            int j=s.length()-1;
            while(i<j){
                if(s.charAt(i)!=s.charAt(j))
                    return false;
                i++;
                j--;
            }

            return true;
        }
    }
}
