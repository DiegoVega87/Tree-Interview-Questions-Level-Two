import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    /*
    * We are building a new product that relies on a binary tree data structure, and we need to be able to construct
    * the tree given its preorder and inorder traversals. We have two integer arrays, one representing the preorder
    * traversal (root, left subtree, right subtree) and the other representing the inorder traversal (left subtree,
    * root, right subtree). Can you help us implement a function that takes in these two arrays and returns the binary
    * tree?
    *
    * Example 1:
    *
    * preorder = [3,9,20,15,7]
    * inorder = [9,3,15,20,7]
    *
    *           Output:
    *         3
    *        / \
    *       9  20
    *         /  \
    *        15   7
    *
    *
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder){

        if(preorder == null || inorder == null || inorder.length != preorder.length) {
            return null;
        }

        Map<Integer, Integer> inorderValIndexPairs = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderValIndexPairs.put(inorder[i], i);
        }

        return treeBuilder(preorder, 0, preorder.length, 0, inorder.length, inorderValIndexPairs);
    }

    private TreeNode treeBuilder(int[] preorder, int preStart, int preEnd,
                                 int inStart, int inEnd, Map<Integer, Integer> map){

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(root.val);
        int numNodesLeft = rootIndex - inStart;

        root.left = treeBuilder(preorder, preStart+1, preStart+numNodesLeft,
                inStart, rootIndex -1, map);

        root.right = treeBuilder(preorder, preStart + numNodesLeft+1,
                preEnd, rootIndex + 1, inEnd, map);

        return root;

    }

}
