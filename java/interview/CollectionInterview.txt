// video https://www.youtube.com/watch?v=GO67C7V-IbQ&list=PLVz2XdJiJQxwS8FyWnWyKyfILxHPLsiro&index=8

1. What all collection you used in your project?
  List(I): ArrayList, LinkedList, CopyOnWrtieArrayList (concurrent)
  Set(I): HashSet, LinkedHashSet, TreeSet, CopyOnWrtieArraySet (concurrent)
  Map(I): HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap (concurrent)

2. What is the difference between list and set

3. What is the difference betwwen ArrayList and LinkedList

4. List object creation scenario

5. Declaring a list field with the final keyword?
  
6. How can I write Custom ArrayList where I do not want to allow duplicate?

7. Why Set does not allow duplicate element?
  
8. What is the difference between Comparable and Comparator?
  Comparable: Collections.sort(List)
  Comparator: Collections.sort(list, comparator)
  
9. Multi Comparing using Comparator Scenario

10. What is the difference between fail fast and fail safe iterator
A iterator which will fail fast when we do any modification whiling iterating a collection is called fail fast iterator (ArrayList, HashMap, Vector>
Iterator allows us to modify in the middle while iterating a collection is called Non-fail fast iterator. 
 (CopyOnWrtieArrayList, CopyOnWrtieArraySet, ConcurrentHashMap)

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
  String element = iterator.next();
  list.add("a"); // ConcurrentModificationException due to modCount & expectedModCOunt does not match
}
                                                                                                                         
11. What's the need of ConcurrentHashMap and how it is different from HashMap?
                                                                                                                                                                                                                                                 
12. If we have Hashtable which is already sync then why we need ConcurrentHapMap?
Locking mechanism still same as per HashMap (lock whole underlaying DS)
Hashtable lock the whole table, but ConcurrentHashMap lock per segment or bucket.

13. We can synchronize a hashmap using Collections then why can't we use that instead using ConcurrentHashMap?
If we use Collections.synchronizedMap(map) it will act as a synchronized Hashtable only where again locking mechanism is different

14. How HashMap internally works?

15. If key is null in HashMap then wehre the entry will be stored in map?

16. Map enhancement in java 8

17. How TreeMap internally works?                                                                                                                         
                                                                                                                         
                                                                                                                         
                                                                                                                         
                                                                                                                         
                                                                                                                         

                                                                                                                         
