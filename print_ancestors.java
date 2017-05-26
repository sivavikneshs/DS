

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

    private static void printAncestors(Node root, int key, int[] ancestors, int i) {

        if (root == null)
            return;

        if (root.data == key) {
            for (int k = 0; k < i; k++)
                System.out.print(ancestors[k] + " ");
            return;
        }
        ancestors[i] = root.data;
        printAncestors(root.left, key, ancestors, i + 1);
        printAncestors(root.right, key, ancestors, i + 1);
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

        printAncestors(root, 35, new int[100], 0);
        System.out.println();


    }


}
