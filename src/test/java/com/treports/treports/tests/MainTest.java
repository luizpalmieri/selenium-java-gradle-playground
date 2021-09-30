package com.treports.treports.tests;

import com.treports.treports.pages.TibiaAuctionPage;
import com.treports.treports.pages.TibiaHomePage;
import com.treports.treports.pages.TibiaLandPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MainTest {
    private WebDriver driver;
    private TibiaLandPage tibiaLandPage;
    private TibiaHomePage tibiaHomePage;
    private TibiaAuctionPage tibiaAuctionPage;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://www.tibia.com/");

        tibiaLandPage = new TibiaLandPage(driver);
        tibiaHomePage = new TibiaHomePage(driver);
        tibiaAuctionPage = new TibiaAuctionPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validateSearch() throws InterruptedException {
        tibiaLandPage.redirectToHomePage();

        tibiaHomePage.goToBazar();

        tibiaAuctionPage.searchBazar("Dibra", "Open PvP", "initially protected",
                                    "Sorcerer", "100", "200");

        assertTrue(tibiaAuctionPage.resultTableSize() > 0);
    }

}
