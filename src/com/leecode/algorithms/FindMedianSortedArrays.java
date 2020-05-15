package com.leecode.algorithms;

/**
 * @author xinsuishan（这个是抄的）
 * @description https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @date 2020/5/15 15:44
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        // 中位数分为两种情况，奇数/偶数
        int left = (l1 + l2 + 1) / 2;
        int right = (l1 + l2 + 2) / 2;

        return getK(nums1, 0, l1 - 1, nums2, 0, l2 - 1, left) * 0.5 + getK(nums1, 0, l1 - 1, nums2, 0, l2 - 1, right) * 0.5;
    }

    private int getK(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getK(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getK(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getK(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
