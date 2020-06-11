package wx.leetcode;

public class Leetcode79 {
    class Solution {
        /**
         79. Word Search
         Given a 2D board and a word, find if the word exists in the grid.

         The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

         Example:

         board =
         [
         ['A','B','C','E'],
         ['S','F','C','S'],
         ['A','D','E','E']
         ]

         Given word = "ABCCED", return true.
         Given word = "SEE", return true.
         Given word = "ABCB", return false.
         **/

        public boolean exist(char[][] board, String word) {
            if(word==null||word.length()==0)return true;
            boolean[][] visited=new boolean[board.length][board[0].length];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(dfs(board,word,i,j,0,visited)){
                        return true;
                    }
                }
            }

            return false;



        }


        public boolean dfs(char[][] board,String word,int i,int j,int cur,boolean[][] visited){

            if(i>=board.length||i<0||j>=board[0].length||j<0||word.charAt(cur)!=board[i][j]||visited[i][j]==true) return false;

            if(cur==word.length()-1)return true;

            visited[i][j]=true;
            boolean f=dfs(board,word,i-1,j,cur+1,visited)||
                    dfs(board,word,i+1,j,cur+1,visited)||
                    dfs(board,word,i,j-1,cur+1,visited)||
                    dfs(board,word,i,j+1,cur+1,visited);
            visited[i][j]=false;
            return f;

        }
    }
}
