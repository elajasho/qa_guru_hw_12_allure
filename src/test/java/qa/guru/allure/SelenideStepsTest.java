package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideStepsTest {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE = "Issue_created_to_test_allure_reports";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open github mainpage", () -> {
            open("https://github.com");
        });
        step("Search repo " + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("Click link " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Click Tab Issues", () -> {
            $("#issues-tab").click();
        });
        step("Check that issue  " + ISSUE + " exist", () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });
    }
}
