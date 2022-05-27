import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public BTNode root;

    public BTNode getRoot() {
        return root;
    }

    //Add element 
    public void addElement(String data) {
        addElement(root, data);
    }

    private void addElement(BTNode node, String data) {
        if (node == null) {
            root = new BTNode(data);
            return;
        }

        //Add element using level order traversal
        Queue<BTNode> q = new LinkedList<BTNode>();
        q.add(node);

        while (!q.isEmpty()) {
            node = q.peek();
            q.poll();

            if (node.left == null) {
                node.left = new BTNode(data);
                break; 
            } else {
                q.add(node.left);
            }

            if (node.right == null) {
                node.right = new BTNode(data);
                break;
            } else {
                q.add(node.right);
            }
        }
    }

    //Clone check 
    public boolean cloneCheck(BTNode node1, BTNode node2 ) {
        //Check root nodes, then recursively call function to check children
        if (node1 == null && node2 == null) {
            return true;
        }  

        if (node1 != null && node2 != null) {
            return (node1.data == node2.data && cloneCheck(node1.left, node2.left) && cloneCheck(node1.right, node2.right));
        }  
        return false;
    }

    //Get current tree height 
    public int treeHeight() {
        return treeHeight(root);
    }

    private int treeHeight(BTNode node)
    {
        if (node == null) {
            return 0;
        }
        
        //Increase height with every level traversed. Return height when current level has no more children
        Queue<BTNode> q = new LinkedList<BTNode>();
  
        q.add(node);
        int height = 0;
  
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0) {
                return height;
            }
            height++;
  
            while (nodeCount > 0) {
                BTNode newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }
    
    //Get current number of nodes
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BTNode node) { 
        //Default count is 1 if root is not empty. Recursively call function on children to increase the node count  
        if (node == null) {
            return 0;
        } else {
            int nodeCount = 1;
            nodeCount += countNodes(node.getLeft());
            nodeCount += countNodes(node.getRight());
            return nodeCount;
        }
    }

    //Preorder traversal
    public void preorder() {
        preorder(root);
    }

    private void preorder(BTNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    //Inorder traversal
    public void inorder() {
        inorder(root);
    }

    private void inorder(BTNode root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder(root.getRight());
        }
    }

    //Postorder traversal
    public void postorder() {
        postorder(root);
    }

    private void postorder(BTNode root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    //Print selected binary tree
    public void displayTree() {
        displayTree(root, 0);
    }
    public final int COUNT = 10;

    private void displayTree(BTNode node, int space) {
        if (node == null) {
            return;
        }

        //Reverse inorder traversal. Print elements with fixed spaces for every level
        space += COUNT;

        displayTree(node.right, space);

        System.out.print("\n");
        for (int i = COUNT; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(node.data + "\n");

        displayTree(node.left, space);
    }   
}
