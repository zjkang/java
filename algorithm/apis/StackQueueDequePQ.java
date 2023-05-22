 // Stack
 Deque<Integer> stack = new ArrayDeque<>();
 stack.push(1);
 stack.push(2);
 stack.push(3);
 System.out.println(stack.peek()); // return 3
 System.out.println(stack.pop()); // return 3
 System.out.println(stack.pop()); // return 2
 System.out.println(stack.isEmpty()); // false


// Queue
Deque<Integer> queue = new ArrayDeque<>();
queue.offer(1);
queue.offer(2);
queue.offer(3);
System.out.println(queue.peek()); // return 1, not remove
System.out.println(queue.poll()); // return 1, remove, poll()处理nul，不会报错
System.out.println(queue.peek()); // return 2, not remove
System.out.println(queue.isEmpty()); // false


// Deque
Deque<Integer> deque = new ArrayDeque<>();
deque.offerLast(1); // 1
deque.offerLast(2); // 1->2
deque.offerFirst(0); // 0->1->2
System.out.println(deque.peekFirst()); // return 0
System.out.println(deque.pollFirst()); // return 0
System.out.println(deque.pollLast()); // return 2


// Priority Queue (Heap)
PriorityQueue<Integer> pq = new PriorityQueue<>(); // default min-heap
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b); // lambda function
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a.compareTo(b)); // lambda function
PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() { // override comparator
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
});

pq.offer(2);
pq.offer(0);
pq.offer(1);
pq.size(): // 3
System.out.println(pq.peek()); // return 0 O(1)
System.out.println(pq.poll()); // return 0 O(logn)
System.out.println(pq.poll()); // return 1 O(logn)


