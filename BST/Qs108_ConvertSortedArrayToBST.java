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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int low, int high) {        
        if(low > high) {
            return null;
        }
       
        int mid = low + (high - low) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = helper(nums, low, mid - 1);
        curr.right = helper(nums, mid + 1, high);
            
        return curr;    
    }
}
