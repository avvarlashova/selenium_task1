package Classwork.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {
    private String firstSearchResultsElementId = "FlappImg_0";

    public  SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public MovieInfoPage selectFirstSearchResultsItem(){
        clickOnElement(By.id(firstSearchResultsElementId));
        return new MovieInfoPage(driver);
    }
}
