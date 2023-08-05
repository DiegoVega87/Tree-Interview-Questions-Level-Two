import java.util.ArrayList;
import java.util.List;

public class FindingKthSmallest {

    /*
    * As startup in the e-commerce industry, we have a database of all our products organized in a binary search tree.
    * We need to find the kth smallest product in our database to display it on the homepage. We need you to write a
    * function that takes in the root of our binary search tree and an integer k and returns the kth smallest product
    * in the tree.
    *
    * Example 1:
    *           Input:
    *           5
    *          / \
    *         3   7
    *        / \   \
    *       2   4   8
    * k = 3
    * Output: 4
    * Explanation: The 3rd smallest product in the tree is 4.
    *
    *
    * Example 2:
    *           Input:
    *           10
    *          / \
    *         5   15
    *        / \    \
    *       3   7    18
    *
    * k = 6
    * Output: 18
    * Explanation: The 6th smallest product in the tree is 18.
    *
    * */

    public static int findKthSmallestProduct(TreeNode root, int k){

        if(root == null ){
            return -1;
        }

        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);

        if(k > values.size() || k < 1){
            return -1;
        }

        return values.get(k-1);
    }

    private static void inorderTraversal(TreeNode root, List<Integer> values){

        if(root == null){
            return;
        }

        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }


}
