class SplayTree {
    TreeNode root;
    Node<Integer> tree;

    public SplayTree() {

    }

    SplayTree(int value){
        root = new TreeNode(value);
    }

    TreeNode rightRotate(TreeNode node) {
        TreeNode temp = node.left;
        node.left = temp.right;
        temp.right = node;

        return temp;
    }

    TreeNode leftRotate(TreeNode node) {
        TreeNode temp = node.right;
        node.right = temp.left;
        temp.left = node;

        return temp;
    }

    TreeNode splay(TreeNode node, int x){
        if(node==null || node.value==x) return node;

        if(node.value>x){
            if(node.left==null) return node;

            if(node.left.value>x){    //Zig-Zig (LL)
                node.left.left = splay(node.left.left, x);
                node = rightRotate(node);
            }
            else if (node.left.value<x){     //Zig-Zag (LR)
                node.left.right = splay(node.left.right, x);
                if(node.left.right != null) node.left = leftRotate(node.left);
            }

            return  (node.left==null)? node:rightRotate(node);
        }
        else {
            if(node.right==null) return node;

            if(node.right.value>x){    //Zag-Zig (RL)
                node.right.left = splay(node.right.left, x);
                if(node.right.left != null) node.right = rightRotate(node.right);
            }
            else if(node.right.value<x){   //Zag-Zag
                node.right.right = splay(node.right.right, x);
                node = leftRotate(node);
            }

            return (node.right == null)? node:leftRotate(node);
        }
    }

    TreeNode insert(TreeNode node, int x){
        if(node==null) return new TreeNode(x);

        node = splay(node, x);

        if(node.value==x) return node;

        TreeNode temp = new TreeNode(x);

        if(node.value>x){
            temp.right = node;
            temp.left = node.left;
            node.left = null;
        }
        else {
            temp.left = node;
            temp.right = node.right;
            node.right = null;
        }

        return temp;
    }

    TreeNode delete(TreeNode node, int x){
        if(node==null) return null;

        node = splay(node, x);

        if(node.value != x) return node;

        node.left  = splay(node.left, x);

        if(node.left == null) node = node.right;
        else {
            node.left.right = node.right;
            node = node.left;
        }

        return node;
    }

    Node<Integer> test(TreeNode node){
        Node<Integer> rc=null;
        if(node != null){
            rc = new Node<Integer>(node.value);
            rc.left = test(node.left);
            rc.right = test(node.right);
        }
        return rc;
    }
}
