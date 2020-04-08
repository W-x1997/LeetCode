package wx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    /**
     *
     * 22. Generate Parentheses
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * For example, given n = 3, a solution set is:
     */
    class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }

            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open+1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close+1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }


    class Solution1 {
        public List<String> generateParenthesis(int n) {
            List<String> res=new ArrayList();
            if(n<=0)
                return res;
            StringBuilder sb=new StringBuilder("");
            dfs(res,sb,0,n);
            return res;
        }


        public void dfs(List<String> res, StringBuilder sb,int cur,int n){
            if(cur>=n*2){
                String str=sb.toString();
                if(isValid(str))
                    res.add(str);
                return;
            }
            sb.append("(");
            dfs(res,sb,cur+1,n);
            sb.deleteCharAt(sb.length()-1);

            sb.append(")");
            dfs(res,sb,cur+1,n);
            sb.deleteCharAt(sb.length()-1);



        }

        public boolean isValid(String str){
            int res=0;
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(ch=='(')
                    res++;
                else
                    res--;

                if(res<0)return false;
            }
            if(res==0)
                return true;
            return false;
        }

    }
}
