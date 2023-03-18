// interview questions
1. why checked exception is called as compile time exception, does it occurs in compile time?
2. 


// Checked exception
// Checked exception must be rethrow (throws in method) or try catch
public class MyException extends Exception {

  public MyException(String message) {
    super(message);
  }
}


// Unchecked exception
// Unchecked can be throw but not need to be marked as throws in method
public class MyException extends RuntimeException {
}

