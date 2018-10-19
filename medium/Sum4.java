import java.util.*;

/**
 * Sum4
 */
public class Sum4 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> allList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            boolean flag = false;
            for (int j = i + 1; j < len - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int l = j + 1, r = len - 1;
                while (l < r) {
                    if (l - 1 > j && nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                    if (r + 1 < len && nums[r] == nums[r + 1]) {
                        r--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        allList.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else {
                        if (sum < target) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
        }
        return allList;
    }

    public static void main(String[] args) {

        System.out.println(new Sum4().fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0));

    }
}