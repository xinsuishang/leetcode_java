package com.leecode.algorithms;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 660 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class moveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (0 != nums[i]) {
                if (i != j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    // 异或会慢一点，变量在寄存器交换不涉及计算
//                    nums[i] ^= nums[j];
//                    nums[j] ^= nums[i];
//                    nums[i] ^= nums[j];
                }
                ++j;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
