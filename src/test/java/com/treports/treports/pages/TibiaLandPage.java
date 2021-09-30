package com.treports.treports.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TibiaLandPage {

    public TibiaLandPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#cookiedialogcontent .cookiedialogbutton-right span")
    public WebElement acceptCookies;

    @FindBy(xpath = "//a[text()='» Already registered «']")
    public WebElement alreadyRegistered;

    public void redirectToHomePage() {
        acceptCookies.click();
        alreadyRegistered.click();
    }

}
