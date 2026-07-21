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
    private List<TreeNode> solve(int start,int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start>end){
            List<TreeNode> lis = new ArrayList<>();
            lis.add(null);
            return lis;
        }
        for(int ptr=start;ptr<=end;ptr++){
            List<TreeNode> left = solve(start,ptr-1);
            List<TreeNode> right = solve(ptr+1,end);
            for(int i=0;i<left.size();i++){
                for(int j=0;j<right.size();j++){
                    TreeNode root = new TreeNode(ptr);
                    root.left = left.get(i);
                    root.right = right.get(j);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        return solve(1,n);
    }
}