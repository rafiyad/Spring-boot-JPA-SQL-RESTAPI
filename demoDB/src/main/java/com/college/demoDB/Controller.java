package controller;

import repository.Repository;
import com.example.demodb.StudentID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private Repository repository;
    // get all user
    @GetMapping("student")
    public List<StudentID> getAllStudents() {
        return repository.findAll();
    }

    // get user by id rest api
    @GetMapping("student/{id}")
    public ResponseEntity<StudentID>  getStudentID(@PathVariable Integer id) throws Exception {
        StudentID studentID = repository.findById(id).orElseThrow(() -> new Exception
                ("User not exist with id :" + id));
        return ResponseEntity.ok(studentID);
    }

    //// create user rest API
    @PostMapping("student/add")
    public StudentID createStudent(@RequestBody StudentID studentID){
        return repository.save(studentID);
    }

    // update user rest api
    @PutMapping("student/{id}")
    public ResponseEntity<StudentID> updateStudentID(
    @PathVariable Integer id,
    @RequestBody StudentID studentDetails) throws Exception {
    StudentID studentID = repository.findById(id)
    .orElseThrow(() -> new Exception("User does not exist with id: " + id));
            studentID.setName(studentDetails.getName());
            StudentID updatedUser = repository.save(studentID);
            return ResponseEntity.ok(updatedUser);
        }

        //delete user
        @DeleteMapping("student/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Integer id) throws Exception {
        StudentID studentID = repository.findById(id).orElseThrow(() -> new Exception ("Student not found"+id));
        repository.delete(studentID);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Student deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);


    }



    }
