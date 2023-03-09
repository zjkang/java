// Class<?>: (wildcard ?) for generic type
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
1. constructor = class.getDeclaredConstructor(Class<?> ... paramType)
   constructor = class.getDeclaredConstructor()          : default constructor
2. constructor.setAccessible(true);                      : private constructor
3. constructor.newInstance(Ojbect ... arguments)         : create a new instance


// inspect & modify fields
// Refer to ConfigParser & JsonWritter
1. class.getDeclaredFields();                             : all fields but exclude inherited
2. class.getDeclaredField("fieldName");                   : a field with field name
3. field.get(instance);                                   : get field value from an instance
4. field.getType();                                       : get field type
5. field.set(instance, value)                             : set field value for instance








