import java.util.*;

/**
 * CombinationSum
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int min = candidates[0];
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> pre = new HashMap<>();
        List<List<Integer>> init = new ArrayList<>();
        init.add(new ArrayList<>(0));
        pre.put(0, init);
        for (int i = 0; i <= target / min; i++) {
            Map<Integer, List<List<Integer>>> crt = new HashMap<>();
            System.out.println(pre);
            for (int cnt = 0; cnt < candidates.length; cnt++) {
                int item = candidates[cnt];
                int tar = target - item;
                for (Map.Entry<Integer, List<List<Integer>>> entry : pre.entrySet()) {
                    if (entry.getKey() == tar) {
                        for (List<Integer> list : entry.getValue()) {
                            if (list.size() <= 0 || list.get(list.size() - 1) <= item) {
                                result.add(list);
                                list.add(item);
                            }
                        }
                    } else if (entry.getKey() < tar) {
                        List<List<Integer>> allList = new ArrayList<>();
                        
                        for (List<Integer> list : entry.getValue()) {
                            if (list.size() <= 0 || list.get(list.size() - 1) <= item) {
                                List<Integer> nList = new ArrayList<>();
                                copy(list, nList);
                                nList.add(item);
                                allList.add(nList);
                            }

                        }
                        int key = entry.getKey() + item;
                        if(crt.containsKey( key )){
                            crt.get(key).addAll(allList);
                        } else{
                            crt.put(key, allList);
                        }
                        
                    }
                }

            }
            pre = crt;
        }
        return result;
    }


    public static void copy(List src, List dst) {
        for (Object s : src) {
            dst.add(s);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[] { 2 ,7 ,3}, 18));
    }

}