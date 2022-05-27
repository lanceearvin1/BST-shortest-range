public class BTNode {

    public String data;
    public BTNode left;
    public BTNode right;

     //Constructor
     public BTNode (String data) {
        this.data = data;
        this.right = null;
        this.left = null; 
    }

    public void setLeft(BTNode n) {
        left = n;
    }

    public void setRight(BTNode n) {
        right = n;
    }

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setData(String d) {
        data = d;
    }

    public String getData() {
        return data;
    }
}
