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
        root.left.left = fourth;
        root.left.right = fifth;
        root.right.right = sixth;
        root.right.right.left = seventh;
        root.right.right.left.left = eighth;


        // Calling the functions
        insert(root, 9);
        deleteNode(root, 5);
        Node lowestVal = lowestValue(root);
        Node seven = valueSearch(root, 1);


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

        System.out.print("\nThe lowest value is: " + lowestVal.data);
        System.out.println();

        System.out.println("\nNumber seven after valueSearch function: " + seven.data);
        System.out.println();

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

    //Inserting/Adding new nodes
    public static Node insert(Node node, int data){
        if(node == null){
            return new Node(data);
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    //Searching for a node in the BST
    public static Node valueSearch(Node node, int data){
        if(node.data == data){
            return node;
        }else{
            if(data > node.data){
                return valueSearch(node.right, data);
            }else{
                return valueSearch(node.left, data);
            }
        }
    }

    //Finding the lowest value in the BST
    public static Node lowestValue(Node node){
        if(node.left == null){
            return node;
        }else{
            return lowestValue(node.left);
        }
    }

    //Deleting/Removing a node from the BST
    public static Node deleteNode(Node node, int data){

        if(node == null){
            return null;

        }else if(node.data == data){
            if(node.right == null){
                return node.left;
            }else if (node.left == null){
                return node.right;
            }else{
                return null;/*In place of when the node has two child nodes*/
            }

        }else{
            if(data > node.data){
                node.right = deleteNode(node.right, data);
            }else{
                node.left = deleteNode(node.left, data);
            }
        }
        return node;

    }
}