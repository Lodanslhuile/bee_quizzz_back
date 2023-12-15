package com.adatechschool.beequizz.entrypoint;

import com.adatechschool.beequizz.model.QuestionModel;
import com.adatechschool.beequizz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionRestController {
@Autowired
    private QuestionService questionService;

    // Create new question
    @PostMapping
    public QuestionModel createQuestion(@RequestBody QuestionModel questionModel) {
        return questionService.createQuestion(questionModel);
    }

    // Get all questions
    @GetMapping
    public List<QuestionModel> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    //Get question by ID
    @GetMapping("/{id}")
    public Optional<QuestionModel> getQuestionById(@PathVariable Long id){
       return questionService.getQuestionById(id);
    }

    // Update question by ID
    @PutMapping("/{id}")
    public QuestionModel updateQuestion(@PathVariable Long id, @RequestBody QuestionModel questionModelDetails){
        return questionService.updateQuestion(id, questionModelDetails);
    }

    // Delete all questions
    @DeleteMapping
    public String deleteAllQuestions(){
        questionService.deleteAllQuestions();
        return "All questions have been deleted successfully.";
    }

    // Delete question by ID
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
    }
}
