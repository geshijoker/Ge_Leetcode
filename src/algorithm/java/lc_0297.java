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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return null;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(root.val));
        serBuild(root.left, sb);
        serBuild(root.right, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public void serBuild(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append(',');
            sb.append('N');
        }else {
            sb.append(',');
            sb.append(Integer.toString(root.val));
            serBuild(root.left, sb);
            serBuild(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)
            return null;
        String[] stringArray = data.split(",");
        Deque<String> arr = new LinkedList<>();
        arr.addAll(Arrays.asList(stringArray));
        TreeNode root = strDecode(arr);
        return root;
    }
    
    public TreeNode strDecode(Deque<String> arr) {
        String node = arr.poll();
        if(node.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = strDecode(arr);
        root.right = strDecode(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
