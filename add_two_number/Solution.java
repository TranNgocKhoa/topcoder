package add_two_number;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;
        ListNode result = new ListNode();
        ListNode finalResult = result;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + extra;
            if (sum >= 10) {
                extra = 1;
            } else {
                extra = 0;
            }

            result.val = sum % 10;
            if (sum < 10 && l1.next == null && l2.next == null) {
                return finalResult;
            }

            result.next = new ListNode();

            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remain = l1 != null ? l1 : l2;
        while (remain != null) {
            int sum = remain.val + extra;
            if (sum >= 10) {
                extra = 1;
            } else {
                extra = 0;
            }

            result.val = sum % 10;

            if (extra == 0 && remain.next == null) {
                return finalResult;
            }

            result.next = new ListNode();

            result = result.next;
            remain = remain.next;
        }

        if (extra == 1) {
            result.val = 1;
        }

        return finalResult;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = new Solution().addTwoNumbers(l1, l2);

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}