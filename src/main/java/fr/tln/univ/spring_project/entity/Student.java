package fr.tln.univ.spring_project.entity;

import fr.tln.univ.spring_project.enums.AcademicRank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import fr.tln.univ.spring_project.enums.AcademicLevel;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Student extends User{
    @Column(unique = true, nullable = false, updatable = false)
    private int stdNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcademicLevel academicLevel;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();
}
