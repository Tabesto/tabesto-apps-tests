package com.runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"
                , "html:target/Pixel3/cucumber"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/GalaxyTab/cucumber-html-reports"}
        ,features = {"src/test/java/kiosk/nonReg/Order_2.feature"}
        ,glue = "steps"
        ,dryRun=false
        ,monochrome=true
        ,tags = "@test"
)
public class MyPixel4XLTestNGRunnerTest extends RunnerBase {
}