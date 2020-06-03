package wx.leetcode;
import java.util.*;

public class Leetcode767 {
    class Solution {
        /**
         767. Reorganize String
         Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

         If possible, output any possible result.  If not possible, return the empty string.

         Example 1:

         Input: S = "aab"
         Output: "aba"
         **/
        public String reorganizeString(String S) {

            /**
             构造一个辅助类存放char 和count

             再构造一个优先队列（最大堆）

             然后依次 每次弹出两个  弹出后加入stringbuilder 然后count-- 再push进堆

             **/
            int N=S.length();
            int[] count=new int[26];

            for(char ch:S.toCharArray()){
                count[ch-'a']++;
            }

            PriorityQueue<MutiChar> pq = new PriorityQueue<MutiChar>((a, b) ->
                    a.count == b.count ? a.letter - b.letter : b.count - a.count);


            for(int i=0;i<26;i++){
                if(count[i]>0){
                    if(count[i]>(N+1)/2) return "";  // 超过则不符合题意
                    pq.add(new MutiChar((char)('a'+i),count[i]));

                }

            }
            StringBuilder res=new StringBuilder();
            while(pq.size()>=2){
                MutiChar mc1=pq.poll();
                MutiChar mc2=pq.poll();

                res.append(mc1.letter);
                res.append(mc2.letter);

                if (--mc1.count > 0) pq.add(mc1);
                if (--mc2.count > 0) pq.add(mc2);

            }

            if(pq.size()>0) res.append(pq.poll().letter);
            return res.toString();

        }


        class MutiChar{
            char letter;
            int count;

            public MutiChar(char letter,int count){
                this.letter=letter;
                this.count=count;
            }
        }
    }
}
