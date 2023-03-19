// videos: https://www.youtube.com/watch?v=fFnuer3AD8Q&t=4158s

// 1. What is the pillar of oops concept. Encapsulation & Inheritance & Polymorphism & Abstraction
// -----------------------------------------
// 2. Where did you use this concepts in your project?
// parent class: public A add();
// child class: public B add(); // B is subclass of A. It is the override method allowed
// -----------------------------------------
// 3. Explain Exception hierarchy in Inheritance
// parent class: public A add() throws Exception;
// child class: public A add(); // child class does NOT have to throw if parent throws an exception
// parent class: public A add() throws Exception;
// child class: public A add() throws Exception; // if child class throws an exception, then parent must have to throw
// -----------------------------------------
// 4. parent child override scenario
// -----------------------------------------
// 5. can we override static and private method
// no, method hiding for static method (no override as static is for class), private scope cannot override. 
// -----------------------------------------
// 6. What is the difference of java 7 and java 8 interface?
// Java 8 Default method, static method
// -----------------------------------------
// 7. What is final, finally, and finalize
// final: keyword;
// finally: block;
// finalize: method: more info here https://www.scaler.com/topics/finalize-method-in-java/

// finalize() is a method of the Object class in Java. The finalize() method is a non-static and protected method of java.lang.Object class. 
// In Java, the Object class is superclass of all Java classes. Being an object class method finalize() method is available for every class in Java. 
// Hence, Garbage Collector can call finalize() method on any Java object for clean-up activity.
  
// By anonymous object: Anonymous objects are those objects in Java which are created without any reference variable. As a result, after creation, we have no way to access the anonymous object.
// new Student();

// In the above code, even though an object of Student class is created, it has no reference variable and cannot be used after creation, but it acquires memory.
// By nulling reference: When an object is referenced to null value, it is considered an unreferenced object as it holds only null value.

// Student s = new Student();
// s = null;

// Here, s is an unreferenced object that holds null value. It is considered garbage by JVM.
// By assigning a reference to another object: When one object is assigned to another, first object is of no use and can be considered as garbage.

// Student s1 = new Student();
// Student s2 = new Student();
// s1 = s2;

// e.g.,
// public static void main(String[] args) {
//   Demo demo - new Demo();
//   demo.m1();
//   demo=null; // no referece and can do gc, the finalize() will be invoked
//   System.gc();
// }
// -----------------------------------------
// 8. What is equals and hashcode method and its contract
// -----------------------------------------
// 9. What is exception and its hierarchy?
// https://github.com/zjkang/java/blob/main/javaSE/Core/Exception.java
// -----------------------------------------
// 10. why checked exception is called as compile time exception, does it occurs in compile time?
// -----------------------------------------
// 11. How to write custom exception?
// https://github.com/zjkang/java/blob/main/javaSE/Core/Exception.java
// -----------------------------------------
// 12. Throw and throws Exception
// -----------------------------------------
// 13. Exception tricky programming question (Exception order)
// -----------------------------------------
// 14. try, catch, finally return statement scenario questions
// -----------------------------------------
// 15. is finally block always executed?
// No, if System.exit();
// -----------------------------------------
// 16. How many ways we can create String object?
// String a = new String("abc");
// String b = "abc";
// -----------------------------------------
// 17. String object creation scenario
// -----------------------------------------
// 18. What is String Constant Pool and how it works?
// -----------------------------------------
// 19. Why String is immutable? 
// -----------------------------------------
// 20. How to use mutable class and what is the difference between StringBUffer and StringBuilder?
// -----------------------------------------
// 21. How to write your own custom immutable class
//     - Make your class final
//     - Declare all instance variable with private and final
//     - Say no to setter methods
//     - Initialize all variables in constructor and can initialize variables in constructor
//     - Perform cloning of mutable objects while returning from getter method (or create a new object)
//     * you can go with clone method but its always not recommended, disadvantage
// -----------------------------------------
// 22. Which one is good to store password in Java String or char[] & why?
// chars[]. string is immutable stored in string constant pool, will stay for long duration due to GC. GC collects the string until JVS restarted. 
// chars[] can reset as blanks or zeros after using.
// -----------------------------------------
// 23. What is Marker interface (tagging interface)? Can we create our own marker interface?
// no any method or constants in it. e.g., Serialiable, Cloneable, Remote. 
// It provides run-time type info about objects, so the compiler and JVM have additional info about the object
// CLoneable interface: if we try to clone an object that does not implement this interface, JVM throws CloneNotSupportedException. The Cloneable marker interface
// is an indicator to the JVM that we can call Object.clone() method. 
// public interface Deletable {
// }
// public class Entity implements Deletable {
// }

// public void delete(Object object) {
//   if (object instanceof Deletable) {
//     // write logic
//   }
// }


  
  
  
  
  
  
  
  
  






