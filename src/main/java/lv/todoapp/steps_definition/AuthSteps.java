package lv.todoapp.steps_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lv.todoapp.pages.MainPage;
import lv.todoapp.utils.LocalDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static lv.todoapp.pages.MainPage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AuthSteps {

    WebDriverWait wait = new WebDriverWait(LocalDriverManager.getInstance(), Duration.ofSeconds(5));
    MainPage mainPage = new MainPage();

    @When("user adds new task with the title: {string}")
    public void addNewTask () {
        mainPage.addNewTask(TASK_TITLE);
    }

    @Then("user sees new task in the list")
    public void userSeesNewTask () {
        wait.until(visibilityOf(mainPage.getAddedTask()));
        assertThat(mainPage.getAddedTask().getText()).isEqualTo(TASK_TITLE);
    }

    @And("user edits task title to: {string}")
    public void userEditsTask () {
        mainPage.editTask(NEW_TASK_TITLE);
    }

    @Then("user sees edited task title")
    public void userSeesEditedTask () {
        wait.until(visibilityOf(mainPage.getEditedTask()));
        Assertions.assertThat(mainPage.getEditedTask().getText()).isEqualTo(NEW_TASK_TITLE);
    }

    @And("user activates task")
    public void userActivatesTask () {
        mainPage.activateTask();
    }

    @Then("the task is activated and user can see it on the board")
    public void userSeesActivatedTask () {
        wait.until(visibilityOf(mainPage.getActivatedTaskTitle()));
        Assertions.assertThat(mainPage.getActivatedTaskTitle().getText()).isEqualTo(TASK_TITLE);
    }

    @And("user delete task")
    public void userDeleteTask () {
        mainPage.deleteTask();
    }

    @Then("the task is deleted and user cannot see it in the list")
    public void taskDeleted () {
        wait.until(visibilityOf(mainPage.getNoTasksText()));
        Assertions.assertThat(mainPage.getNoTasksText().getText()).isEqualTo(NO_TASKS_TEXT);
    }

}
