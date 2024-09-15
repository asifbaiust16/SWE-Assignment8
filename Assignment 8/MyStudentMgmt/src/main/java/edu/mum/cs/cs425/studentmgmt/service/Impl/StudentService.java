package edu.mum.cs.cs425.studentmgmt.service.Impl;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.repository.IStudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.ITranscriptRepository;
import edu.mum.cs.cs425.studentmgmt.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    public void createStudent(Student student){
        studentRepository.save(student);
    }
}
