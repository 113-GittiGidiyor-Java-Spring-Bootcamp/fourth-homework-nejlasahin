package spring.bootcamp.week4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bootcamp.week4.dto.StudentDto;
import spring.bootcamp.week4.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     *
     * @param studentDto
     * @return
     */
    @PostMapping
    public ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto studentDto){
        StudentDto result = studentService.save(studentDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     *
     * @param studentDto
     * @return
     */
    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody StudentDto studentDto){
        studentService.update(studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll(){
        List<StudentDto> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
