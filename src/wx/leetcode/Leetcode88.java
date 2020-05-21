package wx.leetcode;

public class Leetcode88 {
    /**
     * 88. Merge Sorted Array
     *
     * Note:
     *
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     */

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {


            int cur=m+n-1;
            int p1=m-1;
            int p2=n-1;


            while(p1>=0&&p2>=0){
                if(nums1[p1]<=nums2[p2]){
                    nums1[cur]=nums2[p2];
                    p2--;
                    cur--;

                } else{
                    nums1[cur]=nums1[p1];
                    p1--;
                    cur--;

                }
            }

            while(p2>=0){ ///!!! DENOTE： sometimes when p1 reaches 0 p2 maybe not reach 0
                nums1[cur]=nums2[p2];
                p2--;
                cur--;
            }

        }
    }
}
