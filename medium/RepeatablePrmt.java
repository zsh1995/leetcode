import java.util.*;
import java.util.Map;

/**
 * RepeatablePrmt
 */
public class RepeatablePrmt {
    public List<List<Integer>> permuteUnique(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            }else{
                count.put(nums[i], 1);
            }
        }
        Arrays.sort(nums);
        permuteCore(new ArrayList<>(), nums);
        return allList;
    }

    Map<Integer, Integer> count = new HashMap<>();

    List<List<Integer>> allList = new ArrayList<>();

    public void permuteCore(List<Integer> temp, int[] nums) {

        if (temp.size() == nums.length) {
            //allList.add(new ArrayList<>(temp));
            System.out.println(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = 0;j < temp.size();j++){
                if(temp.get(j) == nums[i]) cnt++;
            }
            if(cnt < count.get(nums[i])){
                temp.add(nums[i]);
                permuteCore(temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new RepeatablePrmt().permuteUnique(new int[]{1,2,1,3}));
    }

}