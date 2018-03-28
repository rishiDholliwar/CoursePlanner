package ca.cmpt213.as5.CoursePlanner;

import ca.cmpt213.as5.CoursePlanner.Model.CSVCourseFileReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * start of application for Course Planner
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
}
