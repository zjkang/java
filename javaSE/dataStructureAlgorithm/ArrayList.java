import java.io.Serializable;
import java.util.*;

import java.util.Arrays;

public class DataStructure implements Serializable, Cloneable {

    public static void main(String args[]) {
        //1. Array & List
        //Array
        int[] nums = new int[10]; // new int[2]{1,2}
        nums[0] = 1;
        System.out.println("1. Array");
        System.out.println(Arrays.toString(nums)); // [1, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        // loop
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for (int x: nums) {
            System.out.print(x + " ");
        }
        System.out.println();

        // List
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.get(0)); // return 1
        list.addAll(Arrays.asList(1,2,3));
        System.out.println(list); // return 1,2,1,2,3

/* ------------------------------------ */  
// unmodifiable list -> java.lang.UnsupportedOperationException
//        final List<Integer> a = List.of(1,2,3);
//        a.add(5);
//        System.out.println(a);

//        https://www.baeldung.com/convert-array-to-list-and-list-to-array
//        @Test
//        public void givenUsingCoreJava_whenArrayConvertedToList_thenCorrect() {
//            Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
//            List<Integer> targetList = Arrays.asList(sourceArray);
//        }
//        Note that this is a fixed-sized list that will still be backed by the array. If we want a standard ArrayList, we can simply instantiate one:
//
//        List<Integer> targetList = new ArrayList<Integer>(Arrays.asList(sourceArray));
      
        // https://www.baeldung.com/java-arrays-aslist-vs-list-of
        // Arrays.asList(1,2,3) return fixed size list. it throws an exception when add, but the value can be updated
        // List.of(1,2,3) return unmodifiable list
//        List<Integer> list = Arrays.asList(1,2,3);
//        list.add(4);
//       // 或者使用这种方式添加 or use List.of into constructor
//         List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
//         list.add(4);
//         System.out.println(list);
/* ------------------------------------ */      

      
//        https://blog.csdn.net/weixin_41615787/article/details/85115620
        // int[]和Integer[],List<Integer>的相互转化
        // List<Integer> -> int[], Integer[]
        int[] nums1 = new int[]{1,2,3};
        List<Integer> nums2 = Arrays.asList(1, 2, 3);
        System.out.println(nums2); // return [1,2,3]
        // convert List<Integer> to Integer[], int[]
        System.out.println(Arrays.toString(nums2.toArray())); // Integer[]
        int[] nums3 = nums2.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(nums3));
        // convert int[] -> List<Integer>, Integer[]
        List<Integer> nums4 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        Integer[] nums5 = Arrays.stream(nums1).boxed().toArray(Integer[]::new); // IntFunction<A[]>
   
//         // Object[]和List<Object>的相互转化
//         Integer[] nums1 = {1,2,3,4};
//         List<Integer> nums2 = Arrays.asList(nums1);
//         System.out.println("Object[] to List<Integer> " + nums2);
//         Integer[] nums3 = nums2.toArray(new Integer[0]); // T[]
//         System.out.println(Arrays.toString(nums3));
        
        
        
                // sort https://www.baeldung.com/java-sorting-arrays
//        int[] nums = {20,2,3,4};
////         1) array sort for primitive type
//        Arrays.sort(nums); // sort ascending
//        System.out.println(Arrays.toString(nums));
//         ??? reverse for descending order by reverse

        // 2) array sort for Object type
//        Integer[] nums2 = {4,2,3};
//        Arrays.sort(nums2);
//        Arrays.sort(nums2, (a, b) -> a - b); // sort ascending
//        Arrays.sort(nums2, (a, b) -> a.compareTo(b)); // sort ascending
//        Arrays.sort(nums2, Integer::compareTo); // sort ascending
//        Arrays.sort(nums2, Collections.reverseOrder()); // sort descending or override comparator
//        Arrays.sort(nums2, (a, b) -> b - a); // sort descending, override comparator
//        System.out.println(Arrays.toString(nums2)); // return [2,3,4]

////        // 3) list collection sort for Object type
//        List<Integer> nums = Arrays.asList(3,1,2);
//        nums.sort(Integer::compareTo);
////        Collections.sort(nums, Integer::compareTo);
//        System.out.print("List Sort for Object type: ");
//        System.out.println(nums); // return [2,3,4]
        
                // array reverse
        // ??? reverse for primitive type
        // reverse for Object type
        List<Integer> nums = Arrays.asList(2,3,4);
        Collections.reverse(nums);
        System.out.println(nums); // return [4,3,2]
        
        // reverse for Object type
        Integer[] nums = new Integer[]{1,2,3};
        Collections.reverse(Arrays.asList(nums));
        System.out.println(Arrays.toString(nums)); // return [3,2,1]

    }
}
