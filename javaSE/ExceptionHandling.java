// https://www.baeldung.com/java-checked-unchecked-exceptions

// Checked Exceptions
// In general, checked exceptions represent errors outside the control of the program. 
// For example, the constructor of FileInputStream throws FileNotFoundException if the input file does not exist.
// Java verifies checked exceptions at compile-time.
  
// Some common checked exceptions in Java are IOException, SQLException and ParseException.
// The Exception class is the superclass of checked exceptions, so we can create a custom checked exception by extending Exception:


// Unchecked Exceptions
// If a program throws an unchecked exception, it reflects some error inside the program logic.
// For example, if we divide a number by 0, Java will throw ArithmeticException:
