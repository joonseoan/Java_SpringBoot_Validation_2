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
  // WHAT IS ASList??? =======>  Next Monday!!!
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
