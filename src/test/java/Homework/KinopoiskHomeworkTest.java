package Homework;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Homework.pages.KinopoiskMainPage;
import Homework.pages.MovieInfoPage;
import Homework.pages.SearchResultsPage;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class KinopoiskHomeworkTest {
    static WebDriver chromeDriver;
    String kinopoiskUrl = "https://www.kinopoisk.ru/";
    KinopoiskMainPage kinopoiskMainPage;
    SearchResultsPage searchResultsPage;
    MovieInfoPage movieInfoPage;

    private String searchBestResultImageXpath = "//div[@class='element most_wanted']//img";


    @Before
    public void setUp(){
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        chromeDriver.manage().window();
    }


    @Test
    public void shouldFindMoviePosterAndDirector(){
        chromeDriver.get(kinopoiskUrl);
        String searchMovie = "Скотт Пилигрим против всех";

        kinopoiskMainPage = new KinopoiskMainPage(chromeDriver);
        kinopoiskMainPage.searchInKinopoisk(searchMovie);

        searchResultsPage = new SearchResultsPage(chromeDriver);
        movieInfoPage = searchResultsPage.selectFirstSearchResultsItem();
        System.out.println(movieInfoPage.checkMoviePoster());
        System.out.println(movieInfoPage.checkMovieDirector());


//        WebElement searchButton = chromeDriver.findElement(By.xpath(searchButtonXpath));
//        String actualButtonText = searchButton.getAttribute("value").trim().toLowerCase();
//        Assert.assertEquals(String.format("Текущее значение кнопки = [%s] не совпадает с ожидаемым [%s]", actualButtonText, expectedButtonText),
//                expectedButtonText, actualButtonText);
//        WebElement searchField = chromeDriver.findElement(By.xpath(searchFieldXpath));
//        searchField.sendKeys(searchMovie);
//        searchButton.click();
//
//        WebElement searchBestResultImage = chromeDriver.findElement(By.xpath(searchBestResultImageXpath));
//        searchBestResultImage.click();
//
//        WebElement moviePoster = chromeDriver.findElement(By.xpath(moviePosterXpath));
//        WebElement movieDirector = chromeDriver.findElement(By.xpath(movieDirectorXpath));

    }


    @Test
    public void shouldFindMovieByName2(){
        chromeDriver.get(kinopoiskUrl);
        String searchMovieTitle = "Скотт Пилигрим против";

        kinopoiskMainPage = new KinopoiskMainPage(chromeDriver);
        kinopoiskMainPage.searchInKinopoisk(searchMovieTitle);

        searchResultsPage = new SearchResultsPage(chromeDriver);
        movieInfoPage = searchResultsPage.selectFirstSearchResultsItem();

        String actualMovieTitle = movieInfoPage.getMovieTitle();

        assertTrue(actualMovieTitle.contains(searchMovieTitle.toLowerCase()
        ));

    }

    @Test
    public void shouldVerifyPopupOnHover(){
        chromeDriver.get(kinopoiskUrl);
        kinopoiskMainPage = new Homework.pages.KinopoiskMainPage(chromeDriver);
        kinopoiskMainPage.hoverElementInBlockCash(7);
 //       kinopoiskMainPage.clickOnPopupWithSelectedMovie();
    }

    @Test
    public void shouldFindLastSequel() {
        chromeDriver.get(kinopoiskUrl);
        String searchMovieTitle = "Гарри Поттер и философский камень";

        kinopoiskMainPage = new KinopoiskMainPage(chromeDriver);
        kinopoiskMainPage.searchInKinopoisk(searchMovieTitle);

        searchResultsPage = new SearchResultsPage(chromeDriver);
        movieInfoPage = searchResultsPage.selectFirstSearchResultsItem();
        movieInfoPage.scrollToLastSequel();
        movieInfoPage.clickOnLastSequel();
    }


        @After
    public void closeDriver(){
        chromeDriver.close();
    }

    @AfterClass
    public static void afterAll(){
        chromeDriver.quit();
    }
}
