import java.util.Arrays;

/**
 * NextPrmt
 */
public class NextPrmt {

    public void nextPermutation(int[] nums) {
        if(!core(nums, 0)){
            Arrays.sort(nums);
        }
    }

    /**
     * nums中，从start到结尾序列的下一个排列。返回表示是否存在下一个排列。
     * 
     */
    boolean core(int[] nums, int start) {
        if (start + 1 == nums.length)
            return false;
        boolean nextExist = core(nums, start + 1);
        // 如果下一序列不存在下一个排列。
        if (!nextExist) {
            // 如果当前值比后续序列最大值还大，则不存在下一个排列
            if (nums[start] >= nums[start + 1]) {
                return false;
            } else {
                // 找到后续排列中，当前值的下一个值（即比当前值大的所有值中最小的）
                for (int i = nums.length - 1; i > start; i--) {
                    if (nums[i] > nums[start]) {
                        swap(nums, i, start);
                        break;
                    }
                }
                // 将后续序列变为最小序列
                Arrays.sort(nums, start + 1, nums.length);
                return true;
            }

        }
        return true;
    }

    static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}