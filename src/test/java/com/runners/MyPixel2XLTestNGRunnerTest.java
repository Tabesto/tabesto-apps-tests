package com.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"
                , "html:target/Pixel2XL/cucumber"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/GalaxyTabA/cucumber-html-reports"}
        ,features = {"src/test/java/kiosk/EndToEndFeatures/Fonctionnel.feature"}
        ,glue = "steps"
        ,dryRun=false
        ,monochrome=true
        ,tags = "@smoke"
)
public class MyPixel2XLTestNGRunnerTest extends RunnerBase{

}