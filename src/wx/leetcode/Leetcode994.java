package wx.leetcode;
import java.util.*;

public class Leetcode994 {
    class Solution {

        /**
         * 994. Rotting Oranges
         * Medium
         *
         * 1446
         *
         * 177
         *
         * Add to List
         *
         * Share
         * In a given grid, each cell can have one of three values:
         *
         * the value 0 representing an empty cell;
         * the value 1 representing a fresh orange;
         * the value 2 representing a rotten orange.
         * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
         *
         * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
         * @param grid
         * @return
         */
        public int orangesRotting(int[][] grid) {
            /**
             经典的bfs 队列模拟
             要注意的是 记录层数即为times的消耗    用queue.size 来遍历 每次先记录queue的大小 若size减为0 则说明当前层遍历完

             这题要注意几个corner case
             1.有永远新鲜的水果 1的周围都是0
             2.原本就没有水果 全是空格0

             **/
            int time=0;
            if(grid==null||grid.length==0)return 0;

            Queue<int[]> queue=new LinkedList<>();


            int flag=0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==2)
                        queue.add(new int[]{i,j});
                    if(grid[i][j]==1)
                        flag=1;
                }
            }
            if(queue.isEmpty()&&flag==0)return 0;

            int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};



            while(!queue.isEmpty()){
                int size=queue.size();
                while(size>0){
                    int[] cur=queue.poll();

                    for(int i=0;i<4;i++){
                        int x=cur[0]+dir[i][0];
                        int y=cur[1]+dir[i][1];
                        if(x<0||x>=grid.length||y<0||y>=grid[0].length)continue;
                        if(grid[x][y]==1){
                            grid[x][y]=2;
                            queue.add(new int[]{x,y});
                        }

                    }
                    size--;
                }

                time++;

            }

            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==1)
                        return -1;
                }
            }


            return time-1;
        }


    }
}
