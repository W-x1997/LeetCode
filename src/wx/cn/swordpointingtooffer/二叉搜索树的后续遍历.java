package wx.cn.swordpointingtooffer;

public class 二叉搜索树的后续遍历 {

    /**
     *
     *
     * 思路：
     * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
     * 1、确定root；
     * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
     * 3、遍历右子树，若发现有小于root的值，则直接返回false；
     * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
     */
    public class Solution {
        public boolean VerifySquenceOfBST(int [] sequence) {
            if(sequence==null||sequence.length==0)
                return false;
            return verify(sequence,0,sequence.length-1);
        }

        public boolean verify(int[] num,int start,int end){
            if(start>end)
                return true;
            int i=0;
            int root=num[end];
            for(;i<end;i++)
                if(num[i]>root)
                    break;
            int j=i;
            for(;j<end;j++)
                if(num[j]<root)
                    return false;
            boolean left=true;
            if(i<end)
                left=verify(num,start,i-1);
            boolean right=true;
            if(j<end)
                right=verify(num,i,end-1);
            return left&&right;

        }

    }
}
