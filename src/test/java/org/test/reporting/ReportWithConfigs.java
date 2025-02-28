package org.test.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReportWithConfigs {
    @Test
    public void generateReport() throws InterruptedException {
        System.out.println("...generateReport");
        //Thread.sleep(5000);
        //add specific json file to a List, then build the report
        String outputPath = "target/reports";
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/reports/cucumber.json");

        Configuration config = new Configuration(new File(outputPath), "Mini Report");
        config.setBuildNumber("001");
        File embeddings = config.getEmbeddingDirectory();

        System.out.println("..embeddings file :"+embeddings.getPath());

        //print metadata on report
        config.addClassifications("Platform", "Android");
        config.addClassifications("API Level", "API-27");
        config.addClassifications("OS Version", "12");


        List<String> classificationFiles = new ArrayList<>();
        classificationFiles.add("cucumber-reporting.properties");
        config.addClassificationFiles(classificationFiles);


        config.setSortingMethod(SortingMethod.NATURAL);    //Natural or Alphabetic

        //Defines additional menu buttons that enables integration with Jenkins.
        config.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);

        //Expands all scenarios by default.
        config.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);

        //Add "target" column to the report, when running the same tests many times.
        config.addPresentationModes(PresentationMode.PARALLEL_TESTING);

        // do not make scenario failed when step has status SKIPPED
        config.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));

        //config.setQualifier("Extent Report #1", "First report");

        //config.setQualifier("/target/reports/cucumber.json", "First report");

        // points to the demo trends which is not used for other tests
//        config.setTrendsStatsFile(new File("target/reports/trends.json"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        Reportable result = reportBuilder.generateReports();

    }

}
