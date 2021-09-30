package com.treports.treports.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TibiaHomePage {

    public TibiaHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#charactertrade_Label")
    public WebElement tibiaBazarBtn;

    @FindBy(css = "#ActiveSubmenuItemLabel_currentcharactertrades")
    public WebElement currentActionsBtn;

    public void goToBazar() {
        tibiaBazarBtn.click();
        currentActionsBtn.click();
    }
}
