import java.util.Scanner;

public class BinaryTreeDemo {

    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Binary Tree Program\n");

        while (true) {

            //Main Menu
            System.out.println("\nInput 1 to run binary tree program");
            System.out.println("Input 0 to stop the program");

            String input = userInput.nextLine();
            System.out.println("");

            
            if (input.equals("1")) {
                LinkedList.main(args);
            } else if (input.equals("0")) {
                break;
            } else {
                System.out.println("Invalid Input");
            }

        }

    }
}