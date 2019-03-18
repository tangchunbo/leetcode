package easy;

/**
 * @author : tom
 * @date : 2019-03-18 15:44
 **/
public class MajorityElement {
    /**
     * 169
     *
     * 给定一个大小为 n 的数组，找到其中的众数。
     * 众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */

    public int majorityElement(int[] nums) {
        int count = 1;
        int v = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == v) {
                count++;
            } else {
                count--;
                if (count < 1) {
                    v = nums[i+1];
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        int[] arr = {2,2,1,1,1,2,2};
//        int[] arr = {10, 9, 9, 9, 10};
        System.out.println(m.majorityElement(arr));
    }
}
