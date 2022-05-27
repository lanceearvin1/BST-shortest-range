import java.util.Scanner;

public class BinaryTreeDemo {

    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Binary Tree Program\n");

        BinaryTree BT0 = new BinaryTree();
        BinaryTree BT1 = new BinaryTree();

        while (true) {

            //Main Menu
            System.out.println("Input 1 to run binary tree program");
            System.out.println("Input 0 to stop the program");

            String input = userInput.nextLine();
            System.out.println("");

            
            if (input.equals("1")) {
                BT0.addElement("1");
                BT0.addElement("2");
                BT0.addElement("3");
                BT0.addElement("4");
                BT0.addElement("5");
                BT0.addElement("6");
                BT0.addElement("7");

                BT1.addElement("7");
                BT1.addElement("6");
                BT1.addElement("5");
                BT1.addElement("4");
                BT1.addElement("3");
                BT1.addElement("2");
                BT1.addElement("1");
                
                // BT1.addElement("1");
                // BT1.addElement("2");
                // BT1.addElement("3");
                // BT1.addElement("4");
                // BT1.addElement("5");
                // BT1.addElement("6");
                // BT1.addElement("7");

                System.out.print("\nPostorder: ");
                BT0.postorder();
                System.out.print("\nPreorder: ");
                BT0.preorder();
                System.out.print("\nInorder: ");
                BT0.inorder();

                BT0.displayTree();

                System.out.println("\nNodes = "+ BT0.countNodes() + "\n");

                System.out.print("\nPostorder: ");
                BT1.postorder();
                System.out.print("\nPreorder: ");
                BT1.preorder();
                System.out.print("\nInorder: ");
                BT1.inorder();

                BT1.displayTree();

                System.out.println("\nNodes = "+ BT1.countNodes() + "\n");

                System.out.println("Height of tree is " + BT1.treeHeight() + "\n");
                
                System.out.println("Clone check of BT0 and BT1: " + BT0.cloneCheck(BT0.getRoot(), BT1.getRoot()));

            } else if (input.equals("0")) {
                break;
            } else {
                System.out.println("Invalid Input");
            }

        }

    }
}