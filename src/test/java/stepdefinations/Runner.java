package stepdefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
  glue= {"stepdefinations"},
  monochrome=true,
  plugin = {"pretty","html:target/HtmlReports",
           "json:target/JsonReports/report.json",
           "junit:target/JUnitReports/report.xml"
              }
		)
public class Runner {
}