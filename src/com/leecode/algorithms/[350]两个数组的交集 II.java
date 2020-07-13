package com.leecode.algorithms;//给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 317 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len2 < len1) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] intersection = new int[nums1.length];
        int idx = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[idx++] = num;
                count--;
                map.put(num, count);
            }
        }


//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int len1 = nums1.length, len2 = nums2.length;
//        int[] intersection = new int[Math.min(len1, len2)];
//        int i = 0, j = 0;
//        int idx = 0;
//        while (i < len1 && j < len2) {
//            if (nums1[i] < nums2[j]) {
//                i++;
//            } else if (nums1[i] > nums2[j]) {
//                j++;
//            } else {
//                intersection[idx] = nums1[i];
//                idx++;
//                i++;
//                j++;
//            }
//        }
        return Arrays.copyOfRange(intersection, 0, idx);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
