package com.sriv.shivam.springbootcrud.controller;

import com.sriv.shivam.springbootcrud.model.Student;
import com.sriv.shivam.springbootcrud.repository.StudentRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @RequestMapping(method = RequestMethod.GET, value = "/getStudents")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/postStudents")
    public String saveStudent(@RequestBody Student student){
        repo.save(student);
        return "Added Successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable ObjectId id) {
        repo.deleteById(id);
        return "Deleted Successfully";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateStudent/{id}")
    public String updateStudent(@PathVariable ObjectId id, @RequestBody Student student) {
        Optional<Student> data = repo.findById(id);
        if(data.isPresent()) {
            Student student1 = data.get();
            student1.setStudentName(student.getStudentName());
            student1.setStudentHobby(student.getStudentHobby());
            return "Updated Successfully";
        }
        else {
            return "Update Failed";
        }
    }
}
