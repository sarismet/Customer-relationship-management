package com.intertech.cix.controller;


import com.intertech.cix.model.LinkDto;
import com.intertech.cix.model.Model_Survey;
import com.intertech.cix.model.Result;
import com.intertech.cix.service.KeepingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/keep")
public class KeepingController {

    private KeepingService keepingService;

    @Autowired
    public void setKeepService(KeepingService keepingService) {
        this.keepingService = keepingService;
    }

    @PostMapping("/keepSurvey/surveyId={s_id}&customerId={c_id}")
    public LinkDto keepSurvey(@PathVariable("s_id") String surveyId, @PathVariable("c_id") String customerId) {
        return keepingService.keepSurvey( surveyId, customerId);
    }

    @PutMapping("/save")
    public Model_Survey saveAnswers(@RequestBody Map<String, String> answers,@RequestParam("id") String id){
        return keepingService.save(answers,id);
    }

    @GetMapping("/get")
    public ResponseEntity<Model_Survey> getAnswers(@RequestParam("survey_id") String surveyId, @RequestParam("unique_id") String uniqueId){
        return keepingService.check(surveyId,uniqueId);
    }
    @GetMapping("/result")
    public ResponseEntity<List<Result>> getAnswers(@RequestParam("survey_id") String surveyId){
        return ResponseEntity.ok(keepingService.getResult(surveyId));
    }
}
