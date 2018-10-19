import java.util.*;

/**
 * Permutation
 */
public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        permuteCore(new ArrayList<>(), nums);
        return allList;
    }

    List<List<Integer>> allList = new ArrayList<>();

    public void permuteCore(List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            allList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean repeated = false;
            for (int j = 0; j < temp.size(); j++) {
                if (nums[i] == temp.get(j)) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) {
                temp.add(nums[i]);
                permuteCore(temp, nums);
                temp.remove((Integer)nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutation().permute(new int[] { 1, 2, 3 }));
    }
}