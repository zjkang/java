// sort https://www.baeldung.com/java-sorting-arrays
int[] nums = {20,2,3,4};
// 1) array sort for primitive type
Arrays.sort(nums); // sort ascending
System.out.println(Arrays.toString(nums));
// descending order by reverse: convert to sort ascending order -> reverse by swap

// 2) array sort for Object type
Integer[] nums2 = {4,2,3};
Arrays.sort(nums2);
Arrays.sort(nums2, (a, b) -> a - b); // sort ascending
Arrays.sort(nums2, (a, b) -> a.compareTo(b)); // sort ascending
Arrays.sort(nums2, Integer::compareTo); // sort ascending; method reference
Arrays.sort(nums2, Collections.reverseOrder()); // sort descending or override comparator
Arrays.sort(nums2, (a, b) -> b - a); // sort descending, override comparator
System.out.println(Arrays.toString(nums2)); // return [2,3,4]

// 3) list collection sort for Object type
List<Integer> nums = Arrays.asList(3,1,2);
nums.sort(Integer::compareTo);
nums.sort((a,b) -> a - b);
