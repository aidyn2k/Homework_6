package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    @BeforeAll
    static void browserSettings() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testGithub() {

        step("Opens Main page", () -> {
            open("https://github.com");
        });

        step("Searching for repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Go to repository " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });

        step("Opens Issues tab", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Checking that Issue number existing" + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}