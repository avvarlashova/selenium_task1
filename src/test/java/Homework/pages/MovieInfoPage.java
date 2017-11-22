package Homework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MovieInfoPage extends BasePage {
    private String movieTitleClass = "moviename-big";
//    private String movieDirectorXpath = "(//div[@id = 'infoTable']//td[@itemprop = 'director']/a)[1]";
    private String movieDirectorXpath = "//div[@id = 'infoTable']//td[text()=\"режиссер\"]//following-sibling::td/a";
    private String moviePosterXpath = "//a[@class = 'popupBigImage cloud-zoom']/img";
    private String movieSequelRightScrollerXpath = "//*[@class = 'right-slider sequel_scroller']//*[contains(@class, 'arrows_left  right_go_button')]";
    private String movieSequelLastPosterXpath = "((//div[@class='photo_scroller'])[1]//table[@class='new_paint']//a)[last()]";

    public MovieInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getMovieTitle(){
        WebElement movieTitle = driver.findElement(By.className(movieTitleClass));
        return movieTitle.getText().toLowerCase();
    }

    public String checkMovieDirector(){
        try {
            WebElement movieDirector = driver.findElement(By.xpath(movieDirectorXpath));
            return movieDirector.getText().toLowerCase().trim();
        } catch (NoSuchElementException e){
           return "У фильма не указан режиссер";
        }

    }

    public String checkMoviePoster(){
        try {
            WebElement moviePoster = driver.findElement(By.xpath(moviePosterXpath));
            return moviePoster.getAttribute("src");
        } catch (NoSuchElementException e){
            return "У фильма нет постера";
        }

    }

    public void scrollToLastSequel(){
        WebElement sequelScroller = driver.findElement(By.xpath(movieSequelRightScrollerXpath));
        while (!sequelScroller.getAttribute("class").toLowerCase().contains("disable_left")) {sequelScroller.click();}

    }

    public void clickOnLastSequel(){
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement movieLastSequelPoster = waiter.until(ExpectedConditions.visibilityOf
                (driver.findElement(By.xpath(movieSequelLastPosterXpath))));
        movieLastSequelPoster.click();

    }
}
