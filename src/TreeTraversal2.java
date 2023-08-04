import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal2 {

    /*
    * As a data-driven startup, we aim to provide market analysis to our clients. We are currently building a binary
    * tree to store our client data. However, we have noticed that traversing the tree in a zigzag order would allow
    * us to better analyze the data. We need a function that takes the root of our binary tree and returns a zigzag
    * order traversal of its nodes' values. This means that the traversal should go from left to right for the first
    * level, then from right to left for the second level, and so on.
    *
    * Example 1:
    *  Input:
    *     3
    *    / \
    *   9  20
    *     /  \
    *    15   7
    *   Output: [3, 20, 9, 15, 7]
    *   Explanation:
    *   The zigzag level order traversal goes as follows:
    *   Level 1: 3
    *   Level 2: 20 -> 9
    *   Level 3: 15 -> 7
    *
    * Example 2:
    *       Input:
    *     1
    *    / \
    *   2   3
    *  / \   \
    * 4   5   6
    *
    * Output: [1, 3, 2, 4, 5, 6]
    *   Explanation:
    *   The zigzag level order traversal goes as follows:
    *   Level 1: 1
    *   Level 2: 3 -> 2
    *   Level 3: 4 -> 5 -> 6
    * */

    public List<Integer>zigzagTraversal(TreeNode root){

        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){

            int levelSize = queue.size();
            LinkedList<Integer> values = new LinkedList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode temp = queue.remove();

                if(leftToRight){
                    values.add(temp.val);
                }else{
                    values.addFirst(temp.val);
                }

                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            result.addAll(values);
            leftToRight = !leftToRight;

        }

        return result;
    }
}
