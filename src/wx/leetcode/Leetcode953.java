package wx.leetcode;

import java.util.HashMap;

public class Leetcode953 {
    /**
     * 953. Verifying an Alien Dictionary
     */
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            if(words==null||words.length==0)return false;


            if(order==null||order.length()==0)return true;
            HashMap<Character,Integer> map=new HashMap<>();

            int index=0;
            for(char ch:order.toCharArray()){
                map.put(ch,index);
                index++;
            }

            flag:  for(int i=0;i<words.length-1;i++){
                String cur=words[i];
                String next=words[i+1];


                for(int j=0;j<Math.min(cur.length(),next.length());j++){
                    char ch1=cur.charAt(j);
                    char ch2=next.charAt(j);
                    if(ch1!=ch2){
                        if(map.get(ch1)>map.get(ch2))
                            return false;


                        continue flag;
                    }

                }

                // If we didn't find a first difference, the
                // words are like ("app", "apple").
                if(cur.length()>next.length())return false;

            }

            return true;
        }
    }
}
