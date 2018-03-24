package ca.cmpt213.as5.CoursePlanner.Controllers;

import ca.cmpt213.as5.CoursePlanner.Model.CSV_Reader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CoursePlannerController {




    @GetMapping("/dump-model")
    public String getDumpModel() throws IOException {
      //  CSV_Reader csv_reader = new CSV_Reader();
      //  csv_reader.readData();

    return null;
    }
}
