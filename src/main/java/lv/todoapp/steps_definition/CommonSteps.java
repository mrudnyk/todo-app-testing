package lv.todoapp.steps_definition;

import io.cucumber.java.en.Given;
import lv.todoapp.utils.LocalDriverManager;
import org.openqa.selenium.WebDriver;

import static lv.todoapp.utils.ConfigurationProperties.getConfiguration;

public class CommonSteps {
    WebDriver driver = LocalDriverManager.getInstance();

    @Given("user open main page")
    public void openMainPage() {
        driver.get(getConfiguration().getString("app.url"));
    }
}
