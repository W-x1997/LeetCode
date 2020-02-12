package wx.cn.swordpointingtooffer;

public class 矩阵中的路径 {
    /**
     * 题目描述
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     *
     *
     *
     *
     * ！！！注意 这里给出的matrix是一纬数组  仍然安装二维数组的思路 dfs来做
     *
     *   注意坐标变换
     *   ！！！
     *   i行j列  -----》  i*cols+j
     *                     !!!
     *                      乘的是cols
     *
     *
     */
    public class Solution {
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
            if(matrix==null||matrix.length==0)
                return false;

            boolean res=false;
            boolean[] visited=new boolean[rows*cols];
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(matrix[i*cols+j]==str[0]){
                        res=dfs(matrix,rows,cols,i,j,0,str,visited);
                        if(res)
                            return res;
                    }

                }
            }
            return res;

        }


        public boolean dfs(char[] matrix, int rows,int cols,int i, int j, int index,char[] str,boolean[] visited){
            if(i>=rows||i<0||j>=cols||j<0||matrix[i*cols+j]!=str[index]||visited[i*cols+j]==true||index>=str.length)
                return false;

            if(index==str.length-1)
                return true;
            visited[i*cols+j]=true;
            boolean res=dfs(matrix,rows,cols,i+1,j,index+1,str,visited)||
                    dfs(matrix,rows,cols,i-1,j,index+1,str,visited)||
                    dfs(matrix,rows,cols,i,j+1,index+1,str,visited)||
                    dfs(matrix,rows,cols,i,j-1,index+1,str,visited);
            visited[i*cols+j]=false;
            return res;

        }


    }







}
