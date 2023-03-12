// https://blog.csdn.net/weixin_41615787/article/details/85115620
// int[]和Integer[],List<Integer>的相互转化
int[] nums1 = new int[]{1,2,3};
List<Integer> nums2 = Arrays.asList(1, 2, 3);

// List<Integer> -> Integer[], int[]
Integer[] a = nums2.toArray(new Integer[0]); System.out.println(Arrays.toString(a)); // Integer[]
int[] b = nums2.stream().mapToInt(Integer::intValue).toArray(); System.out.println(Arrays.toString(b)); int[]

// convert int[] -> List<Integer>, Integer[]
List<Integer> a = Arrays.stream(nums1).boxed().collect(Collectors.toList());
Integer[] b = Arrays.stream(nums1).boxed().toArray(Integer[]::new); // IntFunction<A[]>
