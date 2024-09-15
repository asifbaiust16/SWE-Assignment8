package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.ClassRoom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.service.IClassRoomService;
import edu.mum.cs.cs425.studentmgmt.service.IStudentService;
import edu.mum.cs.cs425.studentmgmt.service.ITranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class MyStudentMgmtApplication implements CommandLineRunner {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITranscriptService transcriptService;
    @Autowired
    private IClassRoomService classRoomService;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        saveStudent();
        saveStudentWithTranscript();
        saveStudentWithClassRoom();
    }

    private void saveStudent() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Student student1 = Student.builder()
                .studentNumber("000-61-0001")
                .firstName("Anna")
                .middleName("Lynn")
                .lastName("Smith")
                .cgpa(3.45f)
                .dateOfEnrollment(LocalDate.parse("05/24/2019", formatter))
                .build();
        studentService.createStudent(student1);
    }

    private void saveStudentWithTranscript() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Student student1 = Student.builder()
                .studentNumber("000-61-0001")
                .firstName("Anna")
                .middleName("Lynn")
                .lastName("Smith")
                .cgpa(3.45f)
                .dateOfEnrollment(LocalDate.parse("05/24/2019", formatter))
                .transcript(transcriptService.createTranscript(
                            Transcript.builder()
                            .degreeTitle("BS Computer Science")
                            .build()))
                .build();
        studentService.createStudent(student1);
    }

    private void saveStudentWithClassRoom() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Student student1 = Student.builder()
                .studentNumber("000-61-0001")
                .firstName("Anna")
                .middleName("Lynn")
                .lastName("Smith")
                .cgpa(3.45f)
                .dateOfEnrollment(LocalDate.parse("05/24/2019", formatter))
                .transcript(transcriptService.createTranscript(
                        Transcript.builder()
                                .degreeTitle("BS Computer Science")
                                .build()))
                .classRoom(classRoomService.createClassRoom(ClassRoom.builder()
                        .buildingName("McLaughlin Building")
                        .roomNumber("M105")
                        .build()))
                .build();
        studentService.createStudent(student1);
    }
}
