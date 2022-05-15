package dio.gym.controllers;

import dio.gym.entities.transfers.RegistrationDTO;
import dio.gym.services.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/api/registrations")
public class RegistrationController {

    @Autowired
    private IRegistrationService service;

    @GetMapping("/enrollment/{enrollment}")
    public ResponseEntity findByEnrollmentDate(@PathVariable String enrollmentDate) {
        return new ResponseEntity(
                service.findByEnrollmentDate(enrollmentDate), HttpStatus.OK
        );
    }

    @GetMapping("/enrollment/between")
    public ResponseEntity findByEnrollmentDateBetween(@RequestParam Map<String, String> dates) {
        String start = dates.get("start");
        String end = dates.get("end");

        return new ResponseEntity(
                service.findByEnrollmentDateBetween(start, end), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(
                service.findAll(), HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody RegistrationDTO registration) {
        return new ResponseEntity<String>(
                service.updateById(id, registration), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<String>(
                service.deleteById(id), HttpStatus.NO_CONTENT
        );
    }
}
