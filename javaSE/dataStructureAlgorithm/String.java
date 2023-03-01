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



class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // String key = new String(chars);
            String key = String.valueOf(chars); // convert char[] to String
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());  // convert Collection<List<String>> to List<List<String>>
    }
}
