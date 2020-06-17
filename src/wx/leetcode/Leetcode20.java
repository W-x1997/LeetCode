package wx.leetcode;
import java.util.*;
public class Leetcode20 {class Solution {
    /**
     20. Valid Parentheses
     Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     An input string is valid if:

     Open brackets must be closed by the same type of brackets.
     Open brackets must be closed in the correct order.
     **/
    public boolean isValid(String s) {
        if(s==null||s.length()==0)
            return true;
        Stack<Character> stack=new Stack();

        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty())return false;
            char ch2=stack.pop();

            if(ch==')'){
                if(ch2!='(')
                    return false;

            }else if(ch=='}'){
                if(ch2!='{')
                    return false;

            }else if(ch==']'){
                if(ch2!='[')
                    return false;
            }


        }

        if(stack.isEmpty())
            return true;
        return false;


    }
}
}
