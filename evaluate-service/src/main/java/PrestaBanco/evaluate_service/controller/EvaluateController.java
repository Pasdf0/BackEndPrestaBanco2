package PrestaBanco.evaluate_service.controller;

import PrestaBanco.evaluate_service.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    EvaluateService evaluateService;

    @GetMapping("/getAge/{id}")
    public ResponseEntity<Integer> getAge(@PathVariable Long id) {
        Integer age = evaluateService.getAge(id);
        if (age == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(age);
    }
}
