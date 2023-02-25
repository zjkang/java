class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

ListNode head = new ListNode(0);
head.next = new ListNode(1);

while (head != null) {
    System.out.println(head.val);
    head = head.next;
}
