package com.leecode.algorithms;

import java.util.HashMap;
import java.util.Map;

/*
 * 题目：https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 解法
 * hash存储遍历过的值，k为数组内的值，v为下标
 * 存在则return
 */

/**
 * @author xinsuishang
 * @description https://leetcode-cn.com/problems/two-sum/
 * @date 2020/5/15 14:16
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

// times: 2
