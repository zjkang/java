//Array
int[] nums = new int[10]; // new int[2]{1,2}
nums[0] = 1;
System.out.println(Arrays.toString(nums)); // [1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
// loop
for (int i = 0; i < nums.length; ++i) {
    System.out.print(nums[i] + " ");
}
for (int x: nums) {
    System.out.print(x + " ");
}


// List
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
System.out.println(list.get(0)); // return 1
list.addAll(Arrays.asList(1,2,3));
System.out.println(list); // return 1,2,1,2,3
list.remove(list.size()-1);
System.out.println(list); // return 1,2,1,2
list.set(1, 4); // return 1,4,1,2
