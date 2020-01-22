package wx.cn.swordpointingtooffer;
import java.util.ArrayList;
public class 顺时针打印矩阵 {

    /**
     *
     *   定义四个变量来表示上下左右边界
     *   然后依次遍历 缩小边界     要注意每次遍历完一个方向 要判断是否跳出循环
     */

    public class Solution {
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            ArrayList<Integer> res=new ArrayList();
            if(matrix==null||matrix.length<=0)return  res;

            int top=0;
            int botton=matrix.length-1;
            int left=0;
            int right=matrix[0].length-1;


            while(left<=right&&top<=botton){
                for(int i=left;i<=right;i++){
                    res.add(matrix[top][i]);
                }
                top++;
                if(top>botton)break;

                for(int i=top;i<=botton;i++){
                    res.add(matrix[i][right]);
                }
                right--;
                if(right<left)break;


                for(int i=right;i>=left;i--){
                    res.add(matrix[botton][i]);
                }
                botton--;
                if(top>botton)break;

                for(int i=botton;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
                if(right<left)break;



            }


            return res;


        }
    }
}
