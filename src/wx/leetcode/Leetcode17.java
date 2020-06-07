package wx.leetcode;
import java.util.*;
public class Leetcode17 {
    class Solution {
        /**
         17. Letter Combinations of a Phone Number

         Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

         A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
         **/

        /**
         经典的dfs

         这里要注意
         map 一定要 char，string
         否则get为null
         **/
        HashMap<Character,String> map=new HashMap<>();



        public List<String> letterCombinations(String digits) {
            List<String> res=new ArrayList();

            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            if(digits == null || digits.length() == 0)
                return res;

            StringBuilder sb=new StringBuilder("");
            dfs(res,digits,sb,0);

            return res;


        }

        public void dfs(List<String> res,String digits,StringBuilder sb,int index){

            if(index==digits.length()){
                res.add(sb.toString());
                return;
            }

            char cur=digits.charAt(index);
            String str=map.get(cur);//!!!!

            for(int i=0;i<str.length();i++){
                sb.append(str.charAt(i));
                dfs(res,digits,sb,index+1);
                sb.deleteCharAt(sb.length()-1);

            }


        }



    }
}
