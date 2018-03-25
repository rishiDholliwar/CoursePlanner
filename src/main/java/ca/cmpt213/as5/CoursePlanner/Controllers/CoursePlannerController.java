package ca.cmpt213.as5.CoursePlanner.Controllers;

import ca.cmpt213.as5.CoursePlanner.Model.CSVCourseFileReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CoursePlannerController {

    String file = "data/test_data_2018.csv";


    @GetMapping("/dump-model")
    public String getDumpModel() throws IOException {
        CSVCourseFileReader csvCourseFileReader = new CSVCourseFileReader(file);
        csvCourseFileReader.getCoursesFromCSVFile();
        return null;
    }
}
