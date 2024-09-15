package edu.mum.cs.cs425.studentmgmt.service;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface IStudentService {
    public void createStudent(Student student);


}
