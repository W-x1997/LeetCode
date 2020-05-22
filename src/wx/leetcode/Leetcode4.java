package wx.leetcode;

public class Leetcode4 {
    class Solution {

        /**
         4. Median of Two Sorted Arrays
         There are two sorted arrays nums1 and nums2 of size m and n respectively.

         Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

         You may assume nums1 and nums2 cannot be both empty.

         **/


        /**
         不得不说 这题有点难
         时间复杂度要log 那必然binary search
         所以这题就是divide conquer+bs

         主题思路就是比如找第k个 那么就提取前面k-1个即可

         这题要注意的是 主题思路 比如5个数字 中位数是第三个
         如果第一个数组只有两个 那么中位数必然不会在第一个数组中出现 第一个数组中全部都剔除 所以利用这个思想 不断踢出元素
         上面说的是特殊情况，那么一般情况相对复杂
         我们用两个mid 分别比较 （对半分）

         ！！！下面重点👇
         如果mid1<mid2 ： 那么mid1和它之前出现的必然不可能为median
         那么我们从mid向后寻找即可

         **/

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m=nums1.length;
            int n=nums2.length;

            //this is a ticky here 为了简化代码，不分情况讨论，使用一个小 trick，分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。若 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
            int n1=(m+n+1)/2;
            int n2=(m+n+2)/2;

            return 1.0*(findKth(nums1,nums2,0,0,n1)+findKth(nums1,nums2,0,0,n2))/2;


        }


        public int findKth(int[] nums1,int[] nums2, int i,int j, int k){//start from i find the kth
            int m=nums1.length;
            int n=nums2.length;

            if(i>=m)return nums2[j+k-1];// if i>=m, it means nums1 reaches the end
            if(j>=n)return nums1[i+k-1];// if j>=n, it means nums2 reaches the end

            if(k==1)return Math.min(nums1[i],nums2[j]);

            int mid1=(i+k/2-1)<m?nums1[i+k/2-1]:Integer.MAX_VALUE;//if the mid is not out of range, we get it. otherwise, we remove it by setting it to MAX.
            int mid2=(j+k/2-1)<n?nums2[j+k/2-1]:Integer.MAX_VALUE;


            if(mid1<mid2){ // this means all elements in nums1 from i to mid1 cannot be the median, so we could remove them
                return findKth(nums1,nums2,i+k/2,j,k-k/2);

            }else {
                return findKth(nums1,nums2,i,j+k/2,k-k/2);
            }

        }


    }
}
