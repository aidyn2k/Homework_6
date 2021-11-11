package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

public class AnnotationStepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    private WebSteps steps = new WebSteps();

    @BeforeAll
    static void browserSettings() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Checking for Issue number 68 ")
    @Link(name = "Github", url = "https://github.com")
    public void checkIssueNumber() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}