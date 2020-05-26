package wx.leetcode;
import java.util.*;

public class Leetcode438 {
    class Solution {
        /**
         438. Find All Anagrams in a String

         Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

         Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

         The order of output does not matter.
         **/
        public List<Integer> findAnagrams(String s, String p) {
            /**
             依然是经典的双指针 滑动窗口
             用两个hashmap来进行遍历比较


             **/
            List<Integer> res=new ArrayList();
            int len_p=p.length();
            int len_s=s.length();
            if(s==null||len_s==0)return  res;
            if (len_s < len_p) return new ArrayList();

            HashMap<Character,Integer> s_map=new HashMap<>();
            HashMap<Character,Integer> p_map=new HashMap<>();


            for(int i=0;i<len_p;i++){
                char ch=p.charAt(i);
                if(p_map.containsKey(ch)){
                    p_map.put(ch,p_map.get(ch)+1);
                }else{
                    p_map.put(ch,1);
                }

            }

            for(int i=0;i<len_s;i++){
                char ch=s.charAt(i);
                if(s_map.containsKey(ch)){
                    s_map.put(ch,s_map.get(ch)+1);
                }else{
                    s_map.put(ch,1);
                }


                if(i>=len_p){   //达到目标字符串长度后 左指针开始右移
                    char left=s.charAt(i-len_p);
                    if(s_map.get(left)==1){
                        s_map.remove(left);
                    }else
                        s_map.put(left,s_map.get(left)-1);

                }
                if(s_map.equals(p_map))
                    res.add(i-len_p+1);


            }

            return res;
        }
    }
}
