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
        TreeNode left_child = null ;
        TreeNode right_child = null ;
        TreeNode left_left_child = null;
        TreeNode left_right_child = null;
        TreeNode right_left_child = null;
        TreeNode right_right_child = null;
        if(root.left!=null){
            left_child = root.left;
            //taking two child
            if(left_child.left!=null){
                left_left_child = left_child.left;
            }
            if(left_child.right!=null){
                left_right_child = left_child.right;
            }
        }
        if(root.right!=null){
            right_child = root.right;
            if(right_child.left!=null){
                right_left_child = right_child.left;
            }
            if(right_child.right!=null){
                right_right_child = right_child.right;
            }

        }
        ////taking the current node to the answer
        int take = root.val + lootCalculater(left_left_child,dp) + lootCalculater(left_right_child,dp) + lootCalculater(right_left_child,dp) + lootCalculater(right_right_child,dp);
        //not taking the current
        int leave = lootCalculater(left_child,dp) + lootCalculater(right_child,dp);
        dp.put(root,Math.max(take,leave));
        return Math.max(take,leave);
        
    }
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> dp = new HashMap<>();
        return lootCalculater(root,dp);
        
    }
}