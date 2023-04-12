package src.heap.minHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.swap;

public class GenerateMinHeap {

    public static void main(String[] args) {
        List<Integer> randomList = new ArrayList<>();
        randomList.add(3);
        randomList.add(2);
        randomList.add(4);
        randomList.add(5);
        randomList.add(1);
        randomList.add(6);

        int lastParentNodeIndex = (randomList.size() - 1) / 2;
        for (int i = lastParentNodeIndex; i >= 0; i--) {
            heapify(randomList, i);
        }
        System.out.println((randomList));
    }


    static void heapify(List<Integer> randomList, int nodeIndex) {

        // Iterate from the given parent node to its leaf node
        // The left leaf node greater than given list size indicates that the node does not have
        // children which implies the node is in its correct position.
        // So, do not enter into the loop
        while (((2 * nodeIndex) + 1) < randomList.size()) {
            int leftNodeIndex = (2 * nodeIndex) + 1;
            int rightNodeIndex = (2 * nodeIndex) + 2;
            int minimumNode;
            // If the right node index is greater than the list size, it means
            // the node does not have right child.
            // So find the minimum value between the left child node and root node
            if (rightNodeIndex >= randomList.size()) {
                minimumNode = Math.min(randomList.get(nodeIndex), randomList.get(leftNodeIndex));
            }
            // If the parent node also has right child node, find the minimum value
            // between the root node, left node and right node.
            else {
                minimumNode = getMinimumOfThree(randomList.get(nodeIndex), randomList.get(leftNodeIndex), randomList.get(rightNodeIndex));
            }
            // If minimum value is equal to the root node, then node is in its correct position
            // Do nothing. return.
            if (Objects.equals(randomList.get(nodeIndex), minimumNode)) {
                return;
            }
            // If minimum value is equal to the left node, then swap the root node with left node
            else if (Objects.equals(randomList.get(leftNodeIndex), minimumNode)) {
                swap(randomList, nodeIndex, leftNodeIndex);
                // Setting the left node index to node index to traverse till the leaf node and check
                // the root node is smaller than its children
                nodeIndex = leftNodeIndex;
            }
            // If minimum value is equal to the right node, then swap the root node with right node
            else if (Objects.equals(randomList.get(rightNodeIndex), minimumNode)) {
                swap(randomList, nodeIndex, rightNodeIndex);
                // Setting the right node index to node index to traverse till it's leaf node and check
                // the root node is smaller than its children
                nodeIndex = rightNodeIndex;
            }
        }
    }

    static int getMinimumOfThree(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}
