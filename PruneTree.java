public class PruneTree{
    static int count=1; 
    public static TreeNode prune(TreeNode root) {
        if (root==null) return null; 
        //basically here you need to check if the value of the node you're on (root) is 0, and whether it's left child node and right child node are both null
        root.left = prune(root.left); //since we made sure that root isn't null, we'll check null's left child, we use recurssive since every child is the root of some other child
        //when this starts to return, that'll be an answer for root.left, and we
        root.right = prune(root.right); //this recurssive will actually go through checking whether the root is null, and check its left and right children. The idea is that if it's left or right children has no left or right children and its self has value 0, it's already been eliminated in previous stack of recussion. 
        if (root.val!=0 || root.left!=null || root.right!=null) return root; 
        else return null; 
    }   
    
    public static void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left); 
        System.out.print(count + " tree node value is "+root.val+"\n");
        count++; 
        inorderTraverse(root.right); 
    }

    public static void main(String []args){
        TreeNode a = new TreeNode(0); //the *very* root
        TreeNode b = new TreeNode(1); //a's left child
        TreeNode c = new TreeNode(0); //b's left child
        TreeNode d = new TreeNode(1); //a's right child
        TreeNode e = new TreeNode(0); //d's left child       
        TreeNode f = new TreeNode(0); //d's right child
        a.left = b; 
        a.right = d; 
        b.left = c; 
        b.right = null; 
        d.left = e;
        d.right = f; 
        e.left = null;
        e.right = null; 
        f.left = null; 
        f.right = null; 
        TreeNode result = null;
        result = prune(a); 
        inorderTraverse(result); 
    }
}

class TreeNode {
    TreeNode left; 
    TreeNode right;
    int val; 
    TreeNode(int input) {
        this.val = input; 
    }
}
