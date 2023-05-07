// interview questions
// https://rollbar.com/blog/how-to-handle-checked-unchecked-exceptions-in-java/

// Checked exception
// Checked exception must be re-throw (throws in method) or try catch
public class MyException extends Exception {
  public MyException(String message) {
    super(message);
  }
}

// Unchecked exception
// Unchecked can be throw but not need to be marked as throws in method
public class MyException extends RuntimeException {
}

// 



