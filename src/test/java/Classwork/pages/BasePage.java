package Classwork.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected void clickOnElement(By bySelector) {
        Selenide.$(bySelector).click();
    }

}
