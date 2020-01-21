package wx.cn.swordpointingtooffer;

public class 调整数组顺序使得奇数在偶数前面 {
    /**
     *  Two pointer的经典问题
     * 注意数组边界 和 数组转换 不是直接将指针指向的数值调换 而是一次平移
     */

    public class Solution {
        public void reOrderArray(int [] array) {
            if(array.length==0||array==null){
                return;
            }

            int left=0;
            int right=0;
            while(right<array.length&&left<array.length){
                for(int i=left;i<array.length;i++){
                    if(array[i]%2==1)
                        continue;
                    left=i;
                    break;
                }


                for(int j=left+1;j<array.length;j++){
                    if(j==array.length-1&&array[j]%2==0) /**  注意这里的变换！ 用for的话需要注意数组溢出
                     **/
                        return;
                    if(array[j]%2==0)
                        continue;

                    right=j;
                    break;
                }

                if(left>=array.length||right>=array.length)
                    return;

                int tmp=array[right];                      //！！
                for(int i=right;i>left;i--){
                    array[i]=array[i-1];
                }
                array[left]=tmp;
                left++;





            }
            return ;


        }

    }

}
