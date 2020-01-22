package wx.cn.swordpointingtooffer;

import java.util.Stack;

public class 栈的压入弹出序列 {
    /**
     *
     *
     * 题目描述
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     *
     *
     * 用一个栈和指向pop数组的下标 来依次模拟
     * 下表index指向0
     * 遍历push 每次看pop的index值是否与要push的值相等
     * 若相等 则直接pop index++
     * 否则压入即可 最后看stack是否为空
     *
     *
     *
     *
     */

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack();
        int index=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty()&&stack.peek()==popA[index]){
                stack.pop();
                index++;
            }

        }

        return stack.isEmpty();

    }
}


