
public class TreeTraversal {

    //  private static int sum = 0;

    private static Node prev = null;

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

    private static void reverseInorderGreaterSum(Node root) {
        if (root == null)
            return;

        reverseInorderGreaterSum(root.right);

        if (prev != null) {
            root.data += prev.data;
        }

        /*
            sum += root.data;
            root.data = sum;
        */

        System.out.print(root.data + " ");

        prev = root;

        reverseInorderGreaterSum(root.left);
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

    The above tree should be modified to following

              260
           /      \
         330        150
        /   \       /  \
      350   300    210   80

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

        reverseInorderGreaterSum(root);
        System.out.println();

        printInorder(root);
        System.out.println();


    }

}
