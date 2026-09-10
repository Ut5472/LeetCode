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
    int vals;
    int count;
    private int calculateSum(TreeNode root){
        if(root==null){
            return 0;
        }
        count++;
        int sum = 0;
        sum += calculateSum(root.left);
        sum += root.val;
        sum += calculateSum(root.right);
        return sum;

    }
    private void traversal(TreeNode root){
        if(root==null){
            return;
        }
        count = 0;
        int sum = calculateSum(root);
        if(sum/count==root.val){
            vals++;
        }
        traversal(root.left);
        traversal(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        traversal(root);
        return vals;
    }
}