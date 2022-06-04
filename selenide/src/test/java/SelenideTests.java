import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Attribute;
import com.codeborne.selenide.conditions.Checked;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTests {

    public SelenideTests(){
        Configuration.timeout=10000;
        Configuration.browserSize="1920x1080";
        baseUrl="http://the-internet.herokuapp.com";
    }
    @Test
    public void task1(){
        open("/checkboxes");
        SelenideElement firstBox=$$("input").first();
        firstBox.setSelected(true);
        firstBox.shouldBe(Condition.checked);
        ElementsCollection allCheckboxes=$$("input");
        allCheckboxes.forEach(i -> i.shouldHave(Condition.attribute("type", "checkbox")));
    }

    @Test
    public void task2(){

            open("/dropdown");
            $("#dropdown").getSelectedOption().shouldHave(text("Please select an option"));
            $("#dropdown").selectOption("Option 2");
            $("#dropdown").getSelectedOption().shouldHave(text("Option 2"));

    }

    @Test
    public void task3(){
        open("https://demoqa.com/text-box");
        SelenideElement name=$("#userName");
        SelenideElement email=$("#userEmail");
        SelenideElement adress=$(by("placeholder", "Current Address"));
        SelenideElement adress2=$("#permanentAddress");
        SelenideElement submit=$(byText("Submit"));

        name.setValue("tato jixvashvili");
        email.setValue("tatsnnn@mail.com");
        adress.setValue("rustavi");
        adress2.setValue("rustavii");
        submit.scrollTo().click();

    }
}
