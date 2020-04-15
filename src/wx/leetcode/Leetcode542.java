package wx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode542 {
    /**
     *
     * 542. 01 矩阵
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     *
     * 两个相邻元素间的距离为 1 。
     *
     * 示例 1:
     * 输入:
     *
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * 输出:
     *
     * 0 0 0
     * 0 1 0
     * 0 0 0
     *
     *
     *
     *
     *
     */
    class Solution1 {
        /**
         *
         *  bfs ：！ 注意第一次加入所有为0的点 然后顺序从0 开始遍历 visited用来标志是否访问过
         *
         *  题干说找"最近的0的距离"，最短路问题第一个想法就是BFS。
         *
         * 找01矩阵中所有元素的距离0的位置：元素0和自身的距离是0，元素1和0的距离等于0到1的距离。
         *
         * 用一个标记数组记录每个位置是否已经计算过距离。
         *
         * 初始化结果集和队列，遍历矩阵找到所有等于0的位置，结果集对应位置赋值0并且坐标入队。计算过距离的位置标记。
         *
         * 广搜，队列中元素出队后向四个方向分别搜索一次寻找1(没有被标记过的位置就是1)，如果搜索位置存在1则记录结果集距离为结果集中搜索源点的值+1，并且入队、标记。
         *

         * @param matrix
         * @return
         */
        public int[][] updateMatrix(int[][] matrix) {
            int[][] res=new int[matrix.length][matrix[0].length];
            boolean[][] visited=new boolean[matrix.length][matrix[0].length];
            Queue<int[]> queue=new LinkedList<int[]>();
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]==0){
                        res[i][j]=0;
                        visited[i][j]=true;
                        queue.offer(new int[]{i,j});

                    }
                }
            }

            int[] dx={0,1,0,-1};
            int[] dy={1,0,-1,0};
            while(!queue.isEmpty()){
                int[] tmp=queue.poll();
                int cur_x=tmp[0];
                int cur_y=tmp[1];

                for(int i=0;i<4;i++){
                    int x=cur_x+dx[i];
                    int y=cur_y+dy[i];
                    if(x>=0&&x<matrix.length&&y>=0&&y<matrix[0].length&&!visited[x][y]){                  res[x][y]=res[cur_x][cur_y]+1;
                        visited[x][y]=true;
                        queue.offer(new int[]{x,y});
                    }
                }

            }


            return res;

        }
    }

    /**
     *
     * 思路二：动态规划
     * 其实在广搜思路中，就已经能从结果集中搜索源点的值+1这里尝到DP的味道了，再加上方法返回的这个距离数组需要逐步填表的过程，就能想到一些DP思路了。
     *
     * dp[i][j]含义：就像题目中要求的matrix[i][j]距离0的最小距离。
     *
     * 初始化：dp数组元素赋一个最大值，遍历矩阵元素为0的地方先填写完毕。
     *
     * 状态转移：第一次遍历从左上到右下填表，每次只向右向下"搜索"；第二次遍历从右下到左上填表，每次只向左向上"搜索"。(有广搜内味了)
     *

     * @param matrix
     * @return
     */
    public int[][] updateMatrix2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 10001);

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) dp[i][j] = 0;
            }
        }
        //状态转移
        //第一次填表从左上到右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        //第二次填表从右下到左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

}
