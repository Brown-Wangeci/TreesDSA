public class Main {

    public static void main(String[] args) {

        //Creating nodes to be used in the tree
        Node root = new Node(4);
        Node second = new Node(2);
        Node third = new Node(5);
        Node fourth = new Node(1);
        Node fifth = new Node(3);
        Node sixth = new Node(8);
        Node seventh = new Node(7);
        Node eighth = new Node(6);

        //Linking the nodes in binary search tree format

        root.left = second;
        root.right = third;
        second.left = fourth;
        second.right = fifth;
        third.right = sixth;
        sixth.left = seventh;
        seventh.left = eighth;


        //Printing the tree's node in console using different traversal methods
        System.out.println("This is the pre-order traversal result");
        preOrderTraversal(root);
        System.out.println();

        System.out.println(" \nThis is the in-order traversal result");
        inOrderTraversal(root);
        System.out.println();


        System.out.println("\nThis is the post-order traversal result");
        postOrderTraversal(root);
        System.out.println();//For spacing

    }

    //Pre-order traversal
    public static void preOrderTraversal(Node node){
        if(node == null){
            return;
        }else{
            System.out.print(node.data + " ,");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    //In-order traversal
    public static void postOrderTraversal(Node node){
        if(node == null){
            return;
        }else{
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ,");
        }
    }

    //Post-order traversal
    public static void inOrderTraversal(Node node){
        if(node == null){
            return;
        }else{
            inOrderTraversal(node.left);
            System.out.print(node.data + " ,");
            inOrderTraversal(node.right);
        }
    }
}