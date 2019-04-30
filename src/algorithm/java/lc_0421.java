class Solution {
    class TrieNode {
        public TrieNode left;
        public TrieNode right;
        public boolean flag = false;
        public int val = 0;
    }
    class TrieTree {
        TrieNode node;
        public TrieTree() {
            node = new TrieNode();
        }
        public void insert(int num) {
            TrieNode cur = this.node;
            int anchor = 1 << 30;
            for(int i=0; i<31; i++) {
                int bit = (anchor & num) == 0 ? 0 : 1;
                if (bit == 0 && cur.left == null) {
                    cur.left = new TrieNode();
                }
                if (bit == 1 && cur.right == null) {
                    cur.right = new TrieNode();
                }
                cur = bit==0? cur.left : cur.right;
                anchor >>= 1; 
            }
            cur.flag = true;
            cur.val = num;
        }
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        TrieTree tree = new TrieTree();
        for(int num : nums) {
            tree.insert(num);
        }
        TrieNode cur = tree.node;
        while (cur.left == null || cur.right == null) {
            cur = cur.left != null ? cur.left : cur.right;
        }
        return helper(cur.left, cur.right);
    }
    public int helper(TrieNode node1, TrieNode node2) {
        if (node1.flag && node2.flag) {
            return node1.val ^ node2.val;
        }        
        if (node1.left == null) {
            return helper(node1.right, node2.left == null ? node2.right : node2.left);
        }
        else if (node1.right == null) {
            return helper(node1.left, node2.right == null ? node2.left : node2.right);
        }
        else if (node2.left == null) {
            return helper(node1.left, node2.right);
        }
        else if (node2.right == null) {
            return helper(node1.right, node2.left);
        }
        else {
            return Math.max(helper(node1.left, node2.right), helper(node1.right, node2.left));
        }
    }
}
