import java.util.List;
import java.util.Stack;

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

/**
 * InorderTraversal
 */
public class InorderTraversal {

    /**
     * 思路：从根开始
     * 
     */
    private Stack<TreeNode> stack = new Stack<>();

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode crtNode = root;
        while(true){
            if(crtNode != null){
                stack.push(crtNode);
                crtNode = crtNode.left;
            } else{
                if(stack.isEmpty()){
                    break;
                }
                TreeNode node = stack.pop();
                list.add(node.val);
                crtNode = node.right;
            }
        }
        return list;
    }




    
    public static void main(String[] args) {
        
    }

}