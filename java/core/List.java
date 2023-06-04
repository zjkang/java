// https://www.baeldung.com/java-immutable-list

@Test(expected = UnsupportedOperationException.class)
public void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {
    List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
    List<String> unmodifiableList = Collections.unmodifiableList(list);
    unmodifiableList.add("four");
}

@Test(expected = UnsupportedOperationException.class)
public final void givenUsingTheJava9_whenUnmodifiableListIsCreated_thenNotModifiable() {
    final List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
    final List<String> unmodifiableList = List.of(list.toArray(new String[]{}));
    unmodifiableList.add("four");
}
