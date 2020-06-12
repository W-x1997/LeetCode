package wx.leetcode;

public class Leetcode79 {
    class Solution {


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
