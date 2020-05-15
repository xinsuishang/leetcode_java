package com.leecode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinsuishang
 * @description https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @date 2020/5/15 15:19
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
