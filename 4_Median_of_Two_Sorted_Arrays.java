public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1){
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (
            findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)
        ) / 2.0
    }

    // Find Kth number of the two sorted array
    public static int findKth(int[] nums1, int nums1_start, int[] nums2, int nums2_start, int k){
        // if the start point is invalid in either array
        if(nums1_start >= nums1.length){
            return nums2[nums2_start + k - 1]
        }

        if(nums2_start >= nums2.length){
            return nums1[nums1_start + k - 1]
        }
        // If it just wants the first number of two array
        if(k == 1){
            return Math.min(nums1[nums1_start], nums2[nums2_start]);
        }

        // check if the k /2 - 1 th number is in the nums1 and nums2, if so, compare them.
        int nums1_key = nums1_start + k / 2 - 1 < nums1.length 
            ? nums1[nums1_start + k / 2 - 1] : Integer.MAX_VALUE;
        
        int nums2_key = nums2_start + k / 2 - 1 < nums2.length 
            ? nums2[nums2_start + k / 2 - 1] : Integer.MAX_VALUE;
        
        // If k/2 th number in nums1 is greater than nums2, delete first k/2th number in nums1 and
        // redo the search, otherwise abandon the first k/2th numbers in nums2 and redo the search
        if (nums1_key < nums2_key){
            return findKth(nums1, nums1_start + k / 2, nums2, nums2_start, k - k / 2);
        } else {
            return findKth(nums1, nums1_start, nums2, nums2_start + k / 2, k - k / 2);
        }
    }
}    