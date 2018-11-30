import java.util.*;
/**
 * WildcardMatch
 */
public class WildcardMatch {


    // 状态
    static class State{
        static int CNT = 0;
        int sId;
        Map<Character, State> nexts = new HashMap<>();
        boolean isEnd = false;
        public State() {
            sId = CNT++;
        }
    }
    
    // 迭代版本
    public boolean isMatch(String s, String p) {
        State m = buildNFA(p);
        char[] cseq = s.toCharArray();
        List<State> pre = new ArrayList<>();
        pre.add(m);
        for(char tmp : cseq){
            List<State> crt = new ArrayList<>();
            boolean[] marked = new boolean[count];
            for(State sm : pre) {
                if(sm.nexts.containsKey(tmp)){
                    State next = sm.nexts.get(tmp);
                    if(!marked[next.sId]) {
                        crt.add(next);
                        marked[next.sId] = true;
                    }
                    
                } else if(sm.nexts.containsKey('?')) {
                    State next = sm.nexts.get('?');
                    if(!marked[next.sId]) {
                        crt.add(next);
                        marked[next.sId] = true;
                    }
                }
                if(sm.nexts.containsKey('*')) {
                    State next = sm;
                    if(!marked[next.sId]) {
                        crt.add(next);
                        marked[next.sId] = true;
                    }
                }
            }
            pre = crt;
        }
        boolean flag = false;
        for(State tmp : pre) {
            if(tmp.isEnd) {
                flag = true;break;
            }
        }
        return flag;
    }

    // 递归版本
    boolean dfs(String s, State m, int i) {
        if(m.isEnd && i < s.length()) return false;
        if(i >= s.length()) {
            return m.isEnd;
        }
        char cp = s.charAt(i);
        boolean b1 = false;
        if(m.nexts.containsKey(cp)) {
            b1 = dfs(s, m.nexts.get(cp), i + 1);
        } else if(m.nexts.containsKey('?')){
            b1 = dfs(s, m.nexts.get('?'), i + 1);
        }
        if(b1) return true;
        boolean b2 = false;
        if(m.nexts.containsKey('*')) {
            b2 = dfs(s, m, i + 1);
        }
        return b2;
    }
    
    int count = 1;
    State buildNFA(String p) {
        State.CNT = 0;
        State start = new State();
        // State end = new State();
        State pre = start;
        
        char[] patterns = p.toCharArray();
        for(int i = 0;i < patterns.length;i++) {
            char pw = patterns[i];
            if(pw != '*') {
                count++;
                State crt = new State();
                pre.nexts.put(pw, crt);
                pre = crt;
            } else {
                pre.nexts.put('*', pre);
            }
        }
        pre.isEnd = true;
        // System.out.println(pre.sId);
        return start;
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        String src = "";
        String p = "1";
        System.out.println(new WildcardMatch().isMatch(src, p));
        // System.out.println("time = " + (System.nanoTime() - start));
    }
}

