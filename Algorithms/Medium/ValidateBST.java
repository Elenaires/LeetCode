// left child must be less than parent
// right child must be greater than parent

/* tricky test cases that fail if we use Integer.MAX_VALUE
* 1) [2147483647]
* 2) [2147483647, 2147483647]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        return BSTCheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    public boolean BSTCheck(TreeNode node, long min, long max)
    {
        boolean isBST = true;
        
        if(node != null)
        {
            if(node.val >= max || node.val <= min)
            {
                isBST = false;
            }
            else
            {
                isBST = BSTCheck(node.left, min, node.val) && BSTCheck(node.right, node.val, max);
            }         
        }
        return isBST;
    }
}
