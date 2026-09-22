public class PlayerLinkedList {
    private PlayerNode head;
    private int count = 0;

    public void add(Player player) {
        PlayerNode node = new PlayerNode(player);
        node.setNextPlayer(head);
        head = node;
        count++;
    }

    public void printList() {
        PlayerNode currentNode = head;

        System.out.println("HEAD ");

        while (currentNode != null) {
            System.out.print(" -> " + currentNode.getPlayer());
            currentNode = currentNode.getNextPlayer();
        }

    }

    public Player removeFirst() {
        if (head == null) {
            return null;
        }
        Player removedPLayer = head.getPlayer();
        head = head.getNextPlayer();
        count--;
        return removedPLayer;
    }

    public int size() {
        return count;
    }
}