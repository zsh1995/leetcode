import java.util.*;

/**
 * AccountsMerge
 */
public class AccountsMerge {

    int ids[];
    int childs[];
    int count;
    Map<String, Integer> email2Id = new HashMap<>();
    List<List<String>> list;
    // 存储子节点
    HashMap<Integer, Set<Integer>> sets;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        list = accounts;
        ids = new int[accounts.size()];
        childs = new int[accounts.size()];
        sets = new HashMap<>(accounts.size());

        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
            childs[i] = 1;
            Set<Integer> set = new HashSet<>();
            set.add(i);
            sets.put(i, set);
            count++;
        }

        for (int i = 0; i < ids.length; i++) {
            List<String> strs = accounts.get(i);
            for (int j = 1; j < strs.size(); j++) {
                String crt = strs.get(j);
                if (email2Id.containsKey(crt)) {
                    union(i, email2Id.get(crt));
                } else {
                    email2Id.put(crt, i);
                }
            }
        }
        List<List<String>> nList = new ArrayList<>(count);
        for(Map.Entry<Integer, Set<Integer>> tset : sets.entrySet()){
            Set<String> nSet = new HashSet<>();
            String name = "";
            for(int item : tset.getValue()){
                name = list.get(item).get(0);
                merge(nSet, list.get(item));
            }
            nSet.remove(name);
            List<String> endList = new ArrayList<>(nSet);
            Collections.sort(endList);
            endList.add(0, name);
            nList.add(endList);
        }
        
        return nList;
    }

    public int find(int p) {
        while (p != ids[p])
            p = ids[p];
        return p;
    }

    public void union(int n1, int n2) {
        int parent1 = find(n1);
        Set<Integer> c1s = sets.get(parent1);
        int parent2 = find(n2);
        Set<Integer> c2s = sets.get(parent2);
        if (parent1 == parent2)
            return;
        if (childs[parent1] > childs[parent2]) {
            ids[parent2] = parent1;
            childs[parent1] += childs[parent2];
            c1s.addAll(c2s);
            sets.remove(parent2);
        } else {
            ids[parent1] = parent2;
            childs[parent2] += childs[parent1];
            c2s.addAll(c1s);
            sets.remove(parent1);
        }
        count--;
    }

    void merge(Set<String> dst, List<String> src){
        dst.addAll(src);
    }

}