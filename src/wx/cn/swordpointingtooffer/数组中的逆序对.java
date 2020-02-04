package wx.cn.swordpointingtooffer;

public class 数组中的逆序对 {
    /**
     *
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     *
     */

    public class Solution {


         class Solution2 {
            public int InversePairs(int [] array) {
                int len = array.length;
                if(array== null || len <= 0){
                    return 0;
                }
                return mergeSort(array, 0, len-1);
            }
            public int mergeSort(int [] array, int start, int end){
                if(start == end)
                    return 0;
                int mid = (start + end) / 2;
                int left_count = mergeSort(array, start, mid);
                int right_count = mergeSort(array, mid + 1, end);
                int i = mid, j = end;
                int [] copy = new int[end - start + 1];
                int copy_index = end - start;
                int count = 0;
                while(i >= start && j >= mid + 1){
                    if(array[i] > array[j]){
                        copy[copy_index--] = array[i--];
                        count += j - mid;
                        if(count > 1000000007){
                            count %= 1000000007;
                        }
                    }else{
                        copy[copy_index--] = array[j--];
                    }
                }
                while(i >= start){
                    copy[copy_index--] = array[i--];
                }
                while(j >= mid + 1){
                    copy[copy_index--] = array[j--];
                }
                i = 0;
                while(start <= end) {
                    array[start++] = copy[i++];
                }
                return (left_count+right_count+count)%1000000007;
            }
        }
        public int InversePairs(int [] array) {
            if(array==null||array.length==0)
                return 0;
            int total=0;
            for(int i=array.length-1;i>=0;i--){
                for(int j=0;j<i;j++){
                    if(array[i]<array[j]){
                        total++;
                    }
                }
            }

            return total%1000000007;



        }
    }
}
