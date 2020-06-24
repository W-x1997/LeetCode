package wx.leetcode;

import java.util.HashSet;
import java.util.List;

    public class Leetcode1239 {
        class Solution {
            /**
             1239. Maximum Length of a Concatenated String with Unique Characters

             Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

             Return the maximum possible length of s.
             **/

            /**
             经典的dfs
             只需要多加一个判定条件  是否有重复单词

             **/
            int res=0;
            public int maxLength(List<String> arr) {

                dfs(arr,0,"");
                return res;
            }


            public void dfs(List<String>arr, int start, String sb){

                res=Math.max(res,sb.length());
                if(start==arr.size())
                    return;

                for(int i=start;i<arr.size();i++){  //这里很巧妙 用一个拼接 不用删除
                    String cur=sb+arr.get(i);
                    if(Isunique(cur)){
                        dfs(arr,i+1,cur);
                    }
                }


            }

            public boolean Isunique(String str){
                HashSet<Character> set=new HashSet<Character>();

                for(int i=0;i<str.length();i++){
                    char ch=str.charAt(i);
                    if(set.contains(ch))
                        return false;
                    set.add(ch);
                }

                return true;

            }

        }
    }


