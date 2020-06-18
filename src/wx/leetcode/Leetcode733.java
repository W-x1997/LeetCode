package wx.leetcode;

public class Leetcode733 {
    class Solution {
        /**
         733. Flood Fill
         **/
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if(image==null||image.length==0)
                return image;
            if (image[sr][sc] != newColor)//!!注意死循环！
                dfs(image,sr,sc,newColor,image[sr][sc]);
            return image;
        }


        public void dfs(int[][] image,int i,int j, int newColor,int origin){
            if(i<0||i>=image.length||j<0||j>=image[0].length)
                return;

            if(image[i][j]!=origin)return;

            image[i][j]=newColor;
            dfs(image,i+1,j,newColor,origin);
            dfs(image,i-1,j,newColor,origin);
            dfs(image,i,j-1,newColor,origin);
            dfs(image,i,j+1,newColor,origin);

        }
    }


}
