
package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private float cgpa;
    private LocalDate dateOfEnrollment;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "transcriptId",referencedColumnName = "transcriptId")
    private Transcript transcript;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "classRoomId",referencedColumnName = "classRoomId")
    private ClassRoom classRoom;

}
