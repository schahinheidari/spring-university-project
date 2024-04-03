package fr.tln.univ.spring_project;

import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.entity.Student;
import fr.tln.univ.spring_project.enums.AcademicLevel;
import fr.tln.univ.spring_project.enums.Gender;
import fr.tln.univ.spring_project.service.CourseService;
import fr.tln.univ.spring_project.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class SpringProjectApplication implements CommandLineRunner {
    private final CourseService courseService;
    private final StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class,args);
    }

    @Override
    public void run(String... args){
        if (courseService.findAll().isEmpty()) {
            courseService.deleteAll();
            studentService.deleteall();


            Student student1 = new Student();
            student1.setName("name1");
            student1.setFamily("family1");
            student1.setNationalCode(123456789L);
            student1.setGender(Gender.MALE);
            student1.setBirthDate(new Date());
            student1.setUsername("userName1");
            student1.setPassword("password1");
            student1.setStdNumber(98765432L);
            student1.setAcademicLevel(AcademicLevel.MASTER);

            Course course1 = new Course();
            course1.setCode(1);
            course1.setTitle("Course1");
            course1.setUnits(3);

            courseService.save(course1);
            studentService.save(student1);

            course1.getStudents().add(student1);

            courseService.update(course1);
        }
    }
}
