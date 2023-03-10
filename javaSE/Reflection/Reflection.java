// Class<?>: (wildcard ?) for generic type
1. Class<Object> objectClass = object.getClass();
2. Class<Car> carClass = Car.class;
  - ".class" suffix to a type name
  - Class booleanType = boolean.class;
3. Class.forName("package.full")
List<?>  <-- List<T> extends

  
// Constructor<?> class
1. clazz.getDeclaredConstructors()                       : include public or private
2. clazz.getConstructors()                               : include public only
3. clazz.getDeclaredConstructor(Class<?> ... paramType)  : include paramTypes

// create an instance
1. constructor = clazz.getDeclaredConstructor(Class<?> ... paramType)
   constructor = clazz.getDeclaredConstructor()          : default constructor
2. constructor.setAccessible(true);                      : private constructor
3. constructor.newInstance(Ojbect ... arguments)         : create a new instance


// inspect & modify fields
// Refer to ConfigParser & JsonWritter
1. clazz.getDeclaredFields();                             : all fields but exclude inherited
2. clazz.getDeclaredField("fieldName");                   : a field with field name
3. field.get(instance);                                   : get field value from an instance
4. field.getType();                                       : get field type
5. field.set(instance, value)                             : set field value for instance


// method
1. clazz.getDeclaredMethod() : current class method
2. clazz.getMethod()         : current and inherited method
3. method.invoke(Object instance, Object ... args)






