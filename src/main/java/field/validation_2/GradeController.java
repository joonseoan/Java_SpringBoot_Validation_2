package field.validation_2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class GradeController {
  List<Grade> studentGrades = new ArrayList<>();
  
  @GetMapping("/grades")
  public String getGrades(Model model) {
    model.addAttribute("grades", studentGrades);
    return "grades";
  }

  @GetMapping("/")
  public String setForm(Model model, @RequestParam(required = false) String id) {
    int index = getGradeIndex(id);
    Grade grade;

    if (index != Constants.NOT_FOUND) {
      grade = studentGrades.get(index);
    } else {
      grade = new Grade();
    }

    // [IMPORTANT] The model instance name must be same name in "grade": grades
    // because in "handleSubmit", it return "grade" not an "newGrade"
    model.addAttribute("grade", grade);
    
    return "form";
  }

  // [Step2] enter in bad values
  // [Step3] add @Valid to validate the input.
  @PostMapping("/handleSubmit")
  public String submitGrade(@Valid Grade grade, BindingResult result) {
    // [Stet4] A `BindingResult` carries the result of the validation.
    //         `BindingResult` must come after the object that need to be validated.
    System.out.println("Has Error?: " + result.hasErrors());
    // debugger
    
    // [Step 5]
    // A negative `BindingResult` forces the user to stay in the form.
    // Stay in the form view
    // If the validation fails, it delivers grade instance
    // with each annotation error message in "errors" object.
    if (result.hasErrors()) return "form";

    // [IMPORTANT]
    // If we use `redirect`, we will loose the BindingResult.
    // Also, the previous input value will not be available.
    // if (result.hasErrors()) return "redirect:/";

    int index = getGradeIndex(grade.getId());

    if (index != Constants.NOT_FOUND) { 
      studentGrades.set(index, grade); 
    } else {
      studentGrades.add(grade);
    }

    return "redirect:/grades";
  }

  public int getGradeIndex(String id) {
    for (int i = 0; i < studentGrades.size(); i++) {
      if (studentGrades.get(i).getId().equals(id)) {
        return i;
      }
    }

    return Constants.NOT_FOUND;
  }
}
