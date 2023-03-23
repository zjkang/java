// Hash Map
Map<String, Integer> map = new HashMap<>();
map.put("A", 0);
map.put("B", 1);
map.put("C", 2);
System.out.println(map.get("A")); // return 0
System.out.println(map.get("B")); // return 1
System.out.println(map.containsKey("B")); // return true
System.out.println(map); //{A=0,B=1,C=2}

for(Map.Entry<String, Integer> entry : map.entrySet()) {
   System.out.println(entry.getKey() + ":" + entry.getValue());
}

https://stackoverflow.com/questions/48183999/what-is-the-difference-between-putifabsent-and-computeifabsent-in-java-8-map


// putIfAbsent
// default V putIfAbsent(K key,
//                       V value)
// If the specified key is not already associated with a value (or is mapped to null) associates it with the given value and returns null, 
// else returns the current value.
// Implementation Requirements:
// The default implementation is equivalent to, for this map:
 
//  V v = map.get(key);
//  if (v == null)
//      v = map.put(key, value);

//  return v;
v = map.putIfAbsent("D", 3); // only add once key D does not in map
v == null; // if D not exist in map

// map.computeIfAbsent();
// map.computeIfPresent();


// Hash Set
Set<Integer> set = new HashSet<>();
set.add(1);
set.add(2);
System.out.println(set.contains(1)); // return true
System.out.println(set.contains(3)); // return false
for (Integer element : set) {
    System.out.println(element); // 1, 2
}
set.remove(1);


// TreeMap sorted key
TreeMap<Integer, Integer> map2 = new TreeMap<>();
map2.put(1, 1);
map2.put(0, 0);
map2.put(3, 3);
map2.get(1);
// lowerKey(), floorKey(), higherKey, ceilingKey()
System.out.println(map2.firstKey());
System.out.println(map2.lowerKey(1)); //return 0, < 1
System.out.println(map2.floorKey(1)); //return 1, <= 1
System.out.println(map2.higherKey(1)); //return 3, > 1
System.out.println(map2.ceilingKey(1)); //return 1, >= 1


// TreeSet
TreeSet<Integer> treeSet = new TreeSet<>();
treeSet.add(0);
treeSet.add(1);
System.out.println(treeSet.lower(1));
System.out.println(treeSet.floor(1));
System.out.println(treeSet.higher(1));
