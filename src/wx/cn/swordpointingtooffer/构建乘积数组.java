package wx.cn.swordpointingtooffer;

public class 构建乘积数组 {
    /**
     *
     * B[i]的值可以看作下图的矩阵中每行的乘积。
     * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
     * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
     *
     *
     * 两个倒三角形求解即可
     */

    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if(len != 0){
            B[0] = 1;
            for(int i=1; i<len; i++){
                B[i] = A[i-1]*B[i-1];    //k[i-1]A[i-1]
            }
            int temp = 1;
            for(int i=len-2; i>=0; i--){
                temp *= A[i+1];
                B[i] *= temp;           //p[i+1]A[i+1]
            }
        }
        return B;
    }
}
