package field.validation_2;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * step1) Add ConstraintValidator interface
 * step2) Set Generic
 *  - Annotation type: `Score`
 *  - Validation type: `String` (validate String field in Grade.java)
 */

public class ScoreValidator implements ConstraintValidator<Score, String> {
  /**
   * The asList() method of java.util.Arrays class is used to return a fixed-size 
   * list backed by the specified array. 
   * This method acts as *** a bridge *** between array-based and collection-based APIs, 
   * in combination with Collection.toArray(). 
   * 
   * The returned list is serializable and implements RandomAccess.
   * 
      try {
 
            // Creating Arrays of Integer type
            Integer a[] = new Integer[] { 10, 20, 30, 40 };
 
            // Getting the list view of Array
            List<Integer> list = Arrays.asList(a);

            // Adding another int to the list (not supported)
            // As Arrays.asList() returns fixed size
            // list, we'll get
            // java.lang.UnsupportedOperationException
            list.add(50);

            // Printing all the elements inside list object
            System.out.println("The list is: " + list);
        }
 
        // Catch block to handle exceptions
        catch (NullPointerException | UnsupportedOperationException e) {
 
            // Print statements
            System.out.println("Exception thrown : " + e);
        }
   */
  List<String> scores = Arrays.asList(
    "A+", "A", "A-", 
    "B+", "B", "B-",
    "C+", "C", "C-",
    "D+", "D", "D-",
    "F+"
  );

  // [IMPORTANT]!!1
  // It is a heart of where the validation is happening.
  // If the value is valid return true, or otherwise return false
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    for (String score: scores) {
      if (value.equals(score)) {
        return true;
      }
    } 

    return false;
  }
}
