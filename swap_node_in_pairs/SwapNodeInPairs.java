package swap_node_in_pairs;

import java.util.ArrayList;
import java.util.List;

public class SwapNodeInPairs {

    static class ListNode {
        int val;
        ListNode next;

        // Constructor
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prev = firstNode;
            head = firstNode.next;
        }

        return dummy.next;

    }

    public static void main(String[] args) {

        System.out.println("Running Test Cases for swapPairs:");

//        testCase(null, null, "Test Case 1: Danh sách rỗng");

//        testCase(createLinkedList(new int[]{1}), createLinkedList(new int[]{1}), "Test Case 2: Danh sách 1 phần tử");

        testCase(createLinkedList(new int[]{1, 2}), createLinkedList(new int[]{2, 1}), "Test Case 3: Danh sách 2 phần tử");

        testCase(createLinkedList(new int[]{1, 2, 3}), createLinkedList(new int[]{2, 1, 3}), "Test Case 4: Danh sách 3 phần tử");

        testCase(createLinkedList(new int[]{1, 2, 3, 4}), createLinkedList(new int[]{2, 1, 4, 3}), "Test Case 5: Danh sách 4 phần tử");

        testCase(createLinkedList(new int[]{1, 2, 3, 4, 5, 6}), createLinkedList(new int[]{2, 1, 4, 3, 6, 5}), "Test Case 6: Danh sách nhiều phần tử (chẵn)");

        testCase(createLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7}), createLinkedList(new int[]{2, 1, 4, 3, 6, 5, 7}), "Test Case 7: Danh sách nhiều phần tử (lẻ)");

        testCase(createLinkedList(new int[]{1, 1, 2, 2}), createLinkedList(new int[]{1, 1, 2, 2}), "Test Case 8: Giá trị trùng lặp");

        testCase(createLinkedList(new int[]{-1, -2, 3, -4}), createLinkedList(new int[]{-2, -1, -4, 3}), "Test Case 9: Giá trị âm");

    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void testCase(ListNode input, ListNode expected, String description) {
        System.out.println("\n--- " + description + " ---");
        System.out.println("Input: " + toList(input));
        ListNode actual = swapPairs(input); // Gọi hàm cần kiểm tra
        System.out.println("Expected: " + toList(expected));
        System.out.println("Actual: " + toList(actual));

        if (areEqual(actual, expected)) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }

    public static boolean areEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }
}
