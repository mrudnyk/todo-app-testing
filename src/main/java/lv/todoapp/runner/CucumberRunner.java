package lv.todoapp.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lv.todoapp.utils.LocalDriverManager;
import org.testng.annotations.AfterMethod;

@CucumberOptions (tags = "",
        features = {"src/test/resources/features"},
        glue = {"lv.todoapp.steps_definition"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {

    @AfterMethod
    public static void after() {
        LocalDriverManager.closeDriver();
    }
}
