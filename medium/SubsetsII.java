import java.util.List;
import java.util.Map;

/**
 * SubsetsII
 */
public class SubsetsII {

    List<List<Integer>> allList = new ArrayList<>();
    Map<Integer, Integer> counts = new HashMap<>();
    Map<Integer, Integer> selfCnt = new HashMap<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        // selfCnt init
        for (int num : nums) {
            int preCnt = selfCnt.getOrDefault((Integer) num, 0);
            selfCnt.put((Integer) num, preCnt + 1);
        }

        //
        dfs(nums, -1, new ArrayList<>());

        return allList;
    }
    // 以 i 开头的所有子集
    void dfs(int[] nums, int i, List<Integer> pre) {
        if(i >= nums.length) return;
        allList.add(new ArrayList<>(pre) );
        for(int cnt = i + 1; cnt < nums.length; cnt++){
            if (cnt != i + 1 && nums[cnt] == nums[cnt - 1]) continue;
            Integer key = nums[cnt];
            int count = counts.getOrDefault(key, 0);
            if(count < selfCnt.get(key)){
                pre.add(key);
                counts.put(key, count + 1);
                dfs(nums, i + 1, pre);
                pre.remove(key);
                counts.put(key, count);
            }
        }
    }

}