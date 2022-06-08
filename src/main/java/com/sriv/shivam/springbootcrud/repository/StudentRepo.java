package com.sriv.shivam.springbootcrud.repository;

import com.sriv.shivam.springbootcrud.model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, ObjectId> {
//    void updateStudent(int id, Student student);
}