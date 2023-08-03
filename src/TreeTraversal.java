import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    /*
    * As a startup, we are developing a new feature for our web application that requires us to process data in a binary
    * tree structure. We need to implement a function that takes the root of a binary tree and returns a list of its
    * nodes' values in an inorder traversal.
    *
    * Example 1:
    *       Input:
    *     1
    *      \
    *       2
    *      /
    *     3
    *   Output: [1,3,2]
    *
    * Example 2:
    *       Input:
    *         5
    *        / \
    *       3   6
    *      / \
    *     2   4
    *
    *   Output: [2,3,4,5,6]
    * */

    public List<Integer> inorderTraversal(TreeNode root){

        if(root == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();

        inorderTraversal(root, list);

        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){

        if(root == null){
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
