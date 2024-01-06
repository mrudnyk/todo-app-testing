Feature: task manager features

  Scenario: User creates new task
    Given user open main page
    When user adds new task with the title: "Pass the ISTQB exam"
    Then user sees new task in the list

  Scenario:  User edits task
    Given user open main page
    When user adds new task with the title: "Pass the ISTQB exam"
    And user edits task title to: "Pass the ISTQB exam next week"
    Then user sees edited task title

  Scenario: User activates task
    Given user open main page
    When user adds new task with the title: "Pass the ISTQB exam"
    And user activates task
    Then the task is activated and user can see it on the board

  Scenario: User deletes task
    Given user open main page
    When user adds new task with the title: "Pass the ISTQB exam"
    And user delete task
    Then the task is deleted and user cannot see it in the list


