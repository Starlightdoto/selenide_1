package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class SelenideRepositorySearch {

    @BeforeAll
    static private void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.headless = false;
        Configuration.timeout = 5000;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop(){
        Selenide.open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $(".repo-list").$(".repo-list-item").$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(withText("Show 2 more pages")).click();
        $("#wiki-pages-box").$(withText("SoftAssertions")).click();
        $("#wiki-body").$("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("JUnit5"));
    }
}
