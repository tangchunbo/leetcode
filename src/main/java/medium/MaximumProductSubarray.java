package medium;

/**
 * @author : tom
 * @date : 2019-03-19 14:44
 **/
public class MaximumProductSubarray {
    /**
     * 152
     *
     * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     *
     * 示例 1:
     *
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */

    public int maxProduct(int[] nums) {
        // 由于有正负，所以每次相乘完毕后，应该保留最大和最小值，也就是最大正数，最小负数
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax*num, num);
            imin = Math.min(imin*num, num);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        m.maxProduct(new int[]{2,3,-2,4});
    }
}
