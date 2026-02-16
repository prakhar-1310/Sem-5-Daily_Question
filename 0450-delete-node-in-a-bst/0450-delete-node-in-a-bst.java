class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else if (key<root.val){
            root.left = deleteNode(root.left,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                // int min = min(root.right);
                // root.right = deleteNode(root.right,min);
                // root.val = min;

                int max = max(root.left);
                root.left = deleteNode(root.left, max);
                root.val = max;
            }
        }
        return root;
    }
    // public int min(TreeNode root){
    //     if(root==null){
    //         return Integer.MAX_VALUE;
    //     }
    //     int l = min(root.left);
    //     return Math.min(l,root.val);
    // }

    public int max(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int r = max(root.right);
        return Math.max(r,root.val);
    }
}