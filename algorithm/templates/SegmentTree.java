class SegmentNode {
    int start;
    int end;
    int sum;
    SegmentNode left = null;
    SegmentNode right = null;
    SegmentNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}


class SegmentTree {
    SegmentNode root = null;
    
    SegmentTree(int[] nums, int start, int end) {
        root = buildTree(nums, start, end);
    }
    
    private SegmentNode buildTree(int[] nums, int start, int end) {
        if (start == end) {
            return new SegmentNode(start, end, nums[start]);
        }
        int mid = start + (end - start) / 2;
        SegmentNode left = buildTree(nums, start, mid);
        SegmentNode right = buildTree(nums, mid + 1, end);
        SegmentNode root = new SegmentNode(start, end, left.sum + right.sum);
        root.left = left;
        root.right = right;
        return root;
    }
    
    public void updateTree(int index, int val) {
        updateTree(root, index, val);
    }
    
    private void updateTree(SegmentNode root, int index, int val) {
        if (root.start == index && root.end == index) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            updateTree(root.left, index, val);
        } else {
            updateTree(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int querySum(int i, int j) {
        return querySum(root, i, j);
    }
    
    private int querySum(SegmentNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (j <= mid) {
            return querySum(root.left, i, j);
        } else if (i > mid) {
            return querySum(root.right, i, j);
        }
        return querySum(root.left, i, mid) + querySum(root.right, mid + 1, j);
    }
}
