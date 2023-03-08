 // Stack, Queue, Deque; all can use ArrayDeque

// Stack FILO
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1); // [1]
stack.push(2); // [1,2]
stack.push(3); // [1,2,3]
System.out.println(stack.peek()); // return 3, [1,2,3]
System.out.println(stack.pop()); // return 3, [1,2]
System.out.println(stack.pop()); // return 2, [1]
System.out.println(stack.isEmpty()); // false


// ------------------------------------------
// Queue FIFO
Deque<Integer> queue = new ArrayDeque<>();
queue.offer(1); // [1]
queue.offer(2); // [1,2]
queue.offer(3); // [1,2,3]
System.out.println(queue.peek()); // return 1, not remove, [1,2,3]
System.out.println(queue.poll()); // return 1, remove, poll()处理nul，不会报错, [2,3]
System.out.println(queue.peek()); // return 2, not remove, [2,3]
System.out.println(queue.isEmpty()); // false, [1,2]


// ------------------------------------------
// Deque
Deque<Integer> deque = new ArrayDeque<>();
deque.offerLast(1); // 1
deque.offerLast(2); // 1->2
deque.offerFirst(0); // 0->1->2
System.out.println(deque.peekFirst()); // return 0, 0->1->2
System.out.println(deque.pollFirst()); // return 0, 1->2
System.out.println(deque.pollLast()); // return 2, 1


// ------------------------------------------
// Priority Queue (Heap)
PriorityQueue<Integer> pq = new PriorityQueue<>(); // default min-heap
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2); // min-heap, lambda function
PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2)); // min-heap, lambda function
PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() { // min-heap, override comparator
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
});

// use min-heap
pq.offer(2);
pq.offer(0);
pq.offer(1);
System.out.println(pq.peek()); // return 0 O(1), the top element of the heap
System.out.println(pq.poll()); // return 0 O(logn), pop the top element of the heap
System.out.println(pq.poll()); // return 1 O(logn), pop the top element of the heap

