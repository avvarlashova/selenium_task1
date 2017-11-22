package Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KinopoiskMainPage extends BasePage {
    private String searchButtonXpath = "//input[@class = 'header-search-partial-component__button']";
    private String searchFieldXpath = "//input[@class = 'header-search-partial-component__search-field']";
    private String blockCashElementCss = "#rigth_box_weekend_rus .dl";
    private String popupId = "popup_info";

    public KinopoiskMainPage(WebDriver driver){
        super(driver);
    }

    public void searchInKinopoisk(String searchText){
        WebElement searchField = driver.findElement(By.xpath(searchFieldXpath));
        searchField.sendKeys(searchText);
        clickOnElement(By.xpath(searchButtonXpath));
    }

    public void hoverElementInBlockCash(int elementNumber) {
        List<WebElement> blockCashElements = driver.findElements(By.cssSelector(blockCashElementCss));
        if(elementNumber <= (blockCashElements.size() - 1) && elementNumber >= 0) {
            Actions action = new Actions(driver);
            action.moveToElement(blockCashElements.get(elementNumber)).build().perform();
        } else {
            System.out.println("Элемент с номером "+ elementNumber + " отсутствует в списке");
        }

    }

    public void clickOnPopupWithSelectedMovie() {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        //WebElement popup = waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(popupId))));
        WebElement popup = driver.findElement(By.id(popupId));
        popup.click();
    }
}
