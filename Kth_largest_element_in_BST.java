
public class DirectionTraversal {

    private static int count = 0;

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

    private static void reverseInorder(Node root, int k) {

        // 2nd condition OPTIONAL to avoid unnecessary recursive calls

        if (root == null || count >= k)
            return;
        reverseInorder(root.right, k);
        count++;
        if(count == k) {
            System.out.println(root.data);
            return;
        }
        reverseInorder(root.left, k);
    }

    private static Node create(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }

    /*
                  50
               /      \
             30        70
            /   \      /  \
          20    40    60   80
    */

    public static void main(String[] args) {
        Node root = create(50);

        root.left = create(30);
        root.left.left = create(20);
        root.left.right = create(40);

        root.right = create(70);
        root.right.left = create(60);
        root.right.right = create(80);

        printInorder(root);
        System.out.println();

        reverseInorder(root, 3);
        System.out.println();
    }

}
