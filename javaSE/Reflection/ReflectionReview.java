// Class<?>: (wildcard ?) for generic type
// Refer to ClassDemo
1. Class<?>: Gateway to use Java reflection; put restriction like Class<? extends Collection> clazz
  List<T> extends --> List<?> for any generic T;
  but List<Interger> not extends List<Number>; List<String> not implements List<CharSequence>
2. Create Class<?>
  1. Class<Object> objectClass = object.getClass(); // cannot apply to primitive type
  2. Class<Car> carClass = Car.class;
    - ".class" suffix to a type name
    - Class booleanType = boolean.class; // can apply to primitive type
  3. Class.forName("package.full")

  
// Constructor<?> class
// Refer to Constructor/Demo.java
1. clazz.getDeclaredConstructors()                       : include public or private
2. clazz.getConstructors()                               : include public only
3. clazz.getDeclaredConstructor(Class<?> ... paramType)  : include paramTypes
  // create an instance
  constructor = clazz.getDeclaredConstructor(Class<?> ... paramType)
  constructor = clazz.getDeclaredConstructor()          : default constructor
  constructor.setAccessible(true);                      : private constructor
  constructor.newInstance(Ojbect ... arguments)         : create a new instance



// inspect & modify fields
// Refer to ConfigParser & JsonWritter
1. clazz.getDeclaredFields();                             : all fields but exclude inherited
2. clazz.getDeclaredField("fieldName");                   : a field with field name
3. field.get(instance);                                   : get field value from an instance
4. field.getType();                                       : get field type
5. field.set(instance, value)                             : set field value for instance


// inspect & invoke method
1. clazz.getDeclaredMethod() : current class method
2. clazz.getMethod()         : current and inherited method
3. method.invoke(Object instance, Object ... args)


// modifiers
clazz.getModifiers();
method.getModifiers();
field.getModifiers();







