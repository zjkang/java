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

// ---------------------------------
// Constructor<?> class
// Refer to Constructor directory
1. clazz.getDeclaredConstructors()                       : include public or private
2. clazz.getConstructors()                               : include public only
3. clazz.getDeclaredConstructor(Class<?> ... paramType)  : include paramTypes
  // create an instance
  constructor = clazz.getDeclaredConstructor(Class<?> ... paramType)
  constructor = clazz.getDeclaredConstructor()          : default constructor
  constructor.setAccessible(true);                      : private constructor
  constructor.getParameterTypes()                       : param types for constructor
  constructor.newInstance(Ojbect ... arguments)         : create a new instance

// ---------------------------------
// inspect & modify fields
// Refer to Field directory ConfigParser & JsonWritter
1. clazz.getDeclaredFields();                             : all fields but exclude inherited
2. clazz.getDeclaredField("fieldName");                   : a field with field name
3. field.get(instance);                                   : get field value from an instance
4. field.getType();                                       : get field type
5. field.set(instance, value)                             : set field value for instance
6. field.setAccessible(true)                              : set accessible

// ---------------------------------
// inspect & invoke method
// Refer to Method directory
1. clazz.getDeclaredMethod() : current class method
2. clazz.getMethod()         : current and inherited method
3. method.getParameterTypes()
4. method.invoke(Object instance, Object ... args)

// ---------------------------------
// modifiers
1. clazz.getModifiers();
2. method.getModifiers();
3. field.getModifiers();
4. Modifier.isAbstract(modifier); : to identify modifier type (abstract)
  
// ---------------------------------
// annotations


// ---------------------------------
// dynamic proxy
1. implement invocationHandler interface
2. create Proxy class and object using Proxy.newInstance(...) method








