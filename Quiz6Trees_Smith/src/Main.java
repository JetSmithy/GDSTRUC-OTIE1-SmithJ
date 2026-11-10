public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(25);
        binaryTree.insert(20);
        binaryTree.insert(15);
        binaryTree.insert(27);
        binaryTree.insert(30);
        binaryTree.insert(29);
        binaryTree.insert(26);
        binaryTree.insert(22);
        binaryTree.insert(32);

        binaryTree.traverseInOrder();

        int findIndex = 15;
        System.out.println("\nNode with value " + findIndex + " = " + binaryTree.get(findIndex));

        System.out.println("\nMin Node: " + binaryTree.getMin());
        System.out.println("Max Node: " + binaryTree.getMax());

        System.out.println("\nIn order Descending:");
        binaryTree.traverseInOrderDescending();
    }
}
