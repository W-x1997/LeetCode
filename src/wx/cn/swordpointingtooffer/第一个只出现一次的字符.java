package wx.cn.swordpointingtooffer;
import java.util.*;

public class 第一个只出现一次的字符 {
    /**
     *
     * 题目描述
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
     *
     * hashmap遍历即可
     */


    public class Solution {
        public int FirstNotRepeatingChar(String str) {
            if(str==null||str.length()==0){
                return -1;
            }
            HashMap<Character,Integer> map=new HashMap<Character,Integer>();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);

                }else
                    map.put(ch,1);
            }


            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(map.get(ch)==1){
                    return i;
                }

            }


            return -1;




        }
    }
}
