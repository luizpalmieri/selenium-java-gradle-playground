package com.treports.treports.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TibiaAuctionPage {

    public TibiaAuctionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Dibra | Zenobra | Honbra | Unisera
    @FindBy(name = "filter_world")
    public WebElement filterWorld;

    // Open PvP | Retro Open PvP | Retro Hardcore PvP
    @FindBy(name = "filter_worldpvptype")
    public WebElement filterPvpType;

    // initially protected | protected
    @FindBy(name = "filter_worldbattleyestate")
    public WebElement filterBattleyeState;

    // Character Level | Axe Fighting | Magic Level
    @FindBy(css = "#FilterCharacterTrades > tbody > tr:nth-child(1) > td > div > table > tbody > tr > td > form > div:nth-child(6) > select.AuctionInput")
    public WebElement filterSortBy;

    // "highest / latest" | "lowest / earliest"
    @FindBy(css = ".AuctionInputLong")
    public WebElement filterSortType;

    // Druid | Royal Paladin | Master Sorcerer | Knight
    @FindBy(name = "filter_profession")
    public WebElement filterProfession;

    @FindBy(name = "filter_levelrangefrom")
    public WebElement filterLevelMin;

    @FindBy(name = "filter_levelrangeto")
    public WebElement filterLevelMax;

    @FindBy(css = "input[value='Apply']")
    public WebElement searchBtn;

    @FindBy(css = "#currentcharactertrades > div.Border_2 > div > div > div:nth-child(5) > table > tbody > tr > td > div > table > tbody > tr")
    public List<WebElement> resultTable;

    public List<WebElement> getResultTable() {
        return resultTable;
    }

    public int resultTableSize() {
        // 2: Additional rows
        return (resultTable.size() - 2);
    }

    public void searchBazar(String world, String pvp, String beState, String vocation, String min, String max) {
        filterLevelMin.clear();
        filterLevelMin.sendKeys(min);

        filterLevelMax.clear();
        filterLevelMax.sendKeys(max);

        Select worldFilter = new Select(filterWorld);
        worldFilter.selectByVisibleText(world);

        Select pvpType = new Select((filterPvpType));
        pvpType.selectByVisibleText(pvp);

        Select battleEyeState = new Select(filterBattleyeState);
        battleEyeState.selectByVisibleText(beState);

        Select sortBy = new Select(filterSortBy);
        sortBy.selectByVisibleText("Character Level");

        Select sortType = new Select(filterSortType);
        sortType.selectByVisibleText("highest / latest");

        Select profession = new Select(filterProfession);
        profession.selectByVisibleText(vocation);

        searchBtn.click();
    }
}
