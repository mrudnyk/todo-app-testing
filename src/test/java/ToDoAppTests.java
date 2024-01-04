import lv.todoapp.pages.MainPage;
import lv.todoapp.utils.LocalDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import static lv.todoapp.pages.MainPage.NEW_TASK_TITLE;
import static lv.todoapp.pages.MainPage.TASK_TITLE;
import static lv.todoapp.utils.ConfigurationProperties.getConfiguration;
import static lv.todoapp.utils.LocalDriverManager.closeDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ToDoAppTests {

    WebDriver driver;
    Wait<WebDriver> wait;
    MainPage mainPage;

    @BeforeMethod
    public void before() {
        driver = LocalDriverManager.getInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mainPage = new MainPage();
    }

    @Test (description = "Add new task")
    public void testAddNewTaskFunction (){
        driver.get(getConfiguration().getString("app.url"));
        mainPage.addNewTask(TASK_TITLE);
        wait.until(visibilityOf(mainPage.getAddedTask()));
        assertThat(mainPage.getAddedTask().getText()).isEqualTo(TASK_TITLE);
    }

    @Test (description = "Edit task")
    public void testEditTaskFunction () {
        driver.get(getConfiguration().getString("app.url"));
        mainPage.addNewTask(TASK_TITLE);
        mainPage.editTask(NEW_TASK_TITLE);
        wait.until(visibilityOf(mainPage.getEditedTask()));
        Assertions.assertThat(mainPage.getEditedTask().getText()).isEqualTo(NEW_TASK_TITLE);
    }

    @Test ()

    @AfterMethod
    public void after() {
        closeDriver();
    }
}
