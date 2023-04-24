package field.validation_2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// Target for `Field`
@Target(ElementType.FIELD)
// It can be SOURCE, CLASS , or RUNTIME (after input from the web)
@Retention(RetentionPolicy.RUNTIME)
/**
 * Now we can call it as `Constraint` after add @Constraint
 * `Constraint` To connect validation logic, `ScoreValidator`.
 *  
 * @Constraint (validatedBy = ScoreValidator.class)
 */
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {

  // If the user violates the validation (ScoreValidator), 
  // it automatically generates "Invalid Data"
  // It can be overridden by "@Score(message = "Score must be a letter grade")" at Grade.java
  String message() default "Invalid Data";
  
  // [IMPORTANT!!!]
  // We must always define the groups and the payload parameter 
  // if we define "@Constraint()" annotation.
  // It is the boilerplate.
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};  
}
