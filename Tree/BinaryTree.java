import java.util.Scanner;

 class Trees{
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BinaryTree tree=new BinaryTree();
        tree.insert(sc);
        tree.printTree();
    }
    
    
}
public class BinaryTree{
    class Node{
        int data;
        Node left,right;
        Node(int key)
        {
            data=key;
            left=null;
            right=null;
        }
    }
    Node root;
    BinaryTree(){
        root=null;
    }
    //insert
    public void insert(Scanner sc)
    {
        System.out.println("Enter the root node: ");
        int value=sc.nextInt();
        root=new Node(value);
        insertNode(sc, root);

    }
    public void insertNode(Scanner sc,Node node)
    {
            System.out.println("Do you want to enter left of "+node.data);
            boolean left=sc.nextBoolean();
            if(left){
                System.out.println("Enter the value of the left of"+node.data);
                int value=sc.nextInt();
                node.left=new Node(value);
                insertNode(sc, node.left);
            }
            System.out.println("Do you want to enter right of "+node.data);
            boolean right=sc.nextBoolean();
            if(right){
                System.out.println("Enter the value of the right of"+node.data);
                int value=sc.nextInt();
                node.right=new Node(value);
                insertNode(sc, node.right);
            }
    }
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    // Function to print binary tree in 2D
    // It uses an inorder traversal approach
    void printTree(Node root, int space) {
        // Base case
        if (root == null) {
            return;
        }

        // Increase distance between levels
        space += 5;

        // Process right child first
        printTree(root.right, space);

        // Print current node after space count
        System.out.println();
        for (int i = 5; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.data);

        // Process left child
        printTree(root.left, space);
    }

    // Wrapper over printTree function
    void printTree() {
        printTree(root, 0);
    }

}