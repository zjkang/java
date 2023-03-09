// Class<?>: (wildcard ?) Java wildcard: ? for generic type
1. Class<Object> objectClass = object.getClass();
2. Class<Car> carClass = Car.class;
  - ".class" suffix to a type name
  - Class booleanType = boolean.class;
3. Class.forName("fullName")
List<?>  <-- List<T> extends


// Constructor<?> class
1. Class.getDeclaredConstructors()                       : include public or private
2. Class.getConstructors()                               : include public only
3. Class.getDeclaredConstructor(Class<?> ... paramType)  : include paramTypes

// create an instance
1. Class.getDeclaredConstructor(Class<?> ... paramType)
2. Constructor.setAccessible(true);                      : private constructor
3. Constructor.newInstance(Ojbect ... arguments)         : create a new instance

// inspect fields
1. Class.getDeclaredFields()                             : all fields but exclude inherited






