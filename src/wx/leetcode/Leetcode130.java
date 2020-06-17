package wx.leetcode;

public class Leetcode130 {
    class Solution {
        public void solve(char[][] board) {
            /**
             130. Surrounded Regions

             Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

             A region is captured by flipping all 'O's into 'X's in that surrounded region.
             **/


            /**
             * 外围边缘dfs
             * visited数组外围如果能访问到就边true
             *
             * 然后便利即可
             */
            if(board==null||board.length==0)
                return;

            boolean[][] visited=new boolean[board.length][board[0].length];

            for(int i=0;i<board.length;i++){
                dfs(board,i,0,visited);
                dfs(board,i,board[0].length-1,visited);
            }

            for(int j=0;j<board[0].length;j++){
                dfs(board,0,j,visited);
                dfs(board,board.length-1,j,visited);
            }

            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]=='O'&&visited[i][j]==false){
                        board[i][j]='X';
                    }
                }

            }
            return;

        }

        public void dfs(char[][] board,int i,int j,boolean[][] visited){
            if(i<0||i>=board.length||j<0||j>=board[0].length)return;
            if(board[i][j]=='X'||visited[i][j]==true)return;

            visited[i][j]=true;
            dfs(board,i-1,j,visited);
            dfs(board,i+1,j,visited);
            dfs(board,i,j-1,visited);
            dfs(board,i,j+1,visited);

        }


    }
}
