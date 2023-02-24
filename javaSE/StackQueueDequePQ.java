 //6. Stack
 Deque<Integer> stack = new ArrayDeque<>();
 stack.push(1);
 stack.push(2);
 stack.push(3);
 System.out.println(stack.peek()); // return 3
 System.out.println(stack.pop()); // return 3
 System.out.println(stack.pop()); // return 2
 System.out.println(stack.isEmpty()); // false


//7. Queue
Deque<Integer> queue = new ArrayDeque<>();
queue.offer(1);
queue.offer(2);
queue.offer(3);
System.out.println(queue.peek()); // return 1, not remove
System.out.println(queue.poll()); // return 1, remove, poll()处理nul，不会报错
System.out.println(queue.peek()); // return 2, not remove
System.out.println(queue.isEmpty()); // false




