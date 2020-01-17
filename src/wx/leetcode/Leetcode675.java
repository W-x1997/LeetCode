package wx.leetcode;




/**
 *
 * 675. Cut Off Trees for Golf Event
 * hard
 * 本题是一道砍树题。给出一个n*m的矩阵（不大于50*50），矩阵中值为0的数被视为障碍，不能到达或通过。矩阵中值为1的数视为平地，可以通过。
 * 大于1的视为树，可以通过。我们的任务就是找一条最短的路径按树的高度从小到大砍掉树，并返回路径长度。其中树被砍掉后就视为草地（其实就是平地）。
 *
 *
 *  这道题本质就是求平面内 两点最短距离。
 *  先将所有点根据高度排序，然后依次遍历bfs即可。
 */

import  java.util.*;
public class Leetcode675 {

    class Solution {
        class Tree{
            int x;
            int y;
            int height;

            Tree(int x,int y,int height){
                this.x=x;
                this.y=y;
                this.height=height;
            }

        }


        public int cutOffTree(List<List<Integer>> forest) {
            if(forest.size()==0||forest.get(0).size()==0)
                return -1;

            PriorityQueue<Tree> queue=new PriorityQueue<Tree>(10,new Comparator(){

                public int compare(Object obj1,Object obj2){
                    Tree t1=(Tree)obj1;
                    Tree t2=(Tree)obj2;
                    return t1.height-t2.height;
                }
            });


            for(int i=0;i<forest.size();i++){
                for(int j=0;j<forest.get(0).size();j++){
                    if(forest.get(i).get(j)==0){
                        continue;
                    }
                    if(forest.get(i).get(j)>1){
                        queue.offer(new Tree(i,j,forest.get(i).get(j)));
                    }


                }

            }

            int cnt=0;
            int cur_x=0,cur_y=0;

            while(!queue.isEmpty()){
                Tree next=queue.poll();
                int des_x=next.x;
                int des_y=next.y;
                int steps=bfs(cur_x,cur_y,des_x,des_y,forest);
                if(steps==-1)
                    return -1;

                cnt=cnt+steps;
                cur_x=des_x;
                cur_y=des_y;

            }

            return cnt;


        }


        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        public int bfs(int cur_x,int cur_y,int des_x,int des_y,List<List<Integer>> forest){
            if(cur_x==des_x&&cur_y==des_y)
                return 0;

            Queue<int[]> queue=new LinkedList();
            queue.add(new int[]{cur_x,cur_y});


            boolean[][] visited=new boolean[forest.size()][forest.get(0).size()];

            int steps=0;

            visited[cur_x][cur_y]=true;
            while(!queue.isEmpty()){
                steps++;

                int size=queue.size();
                for(int i=0;i<size;i++){
                    int[] pos=queue.poll();
                    for(int[]dr:dir){
                        int x=pos[0]+dr[0];
                        int y=pos[1]+dr[1];

                        if(x==des_x&&y==des_y)
                            return steps;

                        if(x>=0&&x<forest.size()&&y>=0&&y<forest.get(0).size()&&forest.get(x).get(y)!=0&& !visited[x][y]){
                            visited[x][y]=true;
                            queue.offer(new int[]{x,y});
                        }




                    }


                }


            }
            return -1;


        }










    }
}
