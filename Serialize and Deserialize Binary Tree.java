/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(q);
    }
    private TreeNode deserializeHelper(Queue<String> q) {
        String curr = q.remove();
        if ("#".equals(curr)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(curr));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        return node;
    }
}

//Time Complexity : O(N)
//Space Complexity: O(N)