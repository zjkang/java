// https://www.baeldung.com/java-combine-multiple-collections

// how to combine 2 collections into one
Collection<String> collectionA = Arrays.asList("S", "T");
Collection<String> collectionB = Arrays.asList("U", "V");

// Java 8
// method 1 using Stream.concat()
Stream<String> combinedStream = Stream.concat(
  collectionA.stream(),
  collectionB.stream());

Stream<String> combinedStream = Stream.of(collectionA, collectionB)
  .flatMap(Collection::stream);
Collection<String> collectionCombined = 
  combinedStream.collect(Collectors.toList());

// Java 7
List<String> listC = new ArrayList<>();
listC.addAll(listA);
listC.addAll(listB);
