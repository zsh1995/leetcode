/**
 * 先建立图，再BFS寻找最短路径，把每一层各个节点能到达的上层节点保存。
 * 从最后一个节点DFS找到所有最短路
 */
public class WordLadderII {
    
    List<String> wordList;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int s=-1;
        this.wordList = wordList;
        for(int i = 0;i < wordList.size();i++) {
            if(wordList.get(i).equals(beginWord) ) {
                s = i; 
            }
        }
        if(s == -1){
            wordList.add(beginWord);
            s = wordList.size() - 1;
        }
        int N = wordList.size();
        List<Integer>[] G = (ArrayList<Integer>[])new ArrayList[N];
        
        int e=-1;
        // 初始化图
        for(int i = 0;i < N;i++) {
            String start = wordList.get(i);

            if(start.equals(endWord) ) {
                e = i;
            }
            for(int j = i + 1;j < N;j++) {
                String end = wordList.get(j);
                if( diff1(start, end) ) {
                    if(G[i] == null) G[i] = new ArrayList<>();
                    G[i].add(j);
                    if(G[j] == null) G[j] = new ArrayList<>();
                    G[j].add(i);
                }
            }
        }        
        // BFS图
        if(e == -1) new ArrayList<>();
        return bfs(G, s, e);
    }
    
    
    // BFS 寻找
    // 保存每个节点的上层可达节点
    Set<Integer>[] preNodes;
    // 保存节点所属层次
    int[] layer;

    List<List<String>> bfs(List<Integer>[] G, int start, int end) {
        all = new ArrayList<>();
        preNodes = (Set<Integer>[])new HashSet[G.length];
        layer = new int[G.length];
        // 初始化第一个节点，使用 -1 为了方便后面用0来判断是不是没被标记过。（更清晰的做法是把初始值都设为-1，而layer[start] = 0）
        layer[start] = -1;
        // 初始化数组
        // 不要用 Arrays.fill 来做，那样填充的是同一个对象。
        for(int i = 0;i < preNodes.length;i++){
            preNodes[i] = new HashSet<>();
        }
        Set<Integer> pre = new HashSet<>();
        pre.add(start);
        if(start == end) return all;

        int count = 0;
        boolean flag = false;
        while(pre.size() > 0) {
            count++;
            Set<Integer> list = new HashSet<>();
            for(int next : pre) {
                if(G[next] == null) continue;
                for(int c : G[next]) {
                    if(c == end) flag = true;
                    if( layer[c] == count || layer[c] == 0){
                        layer[c] = count;
                        preNodes[c].add(next);
                        list.add(c);
                    }
                }
            }
            if(flag) break;
            pre = list;
        }
        if(flag) {
            calcPath(start, end, new ArrayList<>());
        } 
        return all;
    }

    List<List<String>> all;
    void calcPath(int start, int end,List<String> pre) {
        pre.add(0,wordList.get(end));
        if(end == start) {
            all.add(new ArrayList<>(pre));
        } else {
            for(int tmp : preNodes[end]) {
                calcPath(start, tmp, pre);
            }
        }
        pre.remove(0);
    }
    
    boolean diff1(String s1, String s2) {
        int count = 0;
        for(int i = 0;i < s1.length();i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if(count > 1) return false;
            }   
        }
        return count == 1;
    }
}