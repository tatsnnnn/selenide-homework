import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Attribute;
import com.codeborne.selenide.conditions.Checked;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertEquals;

public class selenide2 {

    public selenide2() {
        Configuration.timeout = 5000;
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://demoqa.com/books";
    }

    @Test
    public void testOne() {
        open("https://demoqa.com/books");
        ElementsCollection books = $(".rt-table")
                .find(".rt-tbody")
                .findAll(byAttribute("class","rt-tr-group"))
                .filterBy(text("O'Reilly Media"))
                .filterBy(matchText("JavaScript"));

        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(books.size(), 10);
        assertion.assertEquals(actual, expected);
        String actual = books.get(0).find(".rt-td", 1).getText();
        String expected = "Learning JavaScript Design Patterns" ;

        books.stream().forEach(element ->{
            element.scrollTo().find(".rt-td", 1).find(".action-buttons").click();
            SelenideElement backTopage = $(byId("addNewRecordButton"));
            backTopage.scrollTo();
            backTopage.click();

        });

    }
    @Test
    public void testTwo () {

        open("https://demoqa.com/books");
        ElementsCollection books = $(".rt-table")
                .find(".rt-tbody")
                .findAll(byAttribute("class","rt-tr-group"))
                .filterBy(text("O'Reilly Media"))
                .filterBy(matchText("JavaScript"));


    }
}
