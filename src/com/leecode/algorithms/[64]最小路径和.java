//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 574 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class minPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length, columns = grid[0].length;
//        int[][] dp = new int[rows][columns];
//        dp[0][0] = grid[0][0];
//        for (int i = 1; i < rows; i++) {
//            dp[i][0] = dp[i - 1][0] + grid[i][0];
//        }
//        for (int j = 1; j < columns; j++) {
//            dp[0][j] = dp[0][j - 1] + grid[0][j];
//        }
//        for (int i = 1; i < rows; i++) {
//            for (int j = 1; j < columns; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//            }
//        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (0 == i && 0 == j) continue;
                else if (0 == i) grid[i][j] += grid[i][j - 1];
                else if (0 == j) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[rows - 1][columns - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
