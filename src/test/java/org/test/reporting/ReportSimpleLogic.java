package org.test.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportSimpleLogic {

    @Test
    private static void generateReport() {
        //add specific json file to a List, then build the report
        String outputPath = "target/reports";
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/reports/cucumber.json");

        Configuration config = new Configuration(new File(outputPath), "Mini Report");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        Reportable result = reportBuilder.generateReports();
    }

}
