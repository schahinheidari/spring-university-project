package fr.tln.univ.spring_project;

import fr.tln.univ.spring_project.entity.Course;
import fr.tln.univ.spring_project.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class SpringProjectApplication implements CommandLineRunner {
    private final CourseService courseService;
    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course course1 = new Course();
        course1.setCode(1);
        course1.setTitle("Course1");
        course1.setUnits(3);

        courseService.save(course1);
    }
}
