package dio.gym.controllers;

import dio.gym.entities.transfers.AssessmentDTO;
import dio.gym.services.IAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/api/assessments")
public class AssessmentController {

    @Autowired
    private IAssessmentService service;

    @PostMapping
    public ResponseEntity<AssessmentDTO> create(@RequestBody AssessmentDTO assessment) {
        return new ResponseEntity(
                service.create(assessment), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssessmentDTO> findById(@PathVariable Long id) {
        return new ResponseEntity(
                service.findById(id), HttpStatus.OK
        );
    }

    @GetMapping("/evaluation")
    public ResponseEntity<Page<AssessmentDTO>> findByEvaluationDate(@RequestParam String evaluationData) {
        return new ResponseEntity(
                service.findByEvaluationDate(evaluationData), HttpStatus.OK
        );
    }

    @GetMapping("/evaluation/between")
    public ResponseEntity<Page<AssessmentDTO>> findByEvaluationDateBetweem(@RequestParam Map<String, String> dates) {
        String start = dates.get("start");
        String end = dates.get("end");

        return new ResponseEntity(
                service.findByEvaluationDateBetweem(start, end), HttpStatus.OK
        );
    }

    @GetMapping("/weight")
    public ResponseEntity<Page<AssessmentDTO>> findByWeight(@RequestParam Double weight) {
        return new ResponseEntity(
                service.findByWeight(weight), HttpStatus.OK
        );
    }

    @GetMapping("/weight/between")
    public ResponseEntity<Page<AssessmentDTO>> findByWeightBetween(@RequestParam Map<String, Double> weights) {
        Double start = weights.get("start");
        Double end = weights.get("end");

        return new ResponseEntity(
                service.findByWeightBetween(start, end), HttpStatus.OK
        );
    }

    @GetMapping("/height")
    public ResponseEntity<Page<AssessmentDTO>> findByHeight(@RequestParam Double height) {
        return new ResponseEntity(
                service.findByHeight(height), HttpStatus.OK
        );
    }

    @GetMapping("/height/beteween")
    public ResponseEntity<Page<AssessmentDTO>> findByHeightBetween(@RequestParam Map<String, Double> heights) {
        Double start = heights.get("start");
        Double end = heights.get("end");
        return new ResponseEntity(
                service.findByHeightBetween(start, end), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<Page<AssessmentDTO>> findAll() {
       return new ResponseEntity(
               service.findAll(), HttpStatus.OK
       );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody AssessmentDTO assessment) {
        return new ResponseEntity(
                service.updateById(id, assessment), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity(
                service.deleteById(id), HttpStatus.NO_CONTENT
        );
    }
}
