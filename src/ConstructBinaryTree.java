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
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        Map<Integer,Integer>inValueIndex = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inValueIndex.put(inorder[i], i);
        }

        return treeBuilder(preorder, 0, preorder.length-1, 0,
                inorder.length-1, inValueIndex);
    }

    private TreeNode treeBuilder(int[] pre, int preStart, int preEnd, int  inStart, int inEnd,
                                 Map<Integer, Integer>map){

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int rootInIndex = map.get(root.val);
        int numOfLeftNodes = rootInIndex - inStart;

        root.left = treeBuilder(pre, preStart+1, preStart + numOfLeftNodes,
                inStart, rootInIndex-1, map);
        root.right = treeBuilder(pre, preStart+numOfLeftNodes + 1, preEnd,
                rootInIndex + 1, inEnd, map);

        return root;

    }



}
