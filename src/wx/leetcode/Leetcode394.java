package wx.leetcode;

import java.util.Stack;

public class Leetcode394 {
    class Solution {
        /**
         *
         * 394. Decode String
         * Medium
         *
         * 2486
         *
         * 128
         *
         * Add to List
         *
         * Share
         * Given an encoded string, return its decoded string.
         *
         * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
         *
         * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
         *
         * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
         *
         * Examples:
         *
         * s = "3[a]2[bc]", return "aaabcbc".
         * s = "3[a2[c]]", return "accaccacc".
         * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
         * @param s
         * @return
         */
        public String decodeString(String s) {

            /**
             *
             * 用两个栈 一个存数字 一个存string
             *
             * 分四种情况讨论 分别是 数字，【， 】，字母
             */
            Stack<Integer> nums=new Stack();
            Stack<String> str=new Stack();
            String res="";   //res是保留的当前的 也就是括号里的 括号之前的都在stack中
            int index=0;

            while(index<s.length()){
                if(Character.isDigit(s.charAt(index))){
                    int num=0;
                    while(Character.isDigit(s.charAt(index))){
                        num=num*10+(s.charAt(index)-'0');
                        index++;
                    }

                    nums.push(num);
                }else if(s.charAt(index)=='['){
                    str.push(res);
                    res="";
                    index++;

                }else if(s.charAt(index)==']'){
                    StringBuilder temp=new StringBuilder(str.pop());
                    int count=nums.pop();
                    for(int i=0;i<count;i++){
                        temp.append(res);
                    }
                    res=temp.toString();
                    index++;

                }else{
                    res=res+s.charAt(index);
                    index++;
                }
            }


            return res;
        }
    }
}
