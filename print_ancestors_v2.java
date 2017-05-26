
public class TreeTraversal {


    private static class Node {
        int data;
        private Node left;
        private Node right;
    }

    private static void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    private static boolean printAncestors(Node root, int key) {

        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (printAncestors(root.left, key) || printAncestors(root.right, key)) {
            System.out.print(root.data + " ");
            return true;
        }
        return false;
    }


    private static Node create(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }

    /*        50
           /      \
         30        70
        /   \      /  \
      20    40    60   80
            /
           35

  */

    public static void main(String[] args) {
        Node root = create(50);

        root.left = create(30);
        root.left.left = create(20);
        root.left.right = create(40);
        root.left.right.left = create(35);

        root.right = create(70);
        root.right.left = create(60);
        root.right.right = create(80);

        printInorder(root);
        System.out.println();

        printAncestors(root, 60);
        System.out.println();


    }


}
