// how to create a new list with initialization value?

List<String> list = new ArrayList<>();
list.add("AAA");
list.add("BBB");

List<String> list = Arrays.asList("AAA", "BBB");
list.set(0, "CCC");
list.add("CCC"); // cannot add element

List<String> list = List.of("AAA", "BBB");
list.set(0, "CCC"); // cannot modify
list.add("CCC"); // cannot add element

