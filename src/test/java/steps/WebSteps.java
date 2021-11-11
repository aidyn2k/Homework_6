package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Opens Main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Searching for repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Go to repository {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Opens Issues tab")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Checking that Issue number existing {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}