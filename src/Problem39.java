/**
 * 数组中出现次数超过一半的数字
 */
public class Problem39 {
    /**
     * 1、设置两个变量，一个保存数组中的一个值，另一个保存该值出现的次数，
     * 如果下一个数字和它相同，那么次数 +1，否则 -1；
     * 如果次数为 0了，那么记录下一个数字，并把次数设为 1。
     *
     * 2、排序，次数超过一半的数字就在中间位置，
     * 可以基于快速排序的思想
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int cnt = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                cnt++;
            } else {
                if (cnt == 0) {
                    num = nums[i];
                    cnt = 1;
                } else {
                    cnt--;
                }
            }
        }
        return num;
    }
}
