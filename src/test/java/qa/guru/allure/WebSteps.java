package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Searching for repository {repo}")
    public void searchForRepository(String repo) {
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Click repository link {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Open Tab Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Check that issue {issue} exist")
    public void shouldSeeIssueWithText(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
}