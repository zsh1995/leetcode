import java.util.HashSet;
import java.util.Set;

/**
 * UniBST
 */
public class UniBST {

    int N;
    List<TreeNode> all;

    public List<TreeNode> generateTrees(int n) {
        N = n;
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            dfs(new TreeNode(i), set, i);
        }
        return all;
    }

    void dfs(TreeNode node, Set<Integer> contains, int pre) {
        if (contains.size() == N) {
            all.add(copyTree(node));
        }

        for (int i = 1; i <= N; i++) {
            
            if (!contains.contains(i)) {
                boolean exist = false;
                if (i > pre) {
                    for (int cnt = pre + 1; cnt < i; cnt++) {
                        if (contains.contains(cnt)) {
                            exist = true;
                            break;
                        }
                    }
                } else {
                    for (int cnt = i + 1; cnt < pre; cnt++) {
                        if (contains.contains(cnt)) {
                            exist = true;
                            break;
                        }
                    }
                }
                if(exist && pre > i) continue;

                put(node, i);
                contains.add(i);
                dfs(node, contains, i);
                contains.remove(i);
                remove(node, i);
            }
        }

    }

    TreeNode copyTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        return newRoot;

    }

    TreeNode remove(TreeNode root, int n) {
        if (root.val == n)
            return null;
        if (root.val > n) {
            root.left = remove(root.left, n);
        } else {
            root.right = remove(root.right, n);
        }
        return root;
    }

    TreeNode put(TreeNode root, int n) {
        if (root == null)
            return new TreeNode(n);
        if (n < root.val) {
            root.left = put(root.left, n);
        } else {
            root.right = put(root.right, n);
        }
        return root;
    }
}