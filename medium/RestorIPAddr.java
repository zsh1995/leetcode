import java.util.List;

/**
 * RestorIPAddr
 */
public class RestorIPAddr {

    List<String> all = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        char[] cs = s.toCharArray();
        dfs(cs, 0, 1, 1, new StringBuilder(s.charAt(0)));
        return all;

    }

    void dfs(char[] nums, int dots, int n, int index, StringBuilder str) {

        if (index == nums.length) {
            if (dots == 3) {
                all.add(str.toString());
            }
            return;
        }

        if (n < 3) {
            int sum = nums[index - n] - '0';
            for (int i = 1; i < n + 1; i++) {
                sum = sum * 10 + nums[index - n + i] - '0';
            }
            if (sum <= 255 && sum > 0) {
                dfs(nums, dots, n + 1, index + 1, str.append(nums[index]));
                str.delete(str.length() - 1, str.length());
            } else if (sum == 0) {
                dfs(nums, dots, 3, index + 1, str.append(nums[index]));
                str.delete(str.length() - 1, str.length());
            }
            if (dots < 3 && n != 0) {
                dfs(nums, dots + 1, 0, index, str.append('.'));
                str.delete(str.length() - 1, str.length());
            }
        }

    }

}