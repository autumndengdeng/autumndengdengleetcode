//448_Inorder_Successor_in_BST
//4/15 很啰嗦的方法：
//使用递归的方式，先判断是否找到p，如果找到的话则往回传右儿子的最往左的儿子，如果没有右儿子，则传回叶子的值，在反回的途中与 //left,right比较，若比当前小则该left或者right是要找的值。
//这里有一个flag用于判断防止root就是树的根结点然后直接返回root

public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
     
    boolean flag = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        if (root == p) {
            if (root.right != null) {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
            } else {
                return (flag == false) ? null : root;
            }
        }
        
        flag = true;
        if (p.val < root.val) {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left.val > p.val) ? left : root;
        }
        
        if (p.val > root.val) {
            TreeNode right = inorderSuccessor(root.right, p);
            return (right.val > p.val) ? right : root;
        }
        
        return root;
    }

}