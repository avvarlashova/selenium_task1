package Classwork.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class KinopoiskMainPage extends BasePage {
    private String searchButtonXpath = "//input[@class = 'header-search-partial-component__button']";
    private String searchFieldXpath = "//input[@class = 'header-search-partial-component__search-field']";
    private String blockCashElementCss = "#rigth_box_weekend_rus .dl";
    private String popupId = "popup_info";


    public void searchInKinopoisk(String searchText){
        WebElement searchField = $(By.xpath(searchFieldXpath));
        searchField.sendKeys(searchText);
        clickOnElement(By.xpath(searchButtonXpath));
    }

    public String hoverElementInBlockCashAndReturnName(int elementNumber) {
        SelenideElement element = $$(By.cssSelector(blockCashElementCss)).get(elementNumber);
        element.hover();
        return element.$("s").getText();
    }

    public String clickOnPopupWithSelectedMovie() {
        return $(By.id(popupId)).shouldBe(Condition.visible).getText();
    }
}
