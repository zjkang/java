class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

//          0
//        /   \
//       1    2
//      / \
//      3  4
TreeNode root = new TreeNode(0);
root.left = new TreeNode(1);
root.right = new TreeNode(2);
root.left.left = new TreeNode(3);
root.left.right = new TreeNode(4);



// Trie (Prefix Tree)
// method: addWord(), searchWord(), searchPrefix()
// time complexity: O(word.length)

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
    }
}


