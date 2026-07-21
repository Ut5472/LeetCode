/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int lootCalculater(TreeNode root,Map<TreeNode,Integer> dp){
        //baseCase
        if(root==null){
            return 0;
        }
        if(dp.containsKey(root)){
            return dp.get(root);
        }
        //recursion
        int take = root.val;
        if (root.left != null) {
            take += lootCalculater(root.left.left, dp);
            take += lootCalculater(root.left.right, dp);
        }
        if (root.right != null) {
            take += lootCalculater(root.right.left, dp);
            take += lootCalculater(root.right.right, dp);
        }
        //not taking the current
        int leave = lootCalculater(root.left,dp) + lootCalculater(root.right,dp);
        dp.put(root,Math.max(take,leave));
        return Math.max(take,leave);
        
    }
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> dp = new HashMap<>();
        return lootCalculater(root,dp);
        
    }
}