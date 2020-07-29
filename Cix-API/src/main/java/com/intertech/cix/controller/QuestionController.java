package com.intertech.cix.controller;

import com.intertech.cix.model.Question;
import com.intertech.cix.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/newQuestion")
    public Question createQuestion(@RequestBody Question a) {
        return questionService.createQuestion(a);
    }

    @GetMapping("/name={name}")
    public Question getQuestionByTitle(@PathVariable("name") String a) {
        return questionService.getQuestionByTitle(a);
    }


    @GetMapping("/getQuestion")
    public Optional<Question> getQuestionById(@RequestParam String a) {
        return questionService.getQuestionById(a);
    }

    @PatchMapping("update_question/id={id}")
    public Question updateQuestion(@PathVariable("id") String id,@RequestBody Question a) { return questionService.updateQuestion(id,a); }

    @DeleteMapping("/delete_question/id={id}")
    public void deleteQuestion(@PathVariable("id") String id) { questionService.deleteQuestion(id); }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }
}
