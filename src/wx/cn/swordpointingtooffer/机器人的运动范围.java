package wx.cn.swordpointingtooffer;

public class 机器人的运动范围 {
    /**
     *
     * 题目描述
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     */

    public class Solution {
        int count=0;
        public int movingCount(int threshold, int rows, int cols){
            int[][] net=new int[rows][cols];
            boolean[][] visited=new boolean[rows][cols];
            dfs(net,0,0,threshold,visited);
            return count;
        }

        public void dfs(int[][] net,int i,int j,int threshold,boolean[][] visited){
            if(i>=net.length||i<0||j>=net[0].length||j<0||visited[i][j]==true)
                return;
            if(calculate(i,j)>threshold)
                return;
            count++;
            visited[i][j]=true;
            dfs(net,i+1,j,threshold,visited);
            dfs(net,i-1,j,threshold,visited);
            dfs(net,i,j+1,threshold,visited);
            dfs(net,i,j-1,threshold,visited);

        }

        public int calculate(int i,int j){
            int sum=0;
            while(i>0){
                sum=sum+i%10;
                i=i/10;
            }
            while(j>0){
                sum=sum+j%10;
                j=j/10;
            }
            return sum;
        }
    }
}
