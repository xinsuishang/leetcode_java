package com.leecode.algorithms;
//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 示例: 
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0] 
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 348 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
// 超时
class countSmaller {
    //    public List<Integer> countSmaller(int[] nums) {
//        int len = nums.length;
//        List<Integer> res = new ArrayList<>(Collections.nCopies(len, 0));
//        for (int i = 0; i < len - 1; i++) {
//            int count = 0;
//            for (int j = i + 1; j < len; j++) {
//                if (nums[j] < nums[i]) {
//                    count++;
//                }
//            }
//            res.set(i, count);
//        }
//        return res;
//    }
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(Collections.nCopies(len, 0));

        if (len < 1) {
            return res;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = len - 2; i >= 0; i--) {
            int key = nums[i + 1];
            if (treeMap.containsKey(key)) {
                treeMap.put(key, treeMap.get(key) + 1);
            } else {
                treeMap.put(key, 1);
            }
            Map<Integer, Integer> map = treeMap.headMap(nums[i]);
            int count = 0;
            for (Integer value : map.values()) {
                count += value;
            }

            res.set(i, count);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
