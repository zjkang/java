// String
String str = new String("ab666");
str = new String(new char[]{'a', 'b', '6', '6', '6'});
// common method
System.out.println("2. String");
System.out.println(str); // ab666
System.out.println(str.charAt(0)); // 'a'
System.out.println(str.substring(1,2)); //[i,j) 'b'
System.out.println("a".compareTo("b")); //-1 "a" < "b"

String[] names = new String[]{"a", "b", "c"};
StringBuilder nameBuilder = new StringBuilder();
for (String name : names) {
    nameBuilder.append(name);
}
System.out.println(nameBuilder);
