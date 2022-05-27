class LinkedList {

    // Instance Variables
    static ListNode head;

    // Linked List Node
    class ListNode {
        int data;
        ListNode next, prev;

        ListNode(int d) {
            data = d;
            next = prev = null;
        }
    }

    // Binary Tree Node
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            left = right = null;
        }
    }

    // Linked List to Binary Tree Method
    // Continously divides linked list into two. Uses uses middle element as root
    // then as left and right elements

    TreeNode listToBT() {
        int n = countreeNodes(head);

        return listToBTRecur(n);
    }

    TreeNode listToBTRecur(int n) {

        if (n <= 0)
            return null;

        // Construct Left Subtree
        TreeNode left = listToBTRecur(n / 2);

        /*
         * head_ref now refers to middle node,
         * make middle node as root of BST
         */
        TreeNode root = new TreeNode(head.data);

        // Set pointer to left subtree
        root.left = left;

        /*
         * Change head pointer of Linked List for parent
         * recursive calls
         */
        head = head.next;

        /*
         * Recursively construct the right subtree and link it
         * with root. The number of nodes in right subtree is
         * total nodes - nodes in left subtree - 1 (for root)
         */
        root.right = listToBTRecur(n - n / 2 - 1);

        return root;
    }

    // Count Method for Number of Elements in Linked List
    int countreeNodes(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    /*
     * Function to insert a node at the beginning of
     * the Doubly Linked List
     */

    void push(int new_data) {
        /* allocate node */
        ListNode new_node = new ListNode(new_data);

        /*
         * since we are adding at the beginning,
         * prev is always NULL
         */
        new_node.prev = null;

        /* link the old list off the new node */
        new_node.next = head;

        /* change prev of head node to new node */
        if (head != null)
            head.prev = new_node;

        /* move the head to point to the new node */
        head = new_node;
    }

    // Print List Method
    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Preorder Display Method
    void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Main Method
    public static void main(String[] args) {

        // Linked List Creation
        LinkedList llist = new LinkedList();

        // Add elements to Linked List
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        // Display Linked List
        System.out.println("Given Linked List ");
        llist.printList(head);

        // Call List to Binary Tree Method and Display Result
        TreeNode root = llist.listToBT();
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);
    }
}