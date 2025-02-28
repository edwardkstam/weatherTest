package org.test.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class BasicNetMasterthoughtReport {

    @Test
    public void generateBasicReport() {
        System.out.println("...generateReport");

        String reportOutputPath = "target/reports";
        //collect the list for different json files in a specific folder
        Collection<File> jsonFiles = FileUtils.listFiles(new File(reportOutputPath), new String[] {"json"}, true);
        System.out.println("...json files size : "+jsonFiles.size());

        List jsonPaths = new ArrayList(jsonFiles.size());
//        for (File file : jsonFiles){
//            System.out.println("...json files name : "+file.getName());
//            System.out.println("...json files path : "+file.getPath());
//            jsonPaths.add(file.getAbsolutePath());
//        }
        jsonFiles.removeIf(file->file.length()==0);
        //add different json files (input data for generation report) to the file list
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        String buildNumber = "000";
        String projectName = "Cucumber Extent Report #1";

        Configuration config = new Configuration(new File(reportOutputPath), projectName);
        //Configuration config = new Configuration(new File("target/"), projectName);

        config.setBuildNumber(buildNumber);
        // addidtional metadata presented on main page
        //config.addClassifications("Platform", "Android");

        // optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<>();
        classificationFiles.add("cucumber-reporting.properties");
        config.addClassificationFiles(classificationFiles);

        // optional configuration - check javadoc for details
        config.setSortingMethod(SortingMethod.NATURAL);
        config.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
        config.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
//        config.addPresentationModes(PresentationMode.PARALLEL_TESTING);
        // do not make scenario failed when step has status SKIPPED
        config.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));

        //optionally specify qualifiers for each of the report json files
        config.setQualifier("Extent Report #1", "First report");
        // points to the demo trends which is not used for other tests
        config.setTrendsStatsFile(new File("target/reports/trends.json"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        Reportable result = reportBuilder.generateReports();

        //logics for validating 'result' to decide what to do if report has failed

    }
}
