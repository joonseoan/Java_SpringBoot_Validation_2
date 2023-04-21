package field.validation_2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

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
  
}
