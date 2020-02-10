package wx.cn.swordpointingtooffer;

public class 二叉树的下一个结点 {

    /**
     *
     * //1）当前孩子有右孩子，那么下一个节点一定在右孩子的最左边
     * //2）若无右孩子，则判断与父亲节点位置关系：
     * // i.若为父节点的左节点，则下一个节点即为父亲节点
     * // ii.若为父亲的右节点，则下一个节点一直往父亲上面找，直到找到两个节点为夫与左孩子的关系为止。
     */


    public class Solution {

        public class TreeLinkNode {
            int val;
            TreeLinkNode left = null;
            TreeLinkNode right = null;
            TreeLinkNode next = null;

            TreeLinkNode(int val) {
                this.val = val;
            }
        }
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if(pNode==null)
                return null;

            if(pNode.right!=null){
                TreeLinkNode node=pNode.right;
                while(node.left!=null)
                    node=node.left;
                return node;
            } else{

                if(pNode.next!=null&&pNode.next.left==pNode)
                    return pNode.next;

                if(pNode.next!=null){
                    while(pNode.next!=null&&pNode.next.left!=pNode){
                        pNode=pNode.next;
                    }
                    return pNode.next;
                }


                return null;
            }



        }
    }
}
