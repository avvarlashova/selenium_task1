package Classwork;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Classwork.pages.KinopoiskMainPage;
import Classwork.pages.MovieInfoPage;
import Classwork.pages.SearchResultsPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class KinopoiskTest {
    String kinopoiskUrl = "https://www.kinopoisk.ru/";
    KinopoiskMainPage kinopoiskMainPage;
    SearchResultsPage searchResultsPage;
    MovieInfoPage movieInfoPage;

    String expectedButtonText = "искать!";

    private String searchBestResultImageXpath = "//div[@class='element most_wanted']//img";
    private String movieTitleXpath = "//h1[@class='moviename-big']";
    private String moviePosterXpath = "//a[@class = 'popupBigImage cloud-zoom']/img";
    private String movieDirectorXpath = "//div[@id = 'infoTable']//td[@itemprop = 'director']/a";


//    @Before
//    public void setUp(){
//        WebDriverRunner.getWebDriver().manage().window().fullscreen();
//    }

//    @Test
//    public void shouldFindMovieByName(){
//        chromeDriver.get(kinopoiskUrl);
//        String searchMovie = "Скотт Пилигрим против ";
//        try{
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        WebElement searchButton = chromeDriver.findElement(By.xpath(searchButtonXpath));
//        String actualButtonText = searchButton.getAttribute("value").trim().toLowerCase();
//        Assert.assertEquals(String.format("Текущее значение кнопки = [%s] не совпадает с ожидаемым [%s]", actualButtonText, expectedButtonText),
//                expectedButtonText, actualButtonText);
//        WebElement searchField = chromeDriver.findElement(By.xpath(searchFieldXpath));
//        searchField.sendKeys(searchMovie);
//        searchButton.click();
//
//        //Определяем ссылку на лучший результат
//        WebElement searchBestResultImage = chromeDriver.findElement(By.xpath(searchBestResultImageXpath));
//        searchBestResultImage.click();
//
//        //Определяем элемент для названия фильма
//        WebElement movieTitle = chromeDriver.findElement(By.xpath(movieTitleXpath));
//        String searchResultMovieName = movieTitle.getText().trim();
//        Assert.assertEquals(String.format("Найденный фильм [%s] не является фильмом [%s]", searchResultMovieName, searchMovie),
//                searchMovie, searchResultMovieName);
//
//    }

//    @Test
//    public void shouldFindMovieByName2(){
//        chromeDriver.get(kinopoiskUrl);
//        String searchMovieTitle = "Скотт Пилигрим против";
//
//        kinopoiskMainPage = new KinopoiskMainPage(chromeDriver);
//        kinopoiskMainPage.searchInKinopoisk(searchMovieTitle);
//
//        searchResultsPage = new SearchResultsPage(chromeDriver);
//        movieInfoPage = searchResultsPage.selectFirstSearchResultsItem();
//
//        String actualMovieTitle = movieInfoPage.getMovieTitle();
//
//        assertTrue(actualMovieTitle.contains(searchMovieTitle.toLowerCase()
//        ));
//
//    }

    @Test
    public void shouldVerifyPopupOnHover(){
        kinopoiskMainPage = Selenide.open(kinopoiskUrl, KinopoiskMainPage.class);
        String expectedValue = kinopoiskMainPage.hoverElementInBlockCashAndReturnName(1);
        String actualValue = kinopoiskMainPage.clickOnPopupWithSelectedMovie();
        kinopoiskMainPage.clickOnPopupWithSelectedMovie();
    }

}
