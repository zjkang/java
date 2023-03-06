// how to create a new list with initialization value?

List<String> list = new ArrayList<>();
list.add("AAA");
list.add("BBB");


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

