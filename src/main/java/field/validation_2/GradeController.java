package field.validation_2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {
  List<Grade> studentGrades = new ArrayList<>();
  
  @GetMapping("/grades")
  public String getGrades(Model model) {
    model.addAttribute("grades", studentGrades);
    return "grades";
  }
  // ------------------------- Form -------------------------

  @GetMapping("/")
  public String setForm(Model model, @RequestParam(required = false) String id) {
    int index = getGradeIndex(id);
    Grade grade;

    if (index != Constants.NOT_FOUND) {
      grade = studentGrades.get(index);
    } else {
      grade = new Grade();
    }

    model.addAttribute("newGrade", grade);
    
    return "form";
  }

  @PostMapping("/handleSubmit")
  public String submitGrade(Grade grade) { 
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
