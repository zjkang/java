https://www.scaler.com/topics/finalize-method-in-java/

finalize() is a method of the Object class in Java. The finalize() method is a non-static and protected method of java.lang.Object class. 
In Java, the Object class is superclass of all Java classes. Being an object class method finalize() method is available for every class in Java. 
Hence, Garbage Collector can call finalize() method on any Java object for clean-up activity.
  
By anonymous object: Anonymous objects are those objects in Java which are created without any reference variable. As a result, after creation, we have no way to access the anonymous object.
new Student();

In the above code, even though an object of Student class is created, it has no reference variable and cannot be used after creation, but it acquires memory.
By nulling reference: When an object is referenced to null value, it is considered an unreferenced object as it holds only null value.

Student s = new Student();
s = null;

Here, s is an unreferenced object that holds null value. It is considered garbage by JVM.
By assigning a reference to another object: When one object is assigned to another, first object is of no use and can be considered as garbage.

Student s1 = new Student();
Student s2 = new Student();
s1 = s2;


// -----------------------------------------
// 21. How to write your own custom immutable class
//     - Make your class final
//     - Declare all instance variable with private and final
//     - Say no to setter methods
//     - Initialize all variables in constructor and can initialize variables in constructor
//     - Perform cloning of mutable objects while returning from getter method (or create a new object)
//     * you can go with clone method but its always not recommended, disadvantage
// -----------------------------------------


