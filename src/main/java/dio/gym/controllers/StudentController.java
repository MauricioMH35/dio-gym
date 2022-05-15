package dio.gym.controllers;

import dio.gym.entities.transfers.StudentDTO;
import dio.gym.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/students")
public class StudentController {

    @Autowired
    private IStudentService service;

    @PostMapping
    private ResponseEntity<StudentDTO> create(@RequestBody StudentDTO student) {
        return new ResponseEntity(
                service.create(student), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        return new ResponseEntity(
                service.findById(id), HttpStatus.OK
        );
    }

    @GetMapping("/document")
    public ResponseEntity<StudentDTO> findByCpf(@RequestParam String cpf) {
        System.out.println(cpf);
        return new ResponseEntity(
                service.findByCpf(cpf), HttpStatus.OK
        );
    }

    @GetMapping("/name")
    public ResponseEntity<Page<StudentDTO>> findByNameContains(@RequestParam String contains) {
        return new ResponseEntity(
                service.findByNameContains(contains), HttpStatus.OK
        );
    }

    @GetMapping("/local")
    public ResponseEntity<Page<StudentDTO>> findByNeighborhood(@RequestParam String neighborhood) {
        return new ResponseEntity(
                service.findByNeighborhood(neighborhood), HttpStatus.OK
        );
    }

    @GetMapping("/birth")
    public ResponseEntity<Page<StudentDTO>> findByBirthDateBetween(@RequestParam Map<String, String> dates) {
        String start = dates.get("start");
        String end = dates.get("end");

        return new ResponseEntity(
                service.findByBirthDateBetween(start, end), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> findAll() {
        return new ResponseEntity(
                service.findAll(), HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody StudentDTO student) {
        return new ResponseEntity(
                service.updateById(id, student), HttpStatus.OK
        );
    }

    @PutMapping("/document")
    public ResponseEntity<String> updateByCpf(@RequestParam String cpf, @RequestBody StudentDTO student) {
        return new ResponseEntity(
                service.updateByCpf(cpf, student), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity(
                service.deleteById(id), HttpStatus.NO_CONTENT
        );
    }

    @DeleteMapping("/document")
    public ResponseEntity<String> deleteByCpf(@RequestParam String cpf) {
        return new ResponseEntity(
                service.deleteByCpf(cpf), HttpStatus.NO_CONTENT
        );
    }
}
