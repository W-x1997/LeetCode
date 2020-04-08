package wx.leetcode;

public class Leetcode_interview {
    /**
     *
     * 面试题13. 机器人的运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
     * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     */
    class Solution {
        int res=0;
        public int movingCount(int m, int n, int k) {
            boolean[][] visited=new boolean[m][n];
            dfs(0,0,m,n,visited,k);
            return res;
        }

        public void dfs(int i,int j,int m,int n,boolean[][] visited,int k){
            if(i<0||j<0||i>=m||j>=n||visited[i][j]==true||calculate(i,j)>k){
                return;
            }
            res++;
            visited[i][j]=true;
            dfs(i-1,j,m,n,visited,k);
            dfs(i+1,j,m,n,visited,k);
            dfs(i,j-1,m,n,visited,k);
            dfs(i,j+1,m,n,visited,k);
        }

        public int calculate(int x,int y){
            int sum=0;
            while(x>0){
                sum=sum+x%10;
                x=x/10;
            }

            while(y>0){
                sum=sum+y%10;
                y=y/10;
            }

            return sum;
        }

    }
}
