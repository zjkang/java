// reference
// https://www.baeldung.com/java-arrays-aslist-vs-list-of


// how to create a new list with initialization value?
List<String> list = new ArrayList<>();
list.add("AAA");
list.add("BBB");

List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
System.out.println(list.get(0)); // return 1
list.addAll(Arrays.asList(1,2,3));
System.out.println(list); // return 1,2,1,2,3
list.remove(list.size()-1);
System.out.println(list); // return 1,2,1,2
list.set(1, 4); // return 1,4,1,2


// common method
// What's difference between Arrays.asList and List.of
// Arrays.asList return reference to fixed size list. it throws an exception when add, but the value can be updated
// List.of return reference to unmodifiable list, java.lang.UnsupportedOperationException
List<String> list = Arrays.asList("AAA", "BBB");
list.set(0, "CCC");
list.add("CCC"); // cannot add element

List<String> list = List.of("AAA", "BBB");
list.set(0, "CCC"); // cannot modify
list.add("CCC"); // cannot add element

// What if I need to add using Arrays.asList or List.of?
List<String> list = new ArrayList<>(Arrays.asList("AAA", "BBB"));
list.add("CCC"); // cannot add element

