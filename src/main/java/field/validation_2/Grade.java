package field.validation_2;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class Grade {
  /**
   * FYI, @NotEmpty does not consider the fact 
   * that user may enter a lot of white space
   * which is not considered empty but is considered blank.
   */

  // [Step 1]
  @NotBlank(message = "Name cannot be blank.")
  private String name;

  @NotBlank(message = "Subject cannot be blank")
  private String subject;

  private String score;
  private String id;

  public Grade() {
    this.id = UUID.randomUUID().toString();
  }

  public Grade(String name, String subject, String score) {
    this.name = name;
    this.subject = subject;
    this.score = score;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getScore() {
    return this.score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      " name='" + getName() + "'" +
      ", subject='" + getSubject() + "'" +
      ", score='" + getScore() + "'" +
      "}";
  }
}
