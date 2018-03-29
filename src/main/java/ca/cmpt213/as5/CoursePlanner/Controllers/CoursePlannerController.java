package ca.cmpt213.as5.CoursePlanner.Controllers;

import UI.PrintCSV;
import ca.cmpt213.as5.CoursePlanner.Model.CSVManager.CSVCourseFileReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Used to interact with the Model
 */
@RestController
public class CoursePlannerController {

    private String csvFile = "data/course_data_2018.csv";

    @GetMapping("/dump-model")
    public void getDumpModel() throws IOException {
        CSVCourseFileReader csvCourseFileReader = new CSVCourseFileReader(csvFile);
        PrintCSV printCSV = new PrintCSV(csvFile, csvCourseFileReader.getCoursesFromCSVFile());
        printCSV.print();
    }
}
