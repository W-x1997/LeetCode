package wx.cn.swordpointingtooffer;



import java.util.ArrayList;

import java.util.*;

public class 字符串的排序 {
    /**
     *
     *输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     *
     *   要注意的是题目类型是string tmp需要用stringbuilder 如果用list 则会返回二维！
     *
     */


    public class Solution {
        public ArrayList<String> Permutation(String str) {

            ArrayList<String>res=new ArrayList();
            if(str==null||str.length()==0)
                return res;
            char[] array=str.toCharArray();
            //   Arrays.sort(array);
            StringBuilder sb=new StringBuilder("");
            boolean[] visited=new boolean[str.length()];
            dfs(res,sb,array,0,visited);

            return res;
        }

        public void dfs( ArrayList<String> res,StringBuilder sb ,char[] array,int index,boolean[] visited){

            if(sb.length()==array.length){
                if(!res.contains(sb.toString()))
                    res.add(sb.toString());
                return;
            }

            for(int i=0;i<array.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    sb.append(array[i]);
                    dfs(res,sb,array,index+1,visited);
                    sb.deleteCharAt(sb.length()-1);
                    visited[i]=false;
                }

            }


        }

    }
}
