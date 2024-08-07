package collections;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(20);
        linkedList.append(13);
        linkedList.prepend(24);
        linkedList.prepend(10);
        System.out.println(linkedList.contains(40));
    }
}
