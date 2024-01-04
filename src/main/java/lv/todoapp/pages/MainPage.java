package lv.todoapp.pages;

import lombok.Getter;
import lv.todoapp.utils.LocalDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.naming.Name;

import static org.openqa.selenium.support.How.*;

public class MainPage {

    public MainPage() {
        WebDriver driver = LocalDriverManager.getInstance();
        PageFactory.initElements(driver, this);
    }

    public static final String TASK_TITLE = "Pass the ISTQB exam";
    public static final String NEW_TASK_TITLE = "Pass the ISTQB exam next week";

    @FindBy (how = XPATH, xpath = "//button[contains(text(), 'Add New')]")
    WebElement addNewButton;

    @FindBy (how = NAME, name = "name")
    WebElement taskTitleField;

    @FindBy (how = XPATH, xpath = "//button[@type='submit']")
    WebElement addButton;

    @Getter
    @FindBy (how = XPATH, xpath = "//div[@class='view-todo__details w-full text-left p-3 bg-white rounded-md cursor-text flex border-b border-gray-300']")
    WebElement addedTask;

    @FindBy (how = XPATH, xpath = "//button[text() ='Edit']")
    WebElement editButton;

    @FindBy (how = XPATH, xpath = "//textarea[@type ='text']")
    WebElement editTaskField;

    @FindBy (how = XPATH, xpath = "//button[@type ='submit']")
    WebElement submitButton;

    @Getter
    @FindBy (how = XPATH, xpath = "//div [@class = 'view-todo__details w-full text-left p-3 bg-white rounded-md cursor-text flex border-b border-gray-300']")
    WebElement editedTask;


    public void addNewTask (String taskTitle){
        addNewButton.click();
        taskTitleField.sendKeys(taskTitle);
        addButton.click();
    }

    public void editTask (String newTaskTitle) {
        editButton.click();
        editTaskField.clear();
        editTaskField.sendKeys(newTaskTitle);
        submitButton.click();
    }

}
