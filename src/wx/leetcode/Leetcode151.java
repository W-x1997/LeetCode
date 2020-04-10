package wx.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode151 {
    /**
     *
     * 151. Reverse Words in a String
     * Given an input string, reverse the string word by word.
     *
     *
     *
     * Example 1:
     *
     * Input: "the sky is blue"
     * Output: "blue is sky the"
     */

    /**
     *
     * 方法二：双端队列
     * 思路和算法
     *
     * 由于双端队列支持从队列头部插入的方法，因此我们可以沿着字符串一个一个单词处理，然后将单词压入队列的头部，再将队列转成字符串即可。
     *

     */
    class Solution2 {
        public String reverseWords(String s) {
            int left = 0, right = s.length() - 1;
            // 去掉字符串开头的空白字符
            while (left <= right && s.charAt(left) == ' ') ++left;

            // 去掉字符串末尾的空白字符
            while (left <= right && s.charAt(right) == ' ') --right;

            Deque<String> d = new ArrayDeque();
            StringBuilder word = new StringBuilder();

            while (left <= right) {
                char c = s.charAt(left);
                if ((word.length() != 0) && (c == ' ')) {
                    // 将单词 push 到队列的头部
                    d.offerFirst(word.toString());
                    word.setLength(0);
                } else if (c != ' ') {
                    word.append(c);
                }
                ++left;
            }
            d.offerFirst(word.toString());

            return String.join(" ", d);
        }
    }

    class Solution {
        public String reverseWords(String s) {
            if(s==null||s.length()==0)
                return "";

            StringBuilder sb=new StringBuilder("");
            String[] str=s.split(" ");
            for(int i=str.length-1;i>=0;i--){
                if (str[i].length() == 0) continue;
                sb.append(str[i]+" ");
            }
            if(sb.length()>0)sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }
    }
}
