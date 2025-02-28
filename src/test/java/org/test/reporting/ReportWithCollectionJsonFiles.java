package org.test.reporting;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportWithCollectionJsonFiles {

    @Test
    private static void generateReport() {
        //seek all json files, then build the report
        String outputPath = "target/reports";
        Collection<File> jsonFiles = FileUtils.listFiles(new File(outputPath), new String[] {"json"}, true);

        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        //for Java8
        //jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        //for Java
        for (File file : jsonFiles) {
            jsonPaths.add(file.getAbsolutePath());
        }

        Configuration config = new Configuration(new File(outputPath), "New Report");

        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

}
