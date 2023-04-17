package src.fastAndSlowPointer;

public class CycleDetection {
    public static void main(String[] args) {
        int[][] input = {{2, 4, 6, 8, 10, 12}, {1, 3, 5, 7, 9, 11},
                {0, 1, 2, 3, 4, 6}, {3, 4, 7, 9, 11, 17}, {5, 1, 4, 9, 2, 3}};
        int[] pos = {0, -1, 1, -1, 2};
        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.println(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                PrintList.printListWithForwardArrow(list.head);
            } else {
                PrintList.printListWithForwardArrowLoop(list.head);
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = list.getLength(list.head);
                LinkedListNode lastNode = list.getNode(list.head, length - 1);
                lastNode.next = list.getNode(list.head, pos[i]);
            }
            System.out.println("\n\tDetected Cycle =  " + detectCycle(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

    public static boolean detectCycle(LinkedListNode head) {
        //Checks if the linked list is null or has only one node,
        // in which case it is not cyclic and returns false.
        if (head == null || head.next == null) {
            return false;
        }
        // Initialize slowPointer to first element
        LinkedListNode slowPointer = head.next;
        // Initialize fastPointer to second element
        LinkedListNode fastPointer = head.next.next;
        // If the fast and slow pointers meet, it means the linked list is cyclic and returns true.
        while (fastPointer != null && fastPointer != slowPointer) {
            // If fastPointer.next == null, it means end of linked list. and not cyclic.
            // So, return false.
            if (fastPointer.next == null) {
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        // If the fast pointer reaches the end of the linked list,
        // it means the linked list is not cyclic and returns false.
        return fastPointer != null;
    }
}
