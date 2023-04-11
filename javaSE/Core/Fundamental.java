// Double bracket initialization
// https://www.baeldung.com/java-double-brace-initialization

@Test
public void whenInitializeSetWithDoubleBraces_containsElements() {
    Set<String> countries = new HashSet<String>() {
        {
           add("India");
           add("USSR");
           add("USA");
        }
    };
 
    assertTrue(countries.contains("India"));
}


// Hash map initialization
// https://www.baeldung.com/java-initialize-hashmap
